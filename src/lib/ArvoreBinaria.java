/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 
  
    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }
    
    @Override
    public void adicionar(T novoValor) {
        No<T> novoNo = new No<T>(novoValor); //cria novoNo
        if(this.raiz == null){ //se a raiz for null, nao existe raiz
            this.raiz = novoNo;
        }else{ //se existir raiz chama o metodo adicionar passando a raiz e o novoNo
            this.raiz = adicionar(this.raiz, novoNo);
        }
    }
    protected No<T> adicionar(No<T> atual, No<T> novoNo) {
        if (comparador.compare(novoNo.getValor(), atual.getValor()) < 0) { //Se o novoNo for menor que o atual, vai pra esquerda
            if(atual.getFilhoEsquerda() == null){ //Se não existir no à esquerda, adiciona o novoNo
                atual.setFilhoEsquerda(novoNo);
            }else{ //se existir no à esquerda, chama o metodo para comparar o novoNo com o no existente
                atual.setFilhoEsquerda(adicionar(atual.getFilhoEsquerda(), novoNo));
            }
        }else{ //Se o novoNo for maior ou igual que o atual, vai pra direita
            if(atual.getFilhoDireita == null){ //Se não existir no à direita, adiciona o novoNo
                atual.setFilhoDireita(novoNo);
            }else{ //se existir no à direita, chama o metodo para comparar o novoNo com o no existente
                atual.setFilhoDireita(adicionar(atual.getFilhoDireita(), novoNo));
            }
        }
        return atual;
    }

    @Override
    public T pesquisar(T valor) {
        No<T> atual = this.raiz;
        while (atual != null) {
            if (atual.getValor().equals(valor)) {
                return atual.getValor();
            } else if (comparador.compare(atual.getValor(), valor) < 0) { // se for menor vai pra esquerda
                atual.getFilhoEsquerda();
            } else { // se for maior vai pra direita
                atual.getFilhoDireita();
            }
        }
        return null;
    }

   @Override
    public T pesquisar(T valor, Comparator comparador) { //varrer a arvore inteira até achar o elemento, 
        return pesquisarRec(this.raiz,valor,comparador);
    }
    private T pesquisarRec(No<T> r, T valor, Comparator comparador){ //teste, professor
        if(r == null){
            return null;
        }
        if(Comparador.compare(valor,r.getValor()) == 0){
            return raiz.getValor();
        }else{ //varre a arvore inteira
            no<t> rD = pesquisarRec(r.getFilhoDireita,valor,comparador);
            no<t> dE = pesquisarRec(r.getFilhoEsquerda,valor,comparador);
            if(rD != null){
                return rD;
            }else if(rE != null){
                return rE;
            }else{
                return null;
            }
        }
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        return this.raiz.obterAltura();
    }
       
    
    @Override
    public int quantidadeNos() {
        return quantidadeNos(this.raiz);
    }

    private int quantidadeNos(No<T> no){
        if(no == null){
            return 0;
        }else{
            return 1 + quantidadeNos(no.getFilhoEsquerda) + quantidadeNos(no.getFilhoDireita); 
        }
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
        
}
