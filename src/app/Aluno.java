package app;

import java.util.ArrayList;

/**
 *
 * @author victoriocarvalho
 * 
 * Essa é a classe Aluno que será utilizada como tipo do conteúdo das árvores nos 
 * programas de teste para redigir os relatórios.
 */

public class Aluno  {
    private int matricula;
    private String nome;
    private ArrayList<Disciplina> disciplinas;

    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;      
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "\nAluno: "+ nome + " - Matricula: "+matricula;
    }

    public ArrayList<Disciplina> getPre() {
        return this.disciplinas;
    }

    public void setPre(Disciplina pre) {
        this.disciplinas.add(pre);
    }

}
