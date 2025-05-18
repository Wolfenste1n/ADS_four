public class Main {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);
        graph.addEdge("D", "Z", 6);
        graph.addEdge("E", "Z", 3);

        Vertex<String> source = graph.getVertex("A");
        Vertex<String> destination = graph.getVertex("Z");

        System.out.println("BFS:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, source);
        bfs.search();
        System.out.println("Path from A to Z:");
        for (Vertex<String> v : bfs.getPathTo(destination)) {
            System.out.print(v + " ");
        }

        System.out.println("\n\nDijkstra:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, source);
        dijkstra.search();
        System.out.println("Shortest path from A to Z:");
        for (Vertex<String> v : dijkstra.getPathTo(destination)) {
            System.out.print(v + " ");
        }
    }
}