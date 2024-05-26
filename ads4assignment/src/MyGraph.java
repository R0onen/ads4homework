import java.util.*;

public class MyGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> map = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        map.get(source).add(new Edge<>(source, dest, weight));
    }

    public List<Edge<V>> getEdges(Vertex<V> vertex) {
        return map.get(vertex);
    }

    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }
}