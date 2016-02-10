/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
