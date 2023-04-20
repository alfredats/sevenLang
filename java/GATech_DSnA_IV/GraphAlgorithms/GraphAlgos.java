import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import java.util.Arrays;
import java.util.HashMap;


public class GraphAlgos {

    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * You should NOT allow self-loops or parallel edges in the MST.
     *
     * You may import/use java.util.PriorityQueue, java.util.Set, and any
     * class that implements the aforementioned interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * The only instance of java.util.Map that you may use is the adjacency
     * list from graph. DO NOT create new instances of Map for this method
     * (storing the adjacency list in a variable is fine).
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin Prims on.
     * @param graph The graph we are applying Prims to.
     * @return The MST of the graph or null if there is no valid MST.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visited = new HashSet<>();
        Set<Edge<T>> mst = new HashSet<>();
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>();

        graph.getEdges().stream()
            .filter(ed -> ed.getU().equals(start))
            .forEachOrdered(pq::add);

        visited.add(start);
        while (!pq.isEmpty() && visited.size() < graph.getVertices().size()) {
            Edge<T> ce = pq.remove();
            if (!visited.contains(ce.getV())) {
                visited.add(ce.getV());
                mst.add(ce);
                mst.add(new Edge<>(ce.getV(), ce.getU(), ce.getWeight()));
                graph.getEdges().stream().filter(ed -> ed.getU().equals(ce.getV())
                        && !visited.contains(ed.getV())).forEachOrdered(pq::add);
            }
        }
        return mst.size() < graph.getVertices().size() - 1 ? null : mst;
    }


    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        List<Vertex<T>> accum = new LinkedList<>();

        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex<T> c = queue.poll();
            visited.add(c);
            accum.add(c);
            for (VertexDistance<T> d : graph.getAdjList().get(c)) {
                if (!visited.contains(d.getVertex())) { 
                    visited.add(d.getVertex());
                    queue.add(d.getVertex()); 
                }
            }
        }

        return accum;
    }





    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visited = new HashSet<>(); 
        List<Vertex<T>> accum = new LinkedList<>();
        dfsHelper(start,graph,visited, accum);
        return accum;
    }


    private static <T> void dfsHelper(Vertex<T> s, Graph<T> g, Set<Vertex<T>> v, List<Vertex<T>> accum) {
        if (v.contains(s)) { return; }
        v.add(s);
        accum.add(s);
        for (VertexDistance<T> d : g.getAdjList().get(s)) {
            dfsHelper(d.getVertex(), g, v, accum);
        }
        return;
    }



    public static void main(String[] args) {
        Map<Character, Vertex<Character>> m1 = new HashMap<>();
        Set<Vertex<Character>> v1 = new HashSet<>();
        Set<Edge<Character>> e1 = new HashSet<>();
        List<Character> l1  = Arrays.asList('a','b','c','d');
        for (Character c : l1) {
            Vertex<Character> v = new Vertex<Character>(c);
            m1.put(c, v);
            v1.add(v);
        }
        for (int i = 0; i < l1.size(); i++)  {
            Vertex<Character> cv = m1.get(l1.get(i));
            for (int j = i+1; j < l1.size(); j++) {
                e1.add(new Edge<Character>(cv, m1.get(l1.get(j)), i+j));
            }
        }

        Graph<Character> g1 = new Graph<Character>(v1,e1);
        System.out.println(GraphAlgos.dfs(m1.get('a'), g1));

        System.out.println(GraphAlgos.bfs(m1.get('a'), g1));

        System.out.println(GraphAlgos.prims(m1.get('a'), g1));

        

    }




}