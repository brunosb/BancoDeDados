/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.Prova;

import java.util.ArrayList;

/**
 *
 * @author Bruno Barbosa
 */
public class Prova {
    String pergunta;
    int resposta; //Referente ao id do banco
    ArrayList<String> respostas;

    public Prova(String pergunta, int resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        respostas = new ArrayList<>();
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }
    
    
}
