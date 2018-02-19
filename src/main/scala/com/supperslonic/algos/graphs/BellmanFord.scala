package com.supperslonic.algos.graphs

import scala.collection.mutable

/**
  * As discussed in Bellman Ford algorithm, for a given source, it first calculates the shortest distances which have
  * at-most one edge in the path. Then, it calculates shortest paths with at-most 2 edges, and so on.
  *
  * After the i-th iteration of outer loop, the shortest paths with at most i edges are calculated.
  * There can be maximum |V| – 1 edges in any simple path, that is why the outer loop runs |v| – 1 times.
  *
  * If there is a negative weight cycle, then one more iteration would give a shorted path.
  */
class BellmanFord {
  def find(graph: Graph): mutable.Map[String, ShortestPath] = {

    val shortestPath = mutable.Map[String, ShortestPath]()

    val processVertex: Vertex => Unit = vertex => {
      if (!shortestPath.contains(vertex.name))
        shortestPath.put(vertex.name, ShortestPath(vertex, 0))
    }

    val processEdge: (Vertex, Edge) => Unit = (vertex, edge) => {

      val distance = shortestPath(vertex.name).distance + edge.distance
      val shortestPathToNext = ShortestPath(edge.toVertex, distance)

      println(s"from ${vertex.name} we go to ${edge.toVertex.name} by $distance ")
      if (shortestPath.contains(edge.toVertex.name)) {
        val currentShortestPath = shortestPath(edge.toVertex.name)
        if (currentShortestPath.distance > distance) {
          shortestPath.put(edge.toVertex.name, shortestPathToNext)
        }
      } else {
        shortestPath.put(edge.toVertex.name, shortestPathToNext)
      }
    }

    graph.walk(graph.root, processVertex, processEdge)

    /*
    * There can be maximum |V| – 1 edges in any simple path,
    * that is why the outer loop runs |V| – 1 times.
    * */
    var revisited = true
    for(i <- 0 to shortestPath.size - 2) {
      graph.walk(graph.root, processVertex, processEdge, revisited)
      revisited = !revisited
    }

    shortestPath
  }
}
