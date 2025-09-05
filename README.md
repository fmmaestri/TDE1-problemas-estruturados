# TDE1-problemas-estruturados

LEIA-ME — TDE 1: Manipulação de Pilhas e Filas Dinâmicas (Java)

Este repositório contém a implementação em Java puro das atividades solicitadas no TDE 1 — Manipulação de Pilhas e Filas Dinâmicas, incluindo:
1. Pilha com lista encadeada (métodos push, pop, imprime).
2. Fila com lista encadeada (métodos insere, remove, imprime).
3. Merge (junção ordenada) de duas filas ordenadas gerando uma terceira fila ordenada (listas encadeadas).
4. Merge com vetores (arrays) — segunda implementação do merge com estruturas estáticas (vetores).

Observações do enunciado atendidas:  
- Ao remover, o programa informa o elemento removido (ex.: Removido da pilha: 30 / Removido da fila: 1).  
- O usuário tem liberdade para introduzir novos elementos: basta alterar as chamadas no main (modo demonstração) ou usar o modo interativo opcional descrito abaixo.  
- Implementação com tipos primitivos e listas encadeadas feitas à mão (sem ArrayList, Vector, StringBuilder, etc.).

--------------------------------------------------

Estrutura dos Arquivos

- Main.java: arquivo único contendo todas as classes:
  - No — nó da lista encadeada (valor + referência prox).
  - Pilha — implementação dinâmica com encadeamento (LIFO).
  - Fila — implementação dinâmica com encadeamento (FIFO).
  - Merge — merge de filas ordenadas (lista encadeada) em uma terceira fila ordenada.
  - MergeArray — merge de vetores (int[]).
  - Main — método main com casos de teste (demonstração).

Mantivemos tudo em um arquivo para facilitar a compilação e a correção.

--------------------------------------------------

Como Compilar e Executar

1. Salve o conteúdo em um arquivo chamado Main.java.  
2. Compile:
   javac Main.java
   Isso gera Main.class
3. Execute:
   java Main

--------------------------------------------------

Saída Esperada (Modo Demonstração)

Ao rodar java Main, você deve ver algo semelhante a:

Pilha: 30 20 10 
Removido da pilha: 30
Pilha: 20 10 
Fila: 1 2 3 
Removido da fila: 1
Fila: 2 3 
Fila C (merge de filas): Fila: 5 12 15 23 35 52 55 64 75 
Vetor A: 12 35 52 64
Vetor B: 5 15 23 55 75
Vetor C (merge de vetores): 5 12 15 23 35 52 55 64 75

Interpretação rápida:
- A pilha imprime do topo para a base; após pop, o elemento removido é exibido.
- A fila imprime do início para o fim; após remove, o elemento removido é exibido.
- O merge (filas e vetores) resulta em uma sequência ordenada crescente com todos os elementos.

--------------------------------------------------

Como Inserir Novos Elementos (Liberdade para o Usuário)

1) Modo Demonstração (alterando o main)
Abra o Main.java e altere/adicione chamadas como:

Pilha p = new Pilha();
p.push(42);
p.push(99);
System.out.println("Removido da pilha: " + p.pop());

Fila f = new Fila();
f.insere(7);
f.insere(11);
System.out.println("Removido da fila: " + f.remove());

Fila A = new Fila();
A.insere(2); A.insere(10); A.insere(50);
Fila B = new Fila();
B.insere(1); B.insere(5); B.insere(100);
Fila C = Merge.mergeFilas(A, B);
C.imprime();

int[] VA = {2, 10, 50};
int[] VB = {1, 5, 100};
int[] VC = MergeArray.mergeVetores(VA, VB);
MergeArray.imprimeVetor(VC, "Resultado: ");

--------------------------------------------------

Casos de Teste (Validação)

Pilha (LIFO)
1. push(10), push(20), push(30) → imprime 30 20 10  
2. pop() → retorna 30; nova impressão 20 10

Fila (FIFO)
1. insere(1), insere(2), insere(3) → imprime 1 2 3  
2. remove() → retorna 1; nova impressão 2 3

Merge (Filas)
- A: 12, 35, 52, 64  
- B: 5, 15, 23, 55, 75  
- C esperado: 5, 12, 15, 23, 35, 52, 55, 64, 75

Merge (Vetores)
- VA: {12, 35, 52, 64}  
- VB: {5, 15, 23, 55, 75}  
- VC esperado: {5, 12, 15, 23, 35, 52, 55, 64, 75}

Dica: altere os valores e tente casos de borda, por exemplo vetores vazios, tamanhos diferentes, valores repetidos etc.

