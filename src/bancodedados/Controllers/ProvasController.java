/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import bancodedados.Prova.Prova;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    private final ToggleGroup grupo = new ToggleGroup();
    private ArrayList<Prova> corpoProva = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            //Popular cbx de alunos
            String sql = "select nome_aluno from aluno";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                    mCbxAlunos.getItems().addAll(rs.getString(i));
                }
            }
            PrincipalController.sqlLog.appendText("\n"+sql+"\t\t//Preencheu lista de Alunos");
        
            //Preencher disciplinas
            sql = "select nome_disciplina from disciplina";
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                    RadioButton r = new RadioButton(rs.getString(i));
                    r.setToggleGroup(grupo);
                    mVbxDisciplinas.getChildren().addAll(r);
                }
            }
            PrincipalController.sqlLog.appendText("\n"+sql+"\t\t//Listou as Disciplinas disponiveis");
        
        } catch (SQLException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
            a.show();
        }
        
        mBtnGerarQuestoes.setOnAction((ActionEvent event) -> {
            corpoProva.clear();
            try {
                String assunto = ((RadioButton)grupo.getSelectedToggle()).getText();
                String sqlDisciplina = "select id_disciplina from Disciplina where nome_disciplina = '"+assunto+"';";
                PrincipalController.sqlLog.appendText("\n"+sqlDisciplina);
                ResultSet idDisciplina = con.createStatement().executeQuery(sqlDisciplina);
                int id = -1;
                while(idDisciplina.next()){
                    for(int i=1;i<=idDisciplina.getMetaData().getColumnCount();i++){
                        id = Integer.parseInt(idDisciplina.getString(i));
                    }
                }
                String sqlQuestao = "select id_questao,pergunta,resposta_id_correta from questao where disciplina_id = "+id+";";
                PrincipalController.sqlLog.appendText("\n"+sqlQuestao);
                ResultSet questoes = con.createStatement().executeQuery(sqlQuestao);
                int numeroRow = 0;
                while(questoes.next()){
                    Prova p = new Prova(questoes.getString(2), Integer.parseInt(questoes.getString(3)));
                    String sqlResposta = "select resposta from Resposta where questao_id = "+questoes.getString(1)+";";
                    PrincipalController.sqlLog.appendText("\n"+sqlResposta);
                    ResultSet q = con.createStatement().executeQuery(sqlResposta);
                    while(q.next()){
                        p.getRespostas().add(q.getString(1));
                    }
                    corpoProva.add(p);
                    numeroRow++;
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                
                //criar paginas
                mPagination.setPageCount(numeroRow);
                mPagination.setPageFactory((Integer param) -> {
                    return criarPaginas(param);
                });
            } catch (SQLException e) {
                Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
                a.show();
            }
        });
      
    }    

    private AnchorPane criarPaginas(int index) {
        AnchorPane prova = new AnchorPane();
        Prova p = corpoProva.get(index);
        TextArea enunciado = new TextArea(p.getPergunta());
        VBox respostas = new VBox(5);
        ToggleGroup g = new ToggleGroup();
        for(String s : p.getRespostas()){
            RadioButton r = new RadioButton(s);
            r.setToggleGroup(g);
            respostas.getChildren().add(r);
        }
        
        g.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            newValue.setSelected(true);
        });
        
        AnchorPane.setTopAnchor(enunciado, 10D);
        AnchorPane.setLeftAnchor(enunciado, 30D);
        AnchorPane.setRightAnchor(enunciado, 30D);
        AnchorPane.setBottomAnchor(enunciado, 300D);
        
        AnchorPane.setTopAnchor(respostas, 200D);
        AnchorPane.setLeftAnchor(respostas, 300D);
        AnchorPane.setRightAnchor(respostas, 200D);
        AnchorPane.setBottomAnchor(respostas, 50D);
        
        respostas.setAlignment(Pos.CENTER_LEFT);
        prova.getChildren().addAll(enunciado,respostas);
        return prova;
    }
    
}
