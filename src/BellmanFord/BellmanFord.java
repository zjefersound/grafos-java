package BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BellmanFord {
  private List<Vertex> vertexList;
  private List<Edge> edgeList;

  public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
    this.vertexList = vertexList;
    this.edgeList = edgeList;
  }

  public void bellmanFord(Vertex sourceVertex) {
    sourceVertex.setDistance(0);

    for (int i = 0; i < vertexList.size() - 1; i++) { // Relax all the edges (v-1 iterations)
      for (Edge edge : edgeList) {
        Vertex u = edge.getStartVertex();
        Vertex v = edge.getEndVertex();

        if (u.getDistance() == Double.MAX_VALUE)
          continue;

        double newDistance = u.getDistance() + edge.getWeight();
        if (newDistance < v.getDistance()) {
          v.setDistance(newDistance);
          v.setPreviousVertex(u);
        }
      }
    }

    for (Edge edge : edgeList) { // Detect cycle in the v-th iteration
      if (edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
        if (hasCycle(edge)) {
          System.out.println("Negative cycle detected!");
          return;
        }
      }
    }
  }

  private boolean hasCycle(Edge edge) {
    return (edge.getStartVertex().getDistance() + edge.getWeight()) < edge.getEndVertex().getDistance();
  }

  public List<Vertex> getShortestPathTo(Vertex targetVertex) {
    List<Vertex> shortestPathToTarget = new ArrayList<>(Arrays.asList(targetVertex));

    if (targetVertex.getDistance() == Double.MAX_VALUE) {
      System.out.println("There is no path from the source to the target vertex!");
      return shortestPathToTarget;
    }

    Vertex currentVertex = targetVertex;
    while (currentVertex.getPreviousVertex() != null) {
      currentVertex = currentVertex.getPreviousVertex();
      shortestPathToTarget.add(currentVertex);
    }

    Collections.reverse(shortestPathToTarget);
    System.out.println("There is a shortest path from source to target, with cost: " + targetVertex.getDistance());
    return shortestPathToTarget;
  }
}
