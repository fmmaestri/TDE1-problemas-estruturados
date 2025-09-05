// ===== Nó para Pilha e Fila (lista encadeada) =====
class No {
    int valor;
    No prox;

    No(int v) {
        valor = v;
        prox = null;
    }
}

// ===== Pilha dinâmica (lista encadeada) =====
class Pilha {
    private No topo;

    public Pilha() {
        topo = null;
    }

    public void push(int v) { // insere
        No novo = new No(v);
        novo.prox = topo;
        topo = novo;
    }

    public int pop() { // remove
        if (topo == null) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        int removido = topo.valor;
        topo = topo.prox;
        return removido;
    }

    public void imprime() {
        No aux = topo;
        System.out.print("Pilha: ");
        while (aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.prox;
        }
        System.out.println();
    }
}

// ===== Fila dinâmica (lista encadeada) =====
class Fila {
    private No inicio, fim;

    public Fila() {
        inicio = fim = null;
    }

    public void insere(int v) { // enqueue
        No novo = new No(v);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.prox = novo;
            fim = novo;
        }
    }

    public int remove() { // dequeue
        if (inicio == null) {
            System.out.println("Fila vazia!");
            return -1;
        }
        int removido = inicio.valor;
        inicio = inicio.prox;
        if (inicio == null) fim = null;
        return removido;
    }

    public void imprime() {
        No aux = inicio;
        System.out.print("Fila: ");
        while (aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.prox;
        }
        System.out.println();
    }

    public boolean vazia() {
        return inicio == null;
    }

    public int primeiro() {
        return (inicio != null) ? inicio.valor : -1;
    }
}

// ===== Classe principal: testes =====
public class Main {
    public static void main(String[] args) {
        // ---------- Teste Pilha (lista encadeada) ----------
        Pilha pilha = new Pilha();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.imprime();
        System.out.println("Removido da pilha: " + pilha.pop());
        pilha.imprime();

        // ---------- Teste Fila (lista encadeada) ----------
        Fila fila = new Fila();
        fila.insere(1);
        fila.insere(2);
        fila.insere(3);
        fila.imprime();
        System.out.println("Removido da fila: " + fila.remove());
        fila.imprime();
    }
}
