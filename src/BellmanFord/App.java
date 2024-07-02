package BellmanFord;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Vertex> vertexList = new ArrayList<>();

    Vertex va = new Vertex("A");
    Vertex vb = new Vertex("B");
    Vertex vc = new Vertex("C");
    Vertex vd = new Vertex("D");
    Vertex ve = new Vertex("E");

    vertexList.add(va);
    vertexList.add(vb);
    vertexList.add(vc);
    vertexList.add(vd);
    vertexList.add(ve);

    List<Edge> edgeList = new ArrayList<>();
    edgeList.add(new Edge(-1, va, vb));
    edgeList.add(new Edge(4, va, vc));

    edgeList.add(new Edge(3, vb, vc));
    edgeList.add(new Edge(2, vb, vd));
    edgeList.add(new Edge(2, vb, ve));

    edgeList.add(new Edge(1, vd, vb));
    edgeList.add(new Edge(5, vd, vc));

    edgeList.add(new Edge(-3, ve, vd));

    BellmanFord bellmanFord = new BellmanFord(vertexList, edgeList);
    bellmanFord.bellmanFord(va);

    for (Vertex v : vertexList) {
      System.out.println("Rota mais curta de A até " + v.getName() + ": " + bellmanFord.getShortestPathTo(v) + "\n");
    }
  }
}
