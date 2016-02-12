/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Bruno Barbosa
 */
public class PopularTabelaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    //Professor
    @FXML
    private TextField txtNomeProf;
    @FXML
    private Button btnSalvarProf;
    //Aluno
    @FXML
    private TextField txtNomeAluno;
    @FXML
    private ComboBox<String> cbxProfessorNoAluno;
    @FXML
    private Button btnSalvarAluno;
    //Assuntos
    @FXML
    private TextField txtAssunto;
    @FXML
    private ComboBox<?> cbxAssuntoProfessor;
    @FXML
    private Button btnSalvarAssunto;
    //Questoes
    @FXML
    private TextArea txtEnunciado;
    @FXML
    private ToggleGroup tgCerto;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;
    @FXML
    private TextField txtResp1;
    @FXML
    private TextField txtResp2;
    @FXML
    private TextField txtResp3;
    @FXML
    private TextField txtResp4;
    @FXML
    private Button btnSalvarQuestao;
    //Auto
    @FXML
    private Button btnGerarAuto;
    
    private Connection con = PrincipalController.bdConnect;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnGerarAuto.setOnAction((ActionEvent event) -> {
            
            String[] professores = {"Roberto","Cesar","Barroso"};
            String[] alunos = new String[5];
            String[] assuntos = new String[5];
            
            try {
                Statement s = con.createStatement();
                
            } catch (SQLException ex) {
                Logger.getLogger(PopularTabelaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }    
    
}
