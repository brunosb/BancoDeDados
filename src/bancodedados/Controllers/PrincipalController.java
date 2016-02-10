/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import bancodedados.BDConnect;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Bruno Barbosa
 */
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public AnchorPane mCenterPainel;

    @FXML
    private Button mBtnEstruturaBD;

    @FXML
    private ToolBar mToolBar;

    @FXML
    private TextArea mTxtSqlLog;

    
    private Button btnCriarTables;
    private Button btnPopularTabelas;
    private Button btnFazerConsulta;
    private Button btnGerarProvas;
    public static TextArea sqlLog;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        sqlLog = mTxtSqlLog;
        
        try {
            conectarAoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btnCriarTables = new Button("Criar Tabelas");
        btnCriarTables.setOnAction(criandoTB);
        
        btnPopularTabelas = new Button("Popular");
        btnPopularTabelas.setOnAction(popularBD);
        
        btnFazerConsulta = new Button("Fazer Consulta");
        btnFazerConsulta.setOnAction(fazerConsulta);
        
        btnGerarProvas = new Button("Gerar Provas");
        btnGerarProvas.setOnAction(gerarProvas);
        
        mToolBar.getItems().addAll(btnCriarTables,btnPopularTabelas,btnFazerConsulta,btnGerarProvas);
    }    
    
    private final EventHandler<ActionEvent> criandoTB = (ActionEvent event) -> {
        //codigo sql criando bd no jdbc
    };
    
    private final EventHandler<ActionEvent> popularBD = (ActionEvent event) -> {
        try{
            Parent root = FXMLLoader.load(PopularTabelaController.class.getResource("/bancodedados/Telas/PopularTabela.fxml"));
            mCenterPainel.getChildren().clear();
            mCenterPainel.getChildren().add(root);
        }catch(Exception e){
            e.getMessage();
        }
    };
    
    private final EventHandler<ActionEvent> fazerConsulta = (ActionEvent event) -> {
        try{
            Parent root = FXMLLoader.load(PopularTabelaController.class.getResource("/bancodedados/Telas/Perguntas.fxml"));
            mCenterPainel.getChildren().clear();
            mCenterPainel.getChildren().add(root);
        }catch(Exception e){
            e.getMessage();
        }
    };
    
    private final EventHandler<ActionEvent> gerarProvas = (ActionEvent event) -> {
        try{
            Parent root = FXMLLoader.load(PopularTabelaController.class.getResource("/bancodedados/Telas/Provas.fxml"));
            mCenterPainel.getChildren().clear();
            mCenterPainel.getChildren().add(root);
        }catch(Exception e){
            e.getMessage();
        }
    };

    private void conectarAoBanco() throws SQLException {
        BDConnect bd = new BDConnect();
        bd.conect();
    }
}
