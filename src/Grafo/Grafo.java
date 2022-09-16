package Grafo;

import java.util.LinkedList;

public class Grafo {

    private LinkedList<Vertice> vertices;

    public Grafo() {
        this.vertices = new LinkedList<>();
    }

    public LinkedList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVerticeByID(String id) {
        for (Vertice vertice : vertices) {
            if(vertice.getId().equals(id)) {
                return vertice;
            }
        }
        return null;
    }

    public void addVertice(Vertice vertice) {
        this.vertices.add(vertice);
    }

    public void setListaVertices(LinkedList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public Vertice searchElement(Vertice vertice) {
        for (Vertice verticeAtual : vertices) {
            if (verticeAtual.equals(vertice)) {
                return vertice;
            }
        }
        return null;
    }

    
}
