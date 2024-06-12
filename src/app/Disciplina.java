package app;

import java.util.ArrayList;

public class Disciplina {

    int codigo;
    String nome;
    int cargaHoraria;
    ArrayList<String> pre = new ArrayList<String>();

    public Disciplina(int codigo, String nome, int cargaHoraria, ArrayList<String> pre){
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.pre.addAll(pre);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<String> getPre() {
        return pre;
    }

    public void setPre(ArrayList<String> pre) {
        this.pre = pre;
    }

    
}