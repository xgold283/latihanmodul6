
package com.main.latihanmodul6;


 import java.util.*;

public class BreadthFirstSearch {
    private int V; // Jumlah simpul (vertices)
    private LinkedList<Integer>[] adjacencyList; // Daftar adjacency untuk grafik

    // Konstruktor
    public BreadthFirstSearch(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList();
    }

    // Menambahkan tepi ke grafik
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // BFS traversal dimulai dari node s
    void BFS(int s) {
        // Array untuk melacak simpul yang telah dikunjungi
        boolean[] visited = new boolean[V];

        // Membuat antrian untuk traversal BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Menandai simpul saat ini sebagai dikunjungi dan menambahkannya ke antrian
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Mengeluarkan simpul dari antrian dan cetak
            s = queue.poll();
            System.out.print(s + " ");

            // Dapatkan semua simpul tetangga dari simpul saat ini
            // Jika simpul belum dikunjungi, tandai sebagai dikunjungi dan tambahkan ke antrian
            Iterator<Integer> i = adjacencyList[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);

        System.out.println("Traversal BFS dimulai dari simpul 2:");
        graph.BFS(0);
    }
}