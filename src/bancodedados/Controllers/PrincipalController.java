/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import bancodedados.BDConnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    public static Connection bdConnect;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        sqlLog = mTxtSqlLog;
        sqlLog.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            sqlLog.setScrollTop(Double.MAX_VALUE);
        });
        
        try {
            bdConnect = conectarAoBanco();
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
        String[] sqlArray = new String[6];
        
        sqlArray[0] = "Create Table Professor "
                + "(id serial primary key, "
                + "nome varchar(50))";
        sqlArray[1] = "Create Table Aluno "
                + "(id serial primary key, "
                + "nome varchar(50), "
                + "professor_id int)";
        sqlArray[2] = "Create Table Assunto "
                + "(id serial primary key, "
                + "disciplina varchar(30), "
                + "professor_id int)";
        sqlArray[3] = "Create Table Questao "
                + "(id serial primary key, "
                + "assunto_id int, "
                + "pergunta varchar(255), "
                + "resposta_id int)";
        sqlArray[4] = "Create Table Resposta "
                + "(id serial primary key, "
                + "resposta varchar(255), "
                + "questao_id int)";
        sqlArray[5] = "Create Table Nota "
                + "(id serial primary key, "
                + "nota double precision, "
                + "assunto_id int, "
                + "aluno_id int)";
        
        try{
            Statement s = bdConnect.createStatement();
            deletarTabelas(s);
            for(int i=0;i<sqlArray.length;i++){
                s.execute(sqlArray[i]);
                sqlLog.appendText("\n"+sqlArray[i]);
            }
            s.close();
            
        }catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
            a.show();
        }
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

    private Connection conectarAoBanco() throws SQLException {
        BDConnect bd = new BDConnect();
        return bd.conect();
    }

    private void deletarTabelas(Statement s) throws SQLException {
        s.execute("Drop table Professor");
        s.execute("Drop table Aluno");
        s.execute("Drop table Questao");
        s.execute("Drop table Resposta");
        s.execute("Drop table Assunto");
        s.execute("Drop table Nota");
        sqlLog.setText("Banco Resetado!!!");
    }
}
