import java.util.ArrayList;
import java.util.List;

public class Grafo {
    
    private List<String> vertices;
    private int[][] matrizAdjacencia;
    
    public Grafo(int numVertices) {
        vertices = new ArrayList<>(numVertices);
        matrizAdjacencia = new int[numVertices][numVertices];
    }
   
    public void adicionarVertice(String vertice) {
        vertices.add(vertice);
    }
    
    public void adicionarAresta(int indiceVertice1, int indiceVertice2) {
        matrizAdjacencia[indiceVertice1][indiceVertice2] = 1;
        matrizAdjacencia[indiceVertice2][indiceVertice1] = 1;
    }
 
    public void imprimirMatrizAdjacencia() {
        for (String vertice : vertices) {
            System.out.print(vertice + " ");
        }
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
        }
    }
    
    public int poucosVizinhos() {
        int poucosVizinhos = Integer.MAX_VALUE;
        int poucoEstado = -1;
        for (int i = 0; i <matrizAdjacencia.length; i++) {
            int vizinhos = 0;
            for (int j = 0; j <matrizAdjacencia[i].length; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    vizinhos++;
                }
            }
            if (vizinhos < poucosVizinhos) {
                poucosVizinhos = vizinhos;
                poucoEstado = i;
            }
        }
        return poucoEstado;
    }
    
    public int muitosVizinhos() {
        
        int muitosVizinhos = Integer.MIN_VALUE;
        int muitosEstados = -1;
        for (int i = 0; i <matrizAdjacencia.length; i++) {
            int vizinhos = 0;
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    vizinhos++;
                }
            }
            if (vizinhos > muitosVizinhos) {
                muitosVizinhos = vizinhos;
                muitosEstados = i;
            }
        }
        return muitosEstados;
    }
    
    public void menorCaminho(int estadoInicial, int estadoFinal) {
      
        Fila<Integer> fila = new Fila<>();
        int[] rota = new int[matrizAdjacencia.length];
        boolean[] visitado = new boolean[matrizAdjacencia.length];
        visitado[estadoInicial] = true;
        
        fila.adicionar(estadoInicial);        
        while (!fila.isVazia()) {
            int estado = fila.remover();
            
            for (int i = 0; i < matrizAdjacencia[estado].length; i++) {
                if (this.matrizAdjacencia[estado][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    fila.adicionar(i);
                    rota[i] = estado;
                    if (i == estadoFinal) {
                        break;
                    }
                }
            }
        }

        System.out.print("O menor caminho entre dois estados é: ");
        int estado = estadoFinal;
        while (estado != estadoInicial) {
            System.out.print(estado + " -> ");
            estado = rota[estado];
        }
        System.out.println(estadoInicial); 
    }
    
    public void buscasTodosOsCaminhos(int estadoInicial, int estadoFinal) {
       
        Pilha<Integer> Pilha = new Pilha<>();
        int[] rota = new int[matrizAdjacencia.length];
        boolean[] visitado = new boolean[matrizAdjacencia.length];
        visitado[estadoInicial] = true;
        
        Pilha.adicionar(estadoInicial);
        while (!Pilha.isVazia()) {
            int estado = Pilha.remover();
            
            for (int i = 0; i <matrizAdjacencia[estado].length; i++) {
                if (matrizAdjacencia[estado][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    Pilha.adicionar(i);
                    rota[i] = estado;
                    
                    if (i == estadoFinal) {
                        System.out.print("Possivel Caminho: ");
                        estado = estadoFinal;
                        while (estado != estadoInicial) {
                            System.out.print(estado + "->");
                            estado = rota[estado];
                        }
                        System.out.println(estadoInicial);
                        Pilha.remover();
                        visitado[i] = false;
                    }
                }
            }
        }
    }
    
    public void build() {
        
        this.adicionarVertice("Acre"); // 0
        this.adicionarVertice("Alagoas"); // 1
        this.adicionarVertice("Amapá"); // 2
        this.adicionarVertice("Amazonas"); // 3
        this.adicionarVertice("Bahia"); // 4
        this.adicionarVertice("Ceará"); // 5
        this.adicionarVertice("Distrito Federal"); // 6
        this.adicionarVertice("Espírito Santo"); // 7
        this.adicionarVertice("Goiás"); // 8
        this.adicionarVertice("Maranhão"); // 9
        this.adicionarVertice("Mato Grosso"); // 10
        this.adicionarVertice("Mato Grosso do Sul"); // 11
        this.adicionarVertice("Minas Gerais"); // 12
        this.adicionarVertice("Pará"); // 13
        this.adicionarVertice("Paraíba"); // 14
        this.adicionarVertice("Paraná"); // 15
        this.adicionarVertice("Pernambuco"); // 16
        this.adicionarVertice("Piauí"); // 17
        this.adicionarVertice("Rio de Janeiro"); // 18
        this.adicionarVertice("Rio Grande do Norte"); // 19
        this.adicionarVertice("Rio Grande do Sul"); // 20
        this.adicionarVertice("Rondônia"); // 21
        this.adicionarVertice("Roraima"); // 22
        this.adicionarVertice("Santa Catarina"); // 23
        this.adicionarVertice("São Paulo"); // 24
        this.adicionarVertice("Sergipe"); // 25
        this.adicionarVertice("Tocantins"); // 26
        
        this.adicionarAresta(0, 3);
        this.adicionarAresta(3, 22);
        this.adicionarAresta(3, 13);
        this.adicionarAresta(3, 21);
        this.adicionarAresta(3, 21);
        this.adicionarAresta(22, 13);
        this.adicionarAresta(22, 13);
        this.adicionarAresta(21, 10);
        this.adicionarAresta(13, 2);
        this.adicionarAresta(13, 10);
        this.adicionarAresta(13, 9);
        this.adicionarAresta(13, 26);
        this.adicionarAresta(10, 26);
        this.adicionarAresta(10, 8);
        this.adicionarAresta(10, 11);
        this.adicionarAresta(9, 17);
        this.adicionarAresta(9, 26);
        this.adicionarAresta(9, 17);
        this.adicionarAresta(17, 5);
        this.adicionarAresta(5, 19);
        this.adicionarAresta(5, 14);
        this.adicionarAresta(5, 16);
        this.adicionarAresta(19, 14);
        this.adicionarAresta(14, 16);
        this.adicionarAresta(16, 1);
        this.adicionarAresta(16, 4);
        this.adicionarAresta(16, 17);
        this.adicionarAresta(1, 25);
        this.adicionarAresta(25, 4);
        this.adicionarAresta(4, 12);
        this.adicionarAresta(4, 17);
        this.adicionarAresta(4, 26);
        this.adicionarAresta(4, 7);
        this.adicionarAresta(4, 8);
        this.adicionarAresta(8, 26);
        this.adicionarAresta(8, 12);
        this.adicionarAresta(8, 6);
        this.adicionarAresta(6, 12);
        this.adicionarAresta(12, 7);
        this.adicionarAresta(12, 18);
        this.adicionarAresta(12, 24);
        this.adicionarAresta(12, 10);
        this.adicionarAresta(18, 7);
        this.adicionarAresta(18, 24);
        this.adicionarAresta(10, 24);
        this.adicionarAresta(24, 15);
        this.adicionarAresta(15, 23);
        this.adicionarAresta(15, 11);
        this.adicionarAresta(15, 20);
    }
    
    public static void main(String args[]) {

        Grafo br = new Grafo(27);
        br.build();

        int min = br.poucosVizinhos();
        int max = br.muitosVizinhos();

        System.out.println("Estado que possui o menor número de vizinhos é: " + br.vertices.get(min));
        System.out.println("Estado que possui o maior número de vizinhos é: " + br.vertices.get(max));

        br.menorCaminho(2, 17);
        br.buscasTodosOsCaminhos(2, 17);

    }
    
}