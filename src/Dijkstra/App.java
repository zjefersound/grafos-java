package Dijkstra;

public class App {
  public static void main(String[] args) {
    Vertex vA = new Vertex("A");
    Vertex vB = new Vertex("B");
    Vertex vC = new Vertex("C");
    Vertex vD = new Vertex("D");
    Vertex vE = new Vertex("E");
    Vertex vF = new Vertex("F");
    Vertex vG = new Vertex("G");
    Vertex vH = new Vertex("H");

    vA.addNeighbor(new Edge(20, vA, vB));
    vA.addNeighbor(new Edge(80, vA, vD));
    vA.addNeighbor(new Edge(90, vA, vG));

    vB.addNeighbor(new Edge(10, vB, vF));

    vC.addNeighbor(new Edge(10, vC, vD));
    vC.addNeighbor(new Edge(50, vC, vF));
    vC.addNeighbor(new Edge(20, vC, vH));

    vD.addNeighbor(new Edge(10, vD, vC));
    vD.addNeighbor(new Edge(40, vD, vF));
    vD.addNeighbor(new Edge(20, vD, vG));

    vE.addNeighbor(new Edge(50, vE, vB));
    vE.addNeighbor(new Edge(30, vE, vG));

    vF.addNeighbor(new Edge(10, vF, vC));
    vF.addNeighbor(new Edge(40, vF, vD));

    vG.addNeighbor(new Edge(20, vG, vA));
    vG.addNeighbor(new Edge(20, vG, vD));

    DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
    dijkstraAlgorithm.computePaths(vA);

    System.out.println("Distância até H " + vH.getDistance());
    System.out.println("Rota mais curta de A até H " + dijkstraAlgorithm.getShortestPathTo(vH));

  }
}
