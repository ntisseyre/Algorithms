package com.supperslonic.algos.graphs

import org.scalatest.{FunSpec, Matchers}

class GraphSpec extends FunSpec with Matchers {
  describe("Graph") {
    it("Populate and Print") {

      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")
      val vertexD = Vertex("D")

      vertexA.addChild(Edge(12, vertexA))
      vertexA.addChild(Edge(13, vertexB))
      vertexB.addChild(Edge(23, vertexC))
      vertexC.addChild(Edge(34, vertexD))
      vertexD.addChild(Edge(41, vertexA))

      val graph = new Graph(vertexA)

      graph.print()
    }
    it("Copy and Print") {

      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")
      val vertexD = Vertex("D")

      vertexA.addChild(Edge(12, vertexB))
      vertexA.addChild(Edge(13, vertexC))
      vertexB.addChild(Edge(23, vertexC))
      vertexC.addChild(Edge(34, vertexD))
      vertexD.addChild(Edge(41, vertexA))

      val graph = new Graph(vertexA)
      graph.copy().print()
    }
  }
}
