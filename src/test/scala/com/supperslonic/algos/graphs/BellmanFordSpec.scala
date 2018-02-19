package com.supperslonic.algos.graphs

import org.scalatest.{FunSpec, Matchers}

class BellmanFordSpec extends FunSpec with Matchers {
  describe("Bellman Ford") {
    it("Shortest Path For 3 Elements") {

      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")

      vertexA.addChild(Edge(2, vertexB))
      vertexA.addChild(Edge(5, vertexC))
      vertexC.addChild(Edge(-10, vertexB))

      val graph = new Graph(vertexA)
      val bellmanFord = new BellmanFord()
      val result = bellmanFord.find(graph)

      println(result)

      result.size shouldBe 3
      result("A").distance shouldBe 0
      result("B").distance shouldBe -5
      result("C").distance shouldBe 5
    }
    it("Shortest Path For 5 Elements") {

      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")
      val vertexD = Vertex("D")
      val vertexE = Vertex("E")

      vertexA.addChild(Edge(-1, vertexB))
      vertexA.addChild(Edge(4, vertexC))

      vertexB.addChild(Edge(3, vertexC))
      vertexB.addChild(Edge(2, vertexD))
      vertexB.addChild(Edge(2, vertexE))

      vertexD.addChild(Edge(5, vertexC))
      vertexD.addChild(Edge(1, vertexB))

      vertexE.addChild(Edge(-3, vertexD))

      val graph = new Graph(vertexA)
      val bellmanFord = new BellmanFord()
      val result = bellmanFord.find(graph)

      println(result)

      result.size shouldBe 5
      result("A").distance shouldBe 0
      result("B").distance shouldBe -1
      result("C").distance shouldBe 2
      result("D").distance shouldBe -2
      result("E").distance shouldBe 1
    }
    it("Shortest Path For 6 Elements") {

      val vertexS = Vertex("S")
      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")
      val vertexD = Vertex("D")
      val vertexE = Vertex("E")

      vertexS.addChild(Edge(10, vertexA))
      vertexS.addChild(Edge(8, vertexE))

      vertexA.addChild(Edge(2, vertexC))

      vertexB.addChild(Edge(1, vertexA))

      vertexC.addChild(Edge(-2, vertexB))

      vertexD.addChild(Edge(-4, vertexA))
      vertexD.addChild(Edge(-1, vertexC))

      vertexE.addChild(Edge(1, vertexD))

      val graph = new Graph(vertexS)
      val bellmanFord = new BellmanFord()
      val result = bellmanFord.find(graph)

      println(result)

      result.size shouldBe 6
      result("S").distance shouldBe 0
      result("A").distance shouldBe 5
      result("B").distance shouldBe 5
      result("C").distance shouldBe 7
      result("D").distance shouldBe 9
      result("E").distance shouldBe 8
    }
  }
}
