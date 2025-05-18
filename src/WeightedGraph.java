public class WeightedGraph<T> extends UnweightedGraph<T> {
    public WeightedGraph() {
        super();
    }

    public boolean addEdge(T data1, T data2, double weight) {
        Vertex<T> v1 = addVertex(data1);
        Vertex<T> v2 = addVertex(data2);
        return super.addEdge(v1, v2, weight);
    }
}