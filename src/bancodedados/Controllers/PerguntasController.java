/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Bruno Barbosa
 */
public class PerguntasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane paneForTable;

    @FXML
    private ComboBox<String> cbxPerguntas;
    
    private ObservableList<ObservableList> data;
    private TableView tabela;
    
    private final Connection con = PrincipalController.bdConnect;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela = new TableView();
        data = FXCollections.observableArrayList();
        
        cbxPerguntas.getItems().add("Total de Alunos");
        cbxPerguntas.getItems().add("Total de Professores");
        cbxPerguntas.getItems().add("Quantidade de Alunos");
        cbxPerguntas.getItems().add("Quantidade de Alunas");
        cbxPerguntas.getItems().add("Turmas de cada Professor");
        cbxPerguntas.getItems().add("Disciplinas de cada Professor");
        cbxPerguntas.getItems().add("Alunos com as Disciplinas e Notas");
        cbxPerguntas.getItems().add("Alunos Aprovados nas Disciplinas");
        cbxPerguntas.getItems().add("Alunos na Final nas Disciplinas");
        cbxPerguntas.getItems().add("Alunos Reprovados nas Disciplinas");
        cbxPerguntas.getItems().add("Media de Notas do Colegio");
        cbxPerguntas.getItems().add("Gabarito das Questoes");
        
        
        cbxPerguntas.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                switch(newValue){
                    case "Total de Alunos":{String sql = "select count(nome_Aluno) from aluno; ";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Total de Professores":{String sql = "select count(nome_Professor) from professor; ";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Quantidade de Alunos":{String sql = "select sexo , count(sexo) from aluno where sexo = 'Masculino' group by sexo; ";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Quantidade de Alunas":{String sql = "select sexo , count(sexo) from aluno where sexo = 'Feminino' group by sexo; ";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Turmas de cada Professor":{String sql = "select nome_Professor,nome_Turma from professor,turma,professor_turma "
                                                                    + "where id_professor = professor_id and id_turma = turma_id order by nome_professor;";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Disciplinas de cada Professor":{String sql = "select nome_disciplina, nome_professor from disciplina,professor"
                                                                        + " where professor_id = id_professor; ";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Alunos com as Disciplinas e Notas":{String sql = "select nome_disciplina,nome_aluno,pontos from disciplina,aluno,nota "
                                                                        + "where id_disciplina = disciplina_id and aluno_matricula = matricula order by nome_disciplina;";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Alunos Aprovados nas Disciplinas":{String sql = "select nome_disciplina,nome_aluno,pontos from disciplina,aluno,nota "
                                                                        + "where id_disciplina = disciplina_id and aluno_matricula = matricula and 7 >= pontos order by nome_disciplina;";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Alunos na Final nas Disciplinas":{String sql = "select nome_disciplina,nome_aluno,pontos from disciplina,aluno,nota "
                                                                        + "where id_disciplina = disciplina_id and aluno_matricula = matricula and pontos between 4 and 6.9 order by nome_disciplina;";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Alunos Reprovados nas Disciplinas":{String sql = "select nome_disciplina,nome_aluno,pontos from disciplina,aluno,nota "
                                                                        + "where id_disciplina = disciplina_id and aluno_matricula = matricula and pontos between 0 and 3.9 order by nome_disciplina;";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Media de Notas do Colegio":{String sql = "select avg(pontos) as Media from nota;";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                    case "Gabarito das Questoes":{String sql = "select pergunta,resposta from questao,resposta where resposta_id_correta = id_resposta; ";
                                ResultSet rs = con.createStatement().executeQuery(sql);
                                criarTabelaDinamica(rs);
                                preencherTabela(rs);
                                PrincipalController.sqlLog.appendText("\n"+sql);
                                PrincipalController.sqlLog.appendText("\n----------------------------------------------------------------------------------");
                                break;}
                }
            } catch (SQLException e) {
                Alert a = new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK);
                a.show();
            }
        });
    }    

    private void criarTabelaDinamica(ResultSet rs) throws SQLException {
        if(rs != null){
            paneForTable.getChildren().clear();
            tabela.getColumns().clear();
            for(int i=0;i<rs.getMetaData().getColumnCount();i++){
                final int  j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tabela.getColumns().addAll(col);
            }
            
            AnchorPane.setTopAnchor(tabela, 20D);
            AnchorPane.setLeftAnchor(tabela, 20D);
            AnchorPane.setRightAnchor(tabela, 20D);
            paneForTable.getChildren().add(tabela);
        }
    }

    private void preencherTabela(ResultSet rs) throws SQLException {
        if(rs != null){
            data.clear();
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            tabela.setItems(data);
        }
    }
    
}
