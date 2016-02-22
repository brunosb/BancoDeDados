/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import bancodedados.Utilitarios.ScriptPopular;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

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
    //Turma
    @FXML
    private VBox vbProfessoresTurma;
    @FXML
    private TextField txtNomeTurma;
    @FXML
    private Button btnSalvarTurma;
    //Aluno
    @FXML
    private TextField txtNomeAluno;
    @FXML
    private ComboBox<String> cbxSexoAluno;
    @FXML
    private ComboBox<String> cbxTurmaAluno;
    @FXML
    private Button btnSalvarAluno;
    //Assuntos
    @FXML
    private TextField txtAssunto;
    @FXML
    private ComboBox<String> cbxAssuntoProfessor;
    @FXML
    private Button btnSalvarAssunto;
    //Questoes
    @FXML
    private ComboBox<String> cbxDisciplinaQuestao;
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
    private Statement stm;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
        try {
            stm = con.createStatement();
        } catch (SQLException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
            a.show();
        }
        
         try {
            //Carregando itens das tabs
            String sql = "select nome_Professor from professor";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                vbProfessoresTurma.getChildren().add(new CheckBox(rs.getString(1)));
                cbxAssuntoProfessor.getItems().add(rs.getString(1));
            }
            PrincipalController.sqlLog.appendText("\n"+sql);
            cbxSexoAluno.getItems().addAll("Masculino","Feminino");
            sql = "select nome_Turma from Turma";
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                cbxTurmaAluno.getItems().add(rs.getString(1));
            }
            PrincipalController.sqlLog.appendText("\n"+sql);
            sql = "select nome_Disciplina from disciplina";
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                cbxDisciplinaQuestao.getItems().add(rs.getString(1));
            }
            PrincipalController.sqlLog.appendText("\nCarregamento dos elementos da tela..........OK");
            PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
        } catch (SQLException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
            a.show();
        }
        
        btnGerarAuto.setOnAction((ActionEvent event) -> {
            ScriptPopular script = new ScriptPopular();
            
            String[] professores = script.getProfessores();
            String[] turmas = script.getTurmas();
            String[] alunos = script.getAlunos();
            String[] disciplinas = script.getDisciplinas();
            String[] questoes = script.getQuestoes();
            String[] respostas = script.getRespostas();
            String[] sqlUpdade = script.getSqlUpdade();
            
            try {
                String sql = "";
                
                //Professores
                for(int i=0;i<professores.length;i++){
                    sql = "insert into professor (nome_professor) values ('"+professores[i]+"')";
                    stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                
                //Turmas
                for(int i=0;i<turmas.length;i++){
                    sql = "insert into turma (nome_turma) values ('"+turmas[i]+"')";
                    stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                
                //Professor_Turma
                for(int i=1;i<=professores.length;i++){
                    int max = 1;
                    while(max<=3){
                        sql = "insert into professor_turma (professor_id,turma_id) values ('"+i+"',"+sorteio(1, (turmas.length), new Random())+")";
                        stm.execute(sql);
                        PrincipalController.sqlLog.appendText("\n"+sql);
                        max++;
                    }
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                
                //Alunos
                for(int i=0;i<alunos.length;i++){
                    if(i<28){
                        sql = "insert into aluno (nome_aluno,sexo,turma_id) values ('"+alunos[i]+"','Masculino',"+sorteio(1, turmas.length, new Random())+")";
                    }else{
                        sql = "insert into aluno (nome_aluno,sexo,turma_id) values ('"+alunos[i]+"','Feminino',"+sorteio(1, turmas.length, new Random())+")";
                    }
                    stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
            
                //Disciplinas
                for(int i=0;i<disciplinas.length;i++){
                    sql = "insert into disciplina (nome_disciplina,professor_id) values ('"+disciplinas[i]+"',"+sorteio(1, professores.length, new Random())+")";
                    stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
            
                //Questoes
                int ass = 1;//controle de assunto
                int quest = 0;//controle de questao
                for(int i=0;i<questoes.length;i++){
                    quest++;
                    sql = "insert into questao (disciplina_id,pergunta) values ("+ass+",'"+questoes[i]+"')";
                    stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                    if(quest == 3){
                        quest = 0;
                        ass++;
                    }
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                
                //Respostas
                int ques = 1;//controle do id da questao
                int resp = 0;
                for(int i=0;i<respostas.length;i++){
                    resp++;
                    sql = "insert into resposta (resposta,questao_id) values ('"+respostas[i]+"',"+ques+")";
                    stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                    if(resp == 4){
                        resp = 0;
                        ques++;
                    }
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                
                //Atualizando Questoes
                for(int i=0;i<sqlUpdade.length;i++){
                    stm.execute(sqlUpdade[i]);
                    PrincipalController.sqlLog.appendText("\n"+sqlUpdade[i]);
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                
                //Notas
                for(int i=0;i<=alunos.length-1;i++){
                    for(int j=0;j<=disciplinas.length-1;j++){
                        sql = "insert into nota (pontos, disciplina_id, aluno_matricula) values ("+sorteioNota(0, 10, new Random())+","+(j+1)+","+(i+1)+")";
                        stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                    }
                }
                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
            
            } catch (SQLException e) {
                Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
                a.show();
            }
            
        });
        
        //Salvando Professores
        btnSalvarProf.setOnAction((ActionEvent event) -> {
            if(txtNomeProf.getText().equals("")){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Campos Obrigatórios em Branco!", ButtonType.OK);
                alerta.show();
            }else{
                try {
                    String sql = "insert into professor (nome_professor) values ('"+txtNomeProf.getText()+"')";
                    stm.execute(sql);
                    PrincipalController.sqlLog.appendText("\n"+sql);
                    PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                } catch (SQLException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
                    a.show();
                }
            }
        });
       
        //Salvando Turma
        btnSalvarTurma.setOnAction((ActionEvent event) -> {
            if(txtNomeTurma.getText().equals("")){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Campos Obrigatórios em Branco!", ButtonType.OK);
                alerta.show();
            }else{
                try{
                    String sql = "insert into turma (nome_Turma) values ('"+txtNomeTurma.getText()+"')";
                    stm.execute(sql);
                    ArrayList<String> selecionados = new ArrayList<>();
                    for(Node n : vbProfessoresTurma.getChildren()){
                        if(n instanceof CheckBox){
                            CheckBox cb = (CheckBox)n;
                            if(cb.isSelected()){
                                selecionados.add(cb.getText());
                            }
                        }
                    }
                }catch (SQLException e){
                    Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
                    a.show();
                }
            }
        });
    }    

    private int sorteio(int start, int end, Random random) {
        long range = (long)end - (long)start + 1;
        long fraction = (long)(range * random.nextDouble());
        int randomNumber =  (int)(fraction + start); 
        return randomNumber;
    }
    
    private double sorteioNota(int start, int end, Random random){
        long range = (long)end - (long)start + 1;
        long fraction = (long)(range * random.nextDouble());
        double randomNumber =  (double)(fraction + start); 
        return randomNumber;
    }
    
}
