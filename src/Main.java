import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

import Algoritmos.Busca.Algoritmo;
import Algoritmos.Busca.AlgoritmoBFS;

import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

public class Main {

	public static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		int opcao;
		Grafo grafo = new Grafo();
		String[] arquivo = lerArquivo("pequenoG.txt");
		LinkedList<Vertice> vertices = criarVertices(arquivo);

		grafo.setListaVertices(vertices);
		criarArestasAddGrafo(grafo, arquivo);

		menuPrincipal();
		opcao = ler.nextInt();

		while (opcao <= 7) {
			switch (opcao) {
			case 1:
				imprimeVertices(grafo);
				break;
			case 2:
				menorCaminhoBFS(grafo);
				break;
			case 3:
				ordemGrafo(arquivo);
				break;
			case 4:
				tamanhoGrafo(arquivo);
				break;
			case 5:
				grauVertices();
				break;
			case 6:
			    verticesIsolados();
				break;
			case 7:
				verticesExtremidade();
				break;
			default:
				break;
			}
			menuPrincipal();
			opcao = ler.nextInt();
		}

	}

	
	private static void tamanhoGrafo(String[] palavras) {
		String tamanho = palavras[1];
		System.out.println(tamanho);

	}

	private static void ordemGrafo(String[] palavras) {
		String ordem = palavras[0];
		System.out.println(ordem);

	}
	
	
	public static void menorCaminhoBFS(Grafo grafo) {
		ler.nextLine();
		System.out.format("Nome do vertice 1: ");
		String idA = ler.nextLine();
		System.out.format("Nome do vertice 2: ");
		String idB = ler.nextLine();
		Vertice verticeA = grafo.getVerticeByID(idA);
		Vertice verticeB = grafo.getVerticeByID(idB);
		Algoritmo algoritmo = new AlgoritmoBFS();
		algoritmo.buscar(grafo, verticeA);
		System.out.println();
		imprimirMenorCaminho(verticeA, verticeB);
		System.out.println();
	}

	public static void menuPrincipal() {
        System.out.format("Selecione uma opcao: %n"
            + "1 - Lista de Adjacencia %n"
            + "2 - Buscar menor caminho BFS %n"
            + "3 - Ordem do grafo %n"
            + "4 - Tamanho do grafo %n"
            + "5 - Grau dos vértices %n"
            + "6 - Vertices isolados %n"
            + "7 - Vertices de extremidade %n"
            + "Digite: ");
    }
	
	public static void imprimeVertices(Grafo grafo) {
		System.out.format("%n Grafo %n %n %n");
		for (Vertice verticeAtual : grafo.getVertices()) {
			System.out.format(" (%s)", verticeAtual, verticeAtual.getCorDoVertice());
			for (Vertice adjacente : verticeAtual.getAdjacentes()) {
				System.out.format("--> %s ", adjacente, verticeAtual.getCusto(adjacente), adjacente.getCorDoVertice());
			}
			System.out.format("%n %n %n");
		}
	}
	
	public static void imprimirMenorCaminho(Vertice verticeA, Vertice verticeB) {
		if (verticeA.equals(verticeB)) {
			System.out.format("%s", verticeB, verticeB.getCustoAresta());
		} else {
			if (verticeB.getAnterior() == null) {
				System.out.println("nao tem caminho! ");
			} else {
				imprimirMenorCaminho(verticeA, verticeB.getAnterior());
				System.out.print(" <--> ");
				System.out.format("%s", verticeB, verticeB.getCustoAresta());
			}
		}
	}

	public static String[] lerArquivo(String nomeArquivo) {
		String palavra = "";
		try {
			palavra = new String(Files.readAllBytes(Paths.get(nomeArquivo)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] palavras = palavra.split("\r*\n");
		return palavras;
	}

	public static LinkedList<Vertice> criarVertices(String[] palavras) {
		LinkedList<Vertice> vertices = new LinkedList<>();
		int num = Integer.parseInt(palavras[0]);
		for (int i = 0; i < num; i++) {
			String id = Integer.toString(i);
			Vertice novoVertice = new Vertice(id);
			vertices.add(novoVertice);
		}
		return vertices;
	}

	public static void criarArestasAddGrafo(Grafo grafo, String[] palavras) throws Exception {
		String[] linha = new String[palavras.length];
		String[] verticeA = new String[palavras.length];
		String[] verticeB = new String[palavras.length];
		int verificaArestas = Integer.parseInt(palavras[1]);

		if (palavras.length - 2 == verificaArestas) {
			for (int i = 2; i < palavras.length; i++) {
				linha[i] = String.valueOf(palavras[i]);
				verticeA[i] = linha[i].split(" ")[0];
				verticeB[i] = linha[i].split(" ")[1];
				Vertice verticeAAtual = grafo.getVerticeByID(verticeA[i]);
				Vertice verticeBAtual = grafo.getVerticeByID(verticeB[i]);
				Aresta novAresta = new Aresta(verticeBAtual);
				verticeAAtual.addAresta(novAresta);
			}
			for (int i = 2; i < palavras.length; i++) {
				linha[i] = String.valueOf(palavras[i]);
				verticeA[i] = linha[i].split(" ")[0];
				verticeB[i] = linha[i].split(" ")[1];
				Vertice verticeAAtual = grafo.getVerticeByID(verticeB[i]);
				Vertice verticeBAtual = grafo.getVerticeByID(verticeA[i]);
				Aresta novAresta = new Aresta(verticeBAtual);
				verticeAAtual.addAresta(novAresta);
			}
		} else {
			throw new Exception();
		}
		             
		
	}

}
