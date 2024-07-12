package app;

import java.util.ArrayList;

public class Disciplina {

    int codigo;
    String nome;
    int cargaHoraria;
    ArrayList<Disciplina> pre = new ArrayList<Disciplina>();

    public Disciplina(int codigo, String nome, int cargaHoraria){
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
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

    public ArrayList<Disciplina> getPre() {
        return pre;
    }

    public void setPre(Disciplina pre) {
        this.pre.add(pre);
    }

    @Override
    public String toString(){
        return "\nCodigo: "+ codigo + " - Nome: "+nome+" pre: "+pre;
    }
    
}
