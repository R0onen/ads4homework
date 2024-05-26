import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");

        MyGraph<String> graph = new MyGraph<>();
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);

        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexA, vertexC, 4);
        graph.addEdge(vertexB, vertexC, 2);
        graph.addEdge(vertexB, vertexD, 5);
        graph.addEdge(vertexC, vertexD, 1);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println("BFS starting from vertex A:");
        bfs.bfs(vertexA, graph);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        Map<Vertex<String>, Double> distances = dijkstra.dijkstra(vertexA, graph);
        System.out.println("\nDijkstra's shortest path from vertex A:");
        distances.forEach((vertex, distance) -> System.out.println("Distance to " + vertex + " is " + distance));
    }
}
