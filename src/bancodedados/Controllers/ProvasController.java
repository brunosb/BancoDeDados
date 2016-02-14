/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Bruno Barbosa
 */
public class ProvasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox<String> mCbxAlunos;

    @FXML
    private VBox mVbxDisciplinas;

    @FXML
    private Button mBtnGerarQuestoes;

    @FXML
    private Button mBtnSProva;

    @FXML
    private Pagination mPagination;
    
    private Connection  con = PrincipalController.bdConnect;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Popular cbx de alunos
        
        
    }    
    
}
