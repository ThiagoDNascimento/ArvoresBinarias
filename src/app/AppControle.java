package app;
import java.util.ArrayList;
import java.util.Comparator;

import lib.ArvoreBinaria;
import lib.IArvoreBinaria;
import lib.No;

public class AppControle {

    static ComparadorAlunoPorMatricula comparadorAM = new ComparadorAlunoPorMatricula();
    static ComparadorAlunoPorNome comparadorAN = new ComparadorAlunoPorNome();
    ComparadorDisciplinaPorCodigo comparadorDC = new ComparadorDisciplinaPorCodigo();
    ComparadorDisciplinaPorNome comparadorDN = new ComparadorDisciplinaPorNome();

    static IArvoreBinaria<Aluno> arvoreAlunos = new ArvoreBinaria(comparadorAM);
    IArvoreBinaria<Disciplina> arvoreDisciplinas = new ArvoreBinaria(comparadorDC);


    public static void cadastrarAluno(int matricula, String nome){ 
        arvoreAlunos.adicionar(new Aluno(matricula, nome));
    }

    public void cadastrarDisciplina(int codigo, String nome, int cargaHoraria, ArrayList<Disciplina> pre){
        arvoreDisciplinas.adicionar(new Disciplina(codigo, nome, cargaHoraria, pre));
    }

    public void informarPre(Disciplina disc1, Disciplina disc2){
       arvoreDisciplinas.pesquisar(disc1, comparadorDN);
    }

    public static void consultarNome(String nome){
        System.out.println(arvoreAlunos.pesquisar(new Aluno(0, nome), comparadorAN));
    }

    public static void consultarMatricula(int matricula){
        System.out.println(arvoreAlunos.pesquisar(new Aluno(matricula, null), comparadorAM));
    }

    public static void main(String[] args) {
        
        cadastrarAluno(1,"thiago");
        cadastrarAluno(2, "caio");

        consultarNome("thiago");
        consultarNome("caio");
        consultarMatricula(1);
        consultarMatricula(2);
    }
}
