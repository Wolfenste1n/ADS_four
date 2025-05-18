import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private Map<Vertex<T>, Double> dist;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(graph, source);
        this.dist = new HashMap<>();
    }

    @Override
    public void search() {
        for (Vertex<T> v : graph.getVertices()) {
            dist.put(v, Double.POSITIVE_INFINITY);
            visited.put(v, false);
        }
        dist.put(source, 0.0);
        parent.put(source, null);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0.0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            Vertex<T> u = node.vertex;
            if (visited.get(u)) continue;
            visited.put(u, true);
            for (Edge<T> edge : graph.getNeighbors(u)) {
                Vertex<T> v = edge.getTo();
                double newDist = dist.get(u) + edge.getWeight();
                if (newDist < dist.get(v)) {
                    dist.put(v, newDist);
                    parent.put(v, u);
                    pq.offer(new Node(v, newDist));
                }
            }
        }
    }

    private class Node implements Comparable<Node> {
        Vertex<T> vertex;
        double dist;

        Node(Vertex<T> vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.dist, other.dist);
        }
    }
}