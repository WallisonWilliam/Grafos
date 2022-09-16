package Grafo;
public class Aresta {

    private Vertice vertice;
    private double custo;

    public Aresta(Vertice vertice) {
        this.vertice = vertice;
     
    }

    public Vertice getVertice() {
        return vertice;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

}