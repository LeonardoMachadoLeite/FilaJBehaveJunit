package model;

import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

import exceptions.FilaVaziaException;


/**
 *
 * @author Efraim
 */
public class FilaEncadeada<T> implements Iterable<T>{
    private int size = 0;
    private Integer tamanhoMax = 8;
    private NoSimples noInicial, noFinal;

    
    /* Métodos padrões de coleção */
    
    /**
     *  Retorna a quantidade de elementos na fila. 
     */
    public int tamanho() {
        return this.size;
    }

    public boolean contem(T elemento) {
        for (T i : this) {
            if (i.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public void limpar() {
        this.noInicial = null;
        this.size = 0;
    }

    public boolean vazio() {
    	Queue q = new LinkedList();
        return this.size == 0;
    }
    
    public Iterator<T> iterator() {
        return new Iterador();
    }

    /* Métodos de fila */
    
    public void enfileirar(T elemento) {
    	if (this.size >= this.tamanhoMax) {
    		return;
    	}
        if (this.noInicial == null) {
            this.noInicial = new NoSimples(elemento);
            this.noFinal = this.noInicial;
            size++;
            return;
        }
        this.noFinal = new NoSimples(elemento, this.noFinal);
        size++;
    }

    public T desenfileirar() throws FilaVaziaException{
        if (this.noInicial == null) {
            throw new FilaVaziaException();
        }
        T ans = this.noInicial.getElemento();
        this.noInicial = this.noInicial.getProxNo();
        size--;
        return ans;
    }

    public T primeiro() {
        return this.noInicial.getElemento();
    }

    public T ultimo() {
        return this.noFinal.getElemento();
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        if (this.size <= tamanhoMaximo) {
            this.tamanhoMax = tamanhoMaximo;
        }
    }
    
    /* Nó e iterador */
    
    private class NoSimples {
        private T elemento;
        private NoSimples proxNo;
        public NoSimples(T elemento) {
            this.elemento = elemento;
        }
        public NoSimples(T elemento, NoSimples proxNo) {
            this(elemento);
            this.proxNo = proxNo;
        }
        public T getElemento() {
            return this.elemento;
        }
        public NoSimples getProxNo() {
            return this.proxNo;
        }
    }
    
    private class Iterador implements Iterator<T> {
        NoSimples noAtual = noInicial;
        boolean first = true;
        
        public boolean hasNext() {
            if (first) {
                return noAtual != null;
            }
            return noAtual.getProxNo() != null;
        }
        
        public T next() {
            if (first) {
                first = false;
                return noAtual.getElemento();
            } else {
                noAtual = noAtual.getProxNo();
                return noAtual.getElemento();
            }
        }
        
    }
}
