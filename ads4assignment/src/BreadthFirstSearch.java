import java.util.*;

public class BreadthFirstSearch<V> {
    private Set<Vertex<V>> visited;
    private Queue<Vertex<V>> queue;

    public BreadthFirstSearch() {
        visited = new HashSet<>();
        queue = new LinkedList<>();
    }

    public void bfs(Vertex<V> startVertex, MyGraph<V> graph) {
        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge<V> edge : graph.getEdges(vertex)) {
                Vertex<V> adjacentVertex = edge.getDest();
                if (!visited.contains(adjacentVertex)) {
                    visited.add(adjacentVertex);
                    queue.add(adjacentVertex);
                }
            }
        }
    }
}