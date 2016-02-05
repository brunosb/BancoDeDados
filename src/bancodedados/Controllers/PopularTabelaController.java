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
    
    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb3;

    @FXML
    private Button btnSalvarQuestao;

    @FXML
    private RadioButton rb2;

    @FXML
    private Button btnSalvarProf;

    @FXML
    private RadioButton rb4;

    @FXML
    private TextField txtResp1;

    @FXML
    private TextField txtResp3;

    @FXML
    private ComboBox<?> cbxProfessorNoAluno;

    @FXML
    private TextArea txtEnunciado;

    @FXML
    private TextField txtResp2;

    @FXML
    private Button btnSalvarAluno;

    @FXML
    private Button btnGerarAuto;

    @FXML
    private ToggleGroup tgCerto;

    @FXML
    private TextField txtResp4;

    @FXML
    private TextField txtNomeProf;

    @FXML
    private TextField txtNomeAluno;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
