import java.util.*;

public class UnweightedGraph<T> {
    protected List<Vertex<T>> vertices;
    protected Map<Vertex<T>, List<Edge<T>>> adjList;

    public UnweightedGraph() {
        vertices = new ArrayList<>();
        adjList = new HashMap<>();
    }

    public Vertex<T> getVertex(T data) {
        for (Vertex<T> v : vertices) {
            if (v.getData().equals(data)) {
                return v;
            }
        }
        return null;
    }

    public Vertex<T> addVertex(T data) {
        Vertex<T> v = getVertex(data);
        if (v == null) {
            v = new Vertex<>(data);
            vertices.add(v);
            adjList.put(v, new ArrayList<>());
        }
        return v;
    }

    public boolean addEdge(T data1, T data2) {
        Vertex<T> v1 = addVertex(data1);
        Vertex<T> v2 = addVertex(data2);
        return addEdge(v1, v2, 1.0);
    }

    protected boolean addEdge(Vertex<T> v1, Vertex<T> v2, double weight) {
        if (v1 == null || v2 == null) return false;
        Edge<T> e1 = new Edge<>(v1, v2, weight);
        Edge<T> e2 = new Edge<>(v2, v1, weight);
        List<Edge<T>> list1 = adjList.get(v1);
        if (!list1.contains(e1)) list1.add(e1);
        List<Edge<T>> list2 = adjList.get(v2);
        if (!list2.contains(e2)) list2.add(e2);
        return true;
    }

    public List<Edge<T>> getNeighbors(Vertex<T> v) {
        return adjList.getOrDefault(v, new ArrayList<>());
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }
}