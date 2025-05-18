public class Edge<T> {
    private Vertex<T> from;
    private Vertex<T> to;
    private double weight;

    public Edge(Vertex<T> from, Vertex<T> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + from + " -> " + to + ", weight=" + weight + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge<?> other = (Edge<?>) obj;
        if (from == null ? other.from != null : !from.equals(other.from)) return false;
        if (to == null ? other.to != null : !to.equals(other.to)) return false;
        return Double.compare(weight, other.weight) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (from == null ? 0 : from.hashCode());
        result = 31 * result + (to == null ? 0 : to.hashCode());
        long temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}