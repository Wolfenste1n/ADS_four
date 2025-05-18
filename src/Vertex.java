public class Vertex<T> {
    private T data;

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> other = (Vertex<?>) obj;
        if (data == null) return other.data == null;
        return data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return (data == null) ? 0 : data.hashCode();
    }
}