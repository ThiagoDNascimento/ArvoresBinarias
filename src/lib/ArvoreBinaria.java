/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.ArrayList;
import java.util.Comparator;

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
            if(atual.getFilhoDireita() == null){ //Se não existir no à direita, adiciona o novoNo
                atual.setFilhoDireita(novoNo);
            }else{ //se existir no à direita, chama o metodo para comparar o novoNo com o no existente
                atual.setFilhoDireita(adicionar(atual.getFilhoDireita(), novoNo));
            }
        }
        return atual;
    }

    @Override
    public T pesquisar(T valor){    
        return pesquisar(this.raiz,valor);
    }

    protected T pesquisar(No<T> atual,T valor){
        if(atual == null){  
            return null;
        }
        if(comparador.compare(atual.getValor(), valor) == 0){
            return atual.getValor(); 
        }else if(comparador.compare(atual.getValor(), valor) < 0){
            return pesquisar(atual.getFilhoEsquerda(),valor);
        }else{
            return pesquisar(atual.getFilhoDireita(),valor);
        }

    }

   @Override
    public T pesquisar(T valor, Comparator comparador) { //varrer a arvore inteira até achar o elemento, 
        return pesquisarRec(this.raiz,valor,comparador);
    }
    private T pesquisarRec(No<T> r, T valor, Comparator comparador) { //teste, professor
        if (r == null) {
            return null;
        }
        if (comparador.compare(valor,r.getValor()) == 0) {
            return r.getValor();
        } else { //varre a arvore inteira
            T rD = pesquisarRec(r.getFilhoDireita(),valor,comparador); 
            T rE = pesquisarRec(r.getFilhoEsquerda(),valor,comparador); 
            if (rD != null) {
                return rD;
            } else if (rE != null) {
                return rE;
            } else {
                return null;
            }
        }
    }

    @Override
    public T remover(T valor) {
        return removerRec(this.raiz, valor, comparador);
    }
    private T removerRec(No<T> r, T valor, Comparator comparator){
        No<T> atual = this.raiz;
        No<T> noPaiAtual = null;
        if(r == null){
            return null;
        }
        else if(r.getValor().equals(valor)){ //Se o valor foi igual então achou o nó a ser removido
            if(r.getFilhoDireita() == null && r.getFilhoEsquerda() == null){ //se for nó folha, remove
                r = null; 
            }
            else if(r.getFilhoDireita() != null && r.getFilhoEsquerda() != null){ //se tiver nó a esquerda e a direita, pega o menos dos maiores e coloca no lugar
                

            }

        }
        else if(comparador.compare(valor, r.getValor()) < 0){
            removerRec(r.getFilhoEsquerda(), valor, comparator);
        }
        //else if(comparador.compare(valor, this.raiz.getValor()) < 0){ //se for menor vai pra esquerda
        return null;
    }

    private T menorElemento(No<T> raiz) {
        while (raiz.getFilhoEsquerda() != null) { // percorre até nao ter mais filho a esquerda
            raiz = raiz.getFilhoEsquerda();
        }
        return raiz.getValor(); // retorna o menor valor
    }

    private T maiorElemento(No<T> raiz) {
        while (raiz.getFilhoDireita() != null) { // percorre até nao ter mais filho a direita
            raiz = raiz.getFilhoDireita();
        }
        return raiz.getValor(); // retorna o maior valor
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
            return 1 + quantidadeNos(no.getFilhoEsquerda()) + quantidadeNos(no.getFilhoDireita()); 
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
