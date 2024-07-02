package Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
  public void computePaths(Vertex sourceVertex) {
    sourceVertex.setDistance(0);
    PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(sourceVertex);

    while (!priorityQueue.isEmpty()) {
      Vertex currentVertex = priorityQueue.poll();
      for (Edge edge : currentVertex.getAdjacencyList()) {
        Vertex v = edge.getEndVertex();

        double newDistance = currentVertex.getDistance() + edge.getWeight();
        if (newDistance < v.getDistance()) {
          priorityQueue.remove(v);
          v.setDistance(newDistance);
          v.setPredecessor(currentVertex);
          priorityQueue.add(v);
        }
      }
    }
  }

  public List<Vertex> getShortestPathTo(Vertex targetVertex) {
    List<Vertex> shortestPathToTarget = new ArrayList<>();
    for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
      shortestPathToTarget.add(vertex);
    }

    Collections.reverse(shortestPathToTarget);
    return shortestPathToTarget;
  }
}
