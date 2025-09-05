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

// ===== MERGE de duas filas ordenadas (usando a Fila dinâmica) =====
class Merge {
    public static Fila mergeFilas(Fila A, Fila B) {
        Fila C = new Fila();

        while (!A.vazia() && !B.vazia()) {
            if (A.primeiro() <= B.primeiro())
                C.insere(A.remove());
            else
                C.insere(B.remove());
        }
        while (!A.vazia()) C.insere(A.remove());
        while (!B.vazia()) C.insere(B.remove());

        return C;
    }
}

// ===== MERGE usando vetores (arrays) =====
class MergeArray {
    public static int[] mergeVetores(int[] A, int[] B) {
        int nA = A.length;
        int nB = B.length;
        int[] C = new int[nA + nB];

        int i = 0; // índice de A
        int j = 0; // índice de B
        int k = 0; // índice de C

        while (i < nA && j < nB) {
            if (A[i] <= B[j]) {
                C[k] = A[i];
                i++;
            } else {
                C[k] = B[j];
                j++;
            }
            k++;
        }

        // Copia o restante (se sobrar) de A
        while (i < nA) {
            C[k] = A[i];
            i++;
            k++;
        }

        // Copia o restante (se sobrar) de B
        while (j < nB) {
            C[k] = B[j];
            j++;
            k++;
        }

        return C;
    }

    // Utilitário simples para imprimir vetor
    public static void imprimeVetor(int[] V, String titulo) {
        System.out.print(titulo);
        for (int x = 0; x < V.length; x++) {
            System.out.print(V[x]);
            if (x < V.length - 1) System.out.print(" ");
        }
        System.out.println();
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
          // ---------- Teste MERGE com Filas (lista encadeada) ----------
        Fila A = new Fila();
        A.insere(12); A.insere(35); A.insere(52); A.insere(64);
        Fila B = new Fila();
        B.insere(5); B.insere(15); B.insere(23); B.insere(55); B.insere(75);
        System.out.print("Fila A: ");
        A.imprime();
        System.out.print("Fila B: ");
        B.imprime();
        Fila C = Merge.mergeFilas(A, B);
        System.out.print("Fila C (merge de filas): ");
        C.imprime();

        // ---------- Teste MERGE com Vetores (arrays) ----------
        int[] VA = {12, 35, 52, 64};
        int[] VB = {5, 15, 23, 55, 75};
        int[] VC = MergeArray.mergeVetores(VA, VB);

        MergeArray.imprimeVetor(VA, "Vetor A: ");
        MergeArray.imprimeVetor(VB, "Vetor B: ");
        MergeArray.imprimeVetor(VC, "Vetor C (merge de vetores): ");
    }
}
