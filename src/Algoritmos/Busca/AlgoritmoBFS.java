package Algoritmos.Busca;
import java.util.LinkedList;
import java.util.Queue;

import Grafo.Grafo;
import Grafo.Vertice;

public class AlgoritmoBFS implements Algoritmo {

    //Algoritmo Busca em Escala

    @Override
    public void buscar(Grafo grafo ,Vertice vertice) {
        Queue<Vertice> fila = new LinkedList<Vertice>();
        inicializa(grafo, vertice);
        vertice.setCor("CINZA");
        vertice.setDistancia(0.0);
        fila.add(vertice);
        while (!fila.isEmpty()) {
            Vertice verticeAtual;
            verticeAtual = fila.remove();
            for (Vertice adjacente : verticeAtual.getAdjacentes()) {
                if (adjacente.getCor().equals("BRANCO")) {
                    adjacente.setCor("CINZA");
                    adjacente.setDistancia(verticeAtual.getDistancia() + 1);
                    adjacente.setAnterior(verticeAtual);
                    adjacente.setCustoAresta(verticeAtual.getCusto(adjacente));
                    fila.add(adjacente);
                }
            }
            verticeAtual.setCor("PRETO");
        }

    }

    public static void inicializa(Grafo grafo, Vertice vertice) {
        for (Vertice verticeAtual : grafo.getVertices()) {
            verticeAtual.setCor("BRANCO");
            verticeAtual.setDistancia(Double.POSITIVE_INFINITY);
            verticeAtual.setAnterior(null);
            verticeAtual.setCustoAresta(Double.POSITIVE_INFINITY);
        }
        vertice.setCustoAresta(0);
    }

}
