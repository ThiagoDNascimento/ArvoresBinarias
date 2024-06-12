package app;
import lib.ArvoreBinaria;
import lib.IArvoreBinaria;

public class AppControle {

    ComparadorAlunoPorMatricula comparadorA = new ComparadorAlunoPorMatricula();
    ComparadorDisciplinaPorCodigo comparadorD = new ComparadorDisciplinaPorCodigo();

    IArvoreBinaria<Aluno> arvoreAlunos = new ArvoreBinaria(comparadorA);
    IArvoreBinaria<Disciplina> arvoreDisciplinas = new ArvoreBinaria(comparadorD);


    public void cadastrarAluno(int matricula, String nome){
        
        arvoreAlunos.adicionar(new Aluno(matricula, nome));

    }
}
