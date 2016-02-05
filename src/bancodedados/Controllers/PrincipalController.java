/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    public static AnchorPane mCenterPainel;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        conectarAoBanco();
        
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
    
    private EventHandler<ActionEvent> criandoTB = (ActionEvent event) -> {
        //codigo sql criando bd no jdbc
    };
    
    private EventHandler<ActionEvent> popularBD = (ActionEvent event) -> {
        //chama tela
    };
    
    private EventHandler<ActionEvent> fazerConsulta = (ActionEvent event) -> {
        //chama tela
    };
    
    private EventHandler<ActionEvent> gerarProvas = (ActionEvent event) -> {
        //chamar tela para compor as questoes
    };

    private void conectarAoBanco() {
        
    }
    
    public TextArea getSqlLog(){
        return this.mTxtSqlLog;
    }
}
