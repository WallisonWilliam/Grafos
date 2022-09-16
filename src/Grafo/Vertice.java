package Grafo;
import java.util.LinkedList;

public class Vertice implements Comparable<Vertice> {

    private String id;
    private String cor;
    private double distancia;
    private Vertice anterior;
    private double custoLocal;
    private double custoAresta;
    private String corDoVertice;
    private LinkedList<Aresta> arestas;
    private LinkedList<String> locais;

    public Vertice(String id) {
        this.id = id;
        arestas = new LinkedList<>();
        locais = new LinkedList<>();
    }

    public String getId() {
        return this.id;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vertice getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Vertice anterior) {
        this.anterior = anterior;
    }

    public double getCusto(Vertice vertice) {
        for (Aresta aresta : this.arestas) {
            if(aresta.getVertice().equals(vertice)) {
                return aresta.getCusto();
            }
        }
        return 0;
    }

    public void setCusto(Vertice vertice ,double custo) {
        for (Aresta aresta : this.arestas) {
            if(aresta.getVertice().equals(vertice)) {
                aresta.setCusto(custo);
            }
        }
    }

    public double getCustoAresta() {
        return this.custoAresta;
    }

    public void setCustoAresta(double custoAresta) {
        this.custoAresta = custoAresta;
    }

    public double getCustoLocal() {
        return this.custoLocal;
    }

    public void setCustoLocal(double custoLocal) {
        this.custoLocal = custoLocal;
    }

    public String getCorDoVertice() {
        return this.corDoVertice;
    }

    public void setCorDoVertice(String corDoVertice) {
        this.corDoVertice = corDoVertice;
    }

    public LinkedList<String> getLocais() {
        return locais;
    }

    public void addLocal(String local) {
        this.locais.add(local);
    }

    public void removeLocal(String local) {
        this.locais.remove(local);
    }

    public void addAresta(Aresta aresta) {
        this.arestas.add(aresta);
    }
    
    public LinkedList<Vertice> getAdjacentes() {
        LinkedList<Vertice> adjacentes = new LinkedList<>();
        if (!arestas.isEmpty()) {
            for (Aresta aresta : this.arestas) {
                adjacentes.add(aresta.getVertice());
            }
        }
        return adjacentes;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vertice)) {
            return false;
        }
        Vertice anotherVertice = (Vertice) object;
        return this.id == anotherVertice.id;
    }

    @Override
    public String toString() {
        return String.format("%s", this.id);
    }

    @Override
    public int compareTo(Vertice otherVertice) {
        if(this.getCustoLocal() > otherVertice.getCustoLocal()) {
            return 1;
        } else if(this.getCustoLocal() < otherVertice.getCustoLocal()) {
            return -1;
        } else {
            return 0;
        }
    }

}
