# Graph definitions 

A graph is defined by a set of vertices and edges
 - G = (V, E)
 
It contains these attributes:
 - Order(G) = |V| (number of vertices, aka n)
 - Size(G) = |E| (number of edges, aka m)

The number of edges incident to a vertex is its degree 
 - deg(v)
 
Edges represented as e = (u,v)
 - u is origin vertex
 - v is destination vertex
 
Vertices are adjacent if there is an edge connecting them
 
Edges are incident on a vertex if they are directly connected
to it
 
---
 
Two types of graphs:
 - Undirected graph (edges no direction)
 - Directed Graph (aka digraph, edges have origin & destination)
 
---
 
A set of edges connecting a pair of vertices is called a Path
 - Simple path (no repeating vertices)
 
---
 
Weight of an edge is the cost of traversing an edge 
 - can be positive/negative
 
---
 
Graphs are dense if number of edges ~= maximal possible num
of edges

Graphs are sparse if the number of edges are minimal
 
---
 
Graphs are disconnected if there exists two vertives for which
there is no path.
 
Graphs are fully connected otherwise 
 - note: graph with degree 1 is connected by default 
 
---
 
Graphs are simple if no self-loop or parallel edges 
 - parallel edges are edges connecting same vertices in same direction 

 
---
 
Graphs are cyclic if vertices are repeated in a path
 
Graphs are acyclic otherwise
 
---
 