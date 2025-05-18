import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(UnweightedGraph<T> graph, Vertex<T> source) {
        super(graph, source);
    }

    @Override
    public void search() {
        Queue<Vertex<T>> queue = new LinkedList<>();
        visited.put(source, true);
        parent.put(source, null);
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex<T> u = queue.poll();
            for (Edge<T> edge : graph.getNeighbors(u)) {
                Vertex<T> v = edge.getTo();
                if (!visited.containsKey(v)) {
                    visited.put(v, true);
                    parent.put(v, u);
                    queue.offer(v);
                }
            }
        }
    }
}