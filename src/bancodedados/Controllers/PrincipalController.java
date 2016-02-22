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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        
        mBtnEstruturaBD.setOnAction(mostrarEstrutura);
    }    
    
    private final EventHandler<ActionEvent> criandoTB = (ActionEvent event) -> {
        //codigo sql criando tables no db
        String[] sqlArray = new String[8];
        
        sqlArray[0] = "Create Table Professor "
                + "(id_Professor serial primary key, "
                + "nome_professor varchar(50) not null)";
        
        sqlArray[1] = "Create Table Professor_Turma "
                + "(professor_id int not null, "
                + "turma_id int not null)";
        
        sqlArray[2] = "Create Table Turma "
                + "(id_Turma serial primary key, "
                + "nome_turma varchar(2) not null)";
        
        sqlArray[3] = "Create Table Aluno "
                + "(matricula serial primary key, "
                + "nome_aluno varchar(50) not null, "
                + "sexo varchar(10) not null, "
                + "turma_id int not null)";
        
        sqlArray[4] = "Create Table Disciplina "
                + "(id_Disciplina serial primary key, "
                + "nome_disciplina varchar(30) not null, "
                + "professor_id int not null)";
        
        sqlArray[5] = "Create Table Questao "
                + "(id_Questao serial primary key, "
                + "disciplina_id int not null, "
                + "pergunta text not null, "
                + "resposta_id_correta int)";
        
        sqlArray[6] = "Create Table Resposta "
                + "(id_Resposta serial primary key, "
                + "resposta text not null, "
                + "questao_id int)";
        
        sqlArray[7] = "Create Table Nota "
                + "(id_Nota serial primary key, "
                + "pontos double precision not null, "
                + "disciplina_id int not null, "
                + "aluno_matricula int not null)";
        
        try{
            Statement s = bdConnect.createStatement();
            deletarTabelas(s);
            for(int i=0;i<sqlArray.length;i++){
                s.execute(sqlArray[i]);
                sqlLog.appendText("\n"+sqlArray[i]);
            }
            s.close();
            sqlLog.appendText("\n----------------------------------------------------------------------------------");
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

    private void deletarTabelas(Statement s){
        try{
            s.execute("Drop table Professor");
            s.execute("Drop table Professor_Turma");
            s.execute("Drop table Turma");
            s.execute("Drop table Aluno");
            s.execute("Drop table Questao");
            s.execute("Drop table Resposta");
            s.execute("Drop table Disciplina");
            s.execute("Drop table Nota");
            sqlLog.setText("Banco Resetado!!!");
        }catch(SQLException e){
            return;
        }
    }
    
    private final EventHandler<ActionEvent> mostrarEstrutura = (ActionEvent e) ->{
        Stage st = new Stage();
        Parent p = new AnchorPane(new ImageView(new Image("/bancodedados/Model_db_colegio.png")));
        Scene c = new Scene(p,1091,617);
        st.setScene(c);
        st.setTitle("Modelo do Banco de Dados");
        st.show();
    };
}
