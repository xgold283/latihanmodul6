
package com.main.latihanmodul6;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
    private int V; // Jumlah simpul (vertices)
    private LinkedList<Integer>[] adjacencyList; // Daftar adjacency untuk grafik

    // Konstruktor
    public DepthFirstSearch(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList();
    }

    // Menambahkan tepi ke grafik
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // Fungsi rekursif untuk DFS traversal dimulai dari simpul v
    void DFSUtil(int v, boolean[] visited) {
        // Menandai simpul saat ini sebagai dikunjungi dan cetak
        visited[v] = true;
        System.out.print(v + " ");

        // Mengulangi semua simpul tetangga dari simpul saat ini yang belum dikunjungi
        Iterator<Integer> i = adjacencyList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // DFS traversal dimulai dari simpul v
    void DFS(int v) {
        // Array untuk melacak simpul yang telah dikunjungi
        boolean[] visited = new boolean[V];

        // Memanggil fungsi rekursif DFSUtil untuk traversal DFS
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        DepthFirstSearch graph = new DepthFirstSearch(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);

        System.out.println("Traversal DFS dimulai dari simpul 0:");
        graph.DFS(0);
    }
}
