import java.util.*;

public class DijkstraSearch<V> {
    public Map<Vertex<V>, Double> dijkstra(Vertex<V> startVertex, MyGraph<V> graph) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        Set<Vertex<V>> visited = new HashSet<>();

        distances.put(startVertex, 0.0);
        pq.add(new VertexDistance<>(startVertex, 0.0));

        while (!pq.isEmpty()) {
            VertexDistance<V> vertexDistance = pq.poll();
            Vertex<V> currentVertex = vertexDistance.getVertex();

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);

                for (Edge<V> edge : graph.getEdges(currentVertex)) {
                    Vertex<V> adjacentVertex = edge.getDest();
                    double newDist = distances.get(currentVertex) + edge.getWeight();

                    if (newDist < distances.getOrDefault(adjacentVertex, Double.MAX_VALUE)) {
                        distances.put(adjacentVertex, newDist);
                        pq.add(new VertexDistance<>(adjacentVertex, newDist));
                    }
                }
            }
        }
        return distances;
    }

    private static class VertexDistance<V> {
        private Vertex<V> vertex;
        private double distance;

        public VertexDistance(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public Vertex<V> getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}
