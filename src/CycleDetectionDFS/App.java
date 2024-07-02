package CycleDetectionDFS;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    Vertex v1 = new Vertex("1");
    Vertex v2 = new Vertex("2");
    Vertex v3 = new Vertex("3");
    Vertex v4 = new Vertex("4");
    Vertex v5 = new Vertex("5");
    Vertex v6 = new Vertex("6");

    v1.addNeighbor(v2);
    // v1.addNeighbor(v3); // Removed to change direction
    v2.addNeighbor(v3);
    v3.addNeighbor(v1); // Changed here V3 ----> V1
    v4.addNeighbor(v1);
    v4.addNeighbor(v5);
    v5.addNeighbor(v6);
    v6.addNeighbor(v4);

    List<Vertex> graph = new ArrayList<>();
    graph.add(v1);
    graph.add(v2);
    graph.add(v3);
    graph.add(v4);
    graph.add(v5);
    graph.add(v6);

    CycleDetection cycleDetection = new CycleDetection();
    cycleDetection.detectCycle(graph);
  }
}
