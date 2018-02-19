package com.supperslonic.algos.graphs

import com.supperslonic.algos.heaps.MinHeap

import scala.collection.mutable

/**
  *
  * Dijksra’s algorithm is a Greedy algorithm and time complexity is O(ELogV) (with the use of Fibonacci heap).
  * Dijkstra does NOT work for Graphs with NEGATIVE weight edges, Bellman-Ford works for such graphs.
  *
  *       A
  *      / \
  *     /   \
  *    /     \
  *   5       2
  *  /         \
  * B--(-10)-->C
  *
  * If we have a vertex in open such that its cost is minimal - by adding any positive number to any vertex -
  * the minimality will never change.
  *
  * Without the constraint on positive numbers - the above assumption is not true.
  */
class Dijkstra {
  def find(graph: Graph): mutable.Map[String, ShortestPath] = {

    val shortestPath = mutable.Map[String, ShortestPath]()
    val minHeap = new MinHeap[ShortestPath]()

    val rootPath = ShortestPath(graph.root, 0)
    shortestPath.put(graph.root.name, rootPath)
    minHeap.insert(rootPath)

    while (!minHeap.isEmpty) {
      val current = minHeap.pop()

      current.vertex.getChildren.foreach(edge => {

        val distanceToNext = current.distance + edge.distance
        val nextVertex = edge.toVertex.name

        if (shortestPath.contains(nextVertex)) {
          val next = shortestPath(nextVertex)
          if (distanceToNext < next.distance) {
            val newPath = ShortestPath(next.vertex, distanceToNext)
            minHeap.replace(next, newPath)
            shortestPath.put(nextVertex, newPath)
          }
        } else {
          val newPath = ShortestPath(edge.toVertex, distanceToNext)
          shortestPath.put(nextVertex, newPath)
          minHeap.insert(newPath)
        }
      })
    }
    shortestPath
  }
}
