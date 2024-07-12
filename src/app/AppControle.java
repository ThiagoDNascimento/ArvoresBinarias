package app;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import lib.ArvoreBinaria;
import lib.IArvoreBinaria;
import lib.No;

public class AppControle {

    static ComparadorAlunoPorMatricula comparadorAM = new ComparadorAlunoPorMatricula();
    static ComparadorAlunoPorNome comparadorAN = new ComparadorAlunoPorNome();
    static ComparadorDisciplinaPorCodigo comparadorDC = new ComparadorDisciplinaPorCodigo();
    static ComparadorDisciplinaPorNome comparadorDN = new ComparadorDisciplinaPorNome();

    static IArvoreBinaria<Aluno> arvoreAlunos = new ArvoreBinaria(comparadorAM);
    static IArvoreBinaria<Disciplina> arvoreDisciplinas = new ArvoreBinaria(comparadorDC);


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        int matricula, codigo, codigo2, cargaHoraria;
        String nome;
        String texto = 
        "\nEscolha um número entre 1 a 8" +
        "\n1 - Cadastrar Aluno" +
        "\n2 - Cadastrar Disciplina"+
        "\n3 - Informar pré-requisito"+
        "\n4 - Informar Disciplina cursada"+
        "\n5 - Consultar Aluno por Nome"+
        "\n6 - Consultar Aluno por Matrícula"+
        "\n7 - Excluir Aluno por Matrícula"+
        "\n8 - Sair";
        
        while(numero != 8){
            System.out.println(texto);
            numero = entrada.nextInt();
            switch (numero) {
                case 1: //Cadastrar Aluno: cria o registro de um aluno;
                    System.out.println("Informe a matricula");
                    matricula = entrada.nextInt();
                    System.out.println("Informe o nome");
                    nome = entrada.next();
                    arvoreAlunos.adicionar(new Aluno(matricula, nome));
                    System.out.println("Aluno criado");
                    break;
                case 2: //Cadastrar Disciplina: cria o registro de uma disciplina;
                    System.out.println("Informe o codigo");
                    codigo = entrada.nextInt();
                    System.out.println("Informe o nome");
                    nome = entrada.next();
                    System.out.println("Informe a carga horaria");
                    cargaHoraria = entrada.nextInt();
                    arvoreDisciplinas.adicionar(new Disciplina(codigo, nome, cargaHoraria));
                    break;
                case 3: //Informar pré-requisito: dadas duas disciplinas previamente cadastradas, registra que a primeira é pré-requisito da segunda.
                    System.out.println("Informe a primeira disciplina");
                    codigo = entrada.nextInt();
                    System.out.println("Informe a segunda disciplina");
                    codigo2 = entrada.nextInt();
                    Disciplina disc1 = arvoreDisciplinas.pesquisar(new Disciplina(codigo, "", 0));
                    Disciplina disc2 = arvoreDisciplinas.pesquisar(new Disciplina(codigo2, "", 0));
                    disc2.setPre(disc1);
                    System.out.println(disc2);
                    break;
                case 4: //Informar Disciplina cursada: Dado um aluno e uma disciplina previamente cadastrados, verifica se o aluno cursou todos os pré-requisitos da disciplina dada e, caso positivo, registra que o aluno cursou tal disciplina. Caso contrário exibe uma mensagem informando as disciplinas não cursadas.
                    break;
                case 5: //Consultar Aluno por Nome: Dado o nome do aluno imprime todos os dados do mesmo, inclusive as disciplinas já cursadas (código e nome de cada disciplina cursada).
                    System.out.println("Informe o nome do aluno");
                    nome = entrada.next();
                    System.out.println(arvoreAlunos.pesquisar(new Aluno(0, nome), comparadorAN));
                    break;
                case 6: //Consultar Aluno por Matrícula: Dada a matrícula do aluno imprime todos os dados do mesmo, inclusive as disciplinas já cursadas (código e nome de cada disciplina cursada).
                    System.out.println("Informe a matricula do aluno");
                    matricula = entrada.nextInt();
                    System.out.println(arvoreAlunos.pesquisar(new Aluno(matricula, null)));
                    break;
                case 7: //Excluir Aluno por Matrícula: Dada a matrícula, exclui o aluno.
                    System.out.println("Informe a matricula do aluno que deseja excluir");
                    matricula = entrada.nextInt();
                    arvoreAlunos.remover(new Aluno(matricula,null));
                    break;
                case 8: //Sair
                    System.out.println("Saindo");
                    break;
                default:
                    break;
            }

        }
        
        entrada.close();
    }
}
