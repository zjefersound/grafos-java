package TopologicalOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

  public static void main(String[] args) {
    TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
    List<Vertex> graph = new ArrayList<>();
    graph.add(new Vertex("A"));
    graph.add(new Vertex("B"));
    graph.add(new Vertex("C"));
    graph.add(new Vertex("D"));
    graph.add(new Vertex("E"));
    graph.add(new Vertex("F"));

    graph.get(0).addNeighbor(graph.get(1));
    graph.get(0).addNeighbor(graph.get(2));
    
    graph.get(1).addNeighbor(graph.get(3));
    graph.get(1).addNeighbor(graph.get(4));

    graph.get(2).addNeighbor(graph.get(5));



    for (int i = 0; i < graph.size(); i++) {
      if (!graph.get(i).isVisited()) {
        topologicalOrdering.dfs(graph.get(i));
      }
    }
    Stack<Vertex> stack = topologicalOrdering.getStack();

    for (int i = 0; i < graph.size(); i++) {
      Vertex v = stack.pop();
      System.out.println(v + " ");
    }
  }
}
