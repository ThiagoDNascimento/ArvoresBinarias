package app;

import java.util.Comparator;

public class ComparadorDisciplinaPorCodigo implements Comparator<Disciplina>{

    public int compare(Disciplina o1, Disciplina o2){

        return Integer.compare(o1.getCodigo(), o2.getCodigo());

    } 

    
}
