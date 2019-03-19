package com.supperslonic.algos.graphs

import scala.collection.mutable

case class ShortestPath(vertex: Vertex, distance: Int) extends Comparable[ShortestPath] {
  override def equals(obj: scala.Any): Boolean = this.vertex.name.equals(obj.asInstanceOf[ShortestPath].vertex.name)
  override def compareTo(o: ShortestPath): Int = this.distance.compareTo(o.distance)
}
case class Edge(distance: Int, toVertex: Vertex) {
  var visited: Boolean = false
}
case class Vertex(name: String, data: Any = null) {
  private val children = mutable.ArrayBuffer[Edge]()

  def addChild(edge: Edge): Unit = {
    children.append(edge)
  }

  def getChildren: Seq[Edge] = children
}

class Graph(val root: Vertex) {

  def copy(): Graph = {

    val copyVertex100 = (vertex: Vertex) => vertex.copy(name = s"${vertex.name}'")

    val existingVertex = mutable.Map[String, Vertex]()

    val copyVertex: Vertex => Unit = vertex => {
      println(s"Processing vertex: $vertex")
      if (!existingVertex.contains(vertex.name)) existingVertex.put(vertex.name, copyVertex100(vertex))
    }

    val copyEdge: (Vertex, Edge) => Unit = (vertex, edge) => {

      val tmpVertex = if (existingVertex.contains(edge.toVertex.name)) existingVertex(edge.toVertex.name) else {
        val newVertex = copyVertex100(edge.toVertex)
        existingVertex.put(edge.toVertex.name, newVertex)
        newVertex
      }

      println(s"Adding child $tmpVertex to ${existingVertex(vertex.name)}")
      existingVertex(vertex.name).addChild(Edge(edge.distance, tmpVertex))
    }

    walk(root, copyVertex, copyEdge)

    new Graph(existingVertex(root.name))
  }

  def print(): Unit = {
    val stringBuilder = mutable.StringBuilder.newBuilder
    val printVertex: Vertex => Unit = _ => {}
    val printEdge: (Vertex, Edge) => Unit = (vertex, edge) =>
      stringBuilder.append(s" (${vertex.name}) -${edge.distance}-> (${edge.toVertex.name})")

    walk(root, printVertex, printEdge)

    println(stringBuilder.mkString)
  }

  def walk(vertex: Vertex,
           processVertex: Vertex => Unit,
           processEdge: (Vertex, Edge) => Unit,
           reVisited: Boolean = false): Unit = {

    processVertex(vertex)

    for (edgeIndex <- vertex.getChildren.indices) {
      val edge = vertex.getChildren(edgeIndex)
      if (edge.visited == reVisited) {
        processEdge(vertex, edge)
        edge.visited = !reVisited
        walk(edge.toVertex, processVertex, processEdge, reVisited)
      }
    }
  }
}
