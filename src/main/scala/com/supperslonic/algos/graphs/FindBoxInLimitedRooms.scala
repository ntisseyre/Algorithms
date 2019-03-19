package com.supperslonic.algos.graphs

import scala.collection.mutable

class FindBoxInLimitedRooms {

  def find(graph: Graph, limit: Int): Seq[String] = {
    val queue = mutable.Queue[VertexLevel]()

    queue.enqueue(VertexLevel(graph.root, graph.root.name))

    val path = mutable.ArrayBuffer[String]()

    while (queue.nonEmpty) {
      val room = queue.dequeue()

      if (room.vertex.data != null) {
        path.append(room.path)
      }

      println(s"Room count: ${room.count}")

      if (room.count < limit) {
        room.vertex.getChildren
          .filter(edge => !edge.visited)
          .foreach(edge => {
            edge.visited = true
            queue.enqueue(VertexLevel(
              edge.toVertex,
              room.path + " -> " + edge.toVertex.name,
              room.count + 1))
          })
      }
    }

    path
  }

  case class VertexLevel(vertex: Vertex, path: String, count: Int = 1)
}
