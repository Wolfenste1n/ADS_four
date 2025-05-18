import java.util.*;

public abstract class Search<T> {
    protected UnweightedGraph<T> graph;
    protected Vertex<T> source;
    protected Map<Vertex<T>, Boolean> visited;
    protected Map<Vertex<T>, Vertex<T>> parent;

    public Search(UnweightedGraph<T> graph, Vertex<T> source) {
        this.graph = graph;
        this.source = source;
        this.visited = new HashMap<>();
        this.parent = new HashMap<>();
    }

    public abstract void search();

    public List<Vertex<T>> getPathTo(Vertex<T> dest) {
        List<Vertex<T>> path = new ArrayList<>();
        if (dest == null) return path;
        if (dest.equals(source)) {
            path.add(source);
            return path;
        }
        if (!parent.containsKey(dest)) return path;
        for (Vertex<T> v = dest; v != null; v = parent.get(v)) {
            path.add(0, v);
        }
        return path;
    }
}