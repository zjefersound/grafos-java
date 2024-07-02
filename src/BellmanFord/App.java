package BellmanFord;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Vertex> vertexList = new ArrayList<>();

    Vertex vR = new Vertex("R");
    Vertex vS = new Vertex("S");
    Vertex vT = new Vertex("T");
    Vertex vU = new Vertex("U");

    vertexList.add(vR);
    vertexList.add(vS);
    vertexList.add(vT);
    vertexList.add(vU);

    List<Edge> edgeList = new ArrayList<>();
    edgeList.add(new Edge(3, vR, vS));
    edgeList.add(new Edge(7, vR, vT));
    edgeList.add(new Edge(5, vR, vU));

    edgeList.add(new Edge(3, vS, vT));
    edgeList.add(new Edge(1, vS, vU));

    edgeList.add(new Edge(1, vU, vT));

    BellmanFord bellmanFord = new BellmanFord(vertexList, edgeList);
    bellmanFord.bellmanFord(vR);

    for (Vertex v : vertexList) {
      System.out.println("Rota mais curta de R até " + v.getName() + ": " + bellmanFord.getShortestPathTo(v) + "\n");
    }
  }
}
