/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Bruno Barbosa
 */
public class PerguntasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane paneForTable;

    @FXML
    private ComboBox<String> cbxPerguntas;
    
    private ObservableList<ObservableList> data;
    private TableView tabela;
    
    private final Connection con = PrincipalController.bdConnect;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela = new TableView();
        data = FXCollections.observableArrayList();
        
        cbxPerguntas.getItems().add("Teste");
        
        cbxPerguntas.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                switch(newValue){
                    case "Teste":{String sql = "select nome from aluno";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                
                }
            } catch (SQLException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
                    a.show();
                }
        });
    }    

    private void criarTabelaDinamica(ResultSet rs) throws SQLException {
        if(rs != null){
            paneForTable.getChildren().clear();
            
            for(int i=0;i<rs.getMetaData().getColumnCount();i++){
                final int  j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tabela.getColumns().addAll(col);
            }
            
            AnchorPane.setTopAnchor(tabela, 20D);
            AnchorPane.setLeftAnchor(tabela, 20D);
            AnchorPane.setRightAnchor(tabela, 20D);
            paneForTable.getChildren().add(tabela);
        }
    }

    private void preencherTabela(ResultSet rs) throws SQLException {
        if(rs != null){
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            tabela.setItems(data);
        }
    }
    
}
