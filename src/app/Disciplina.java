package app;

import java.util.ArrayList;

public class Disciplina {

    int codigo;
    String nome;
    int cargaHoraria;
    ArrayList<String> pre = new ArrayList();

    public Disciplina(int codigo, String nome, int cargaHoraria, String pre){
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.pre.add(pre);
    }
}
