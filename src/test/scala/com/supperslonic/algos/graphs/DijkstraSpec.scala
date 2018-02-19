package com.supperslonic.algos.graphs

import org.scalatest.{FunSpec, Matchers}

class DijkstraSpec extends FunSpec with Matchers {
  describe("Dijkstra") {
    ignore("Prove it doesn't work with negative edges") {
      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")

      vertexA.addChild(Edge(2, vertexC))
      vertexA.addChild(Edge(5, vertexB))
      vertexB.addChild(Edge(-10, vertexC))

      val graph = new Graph(vertexA)
      graph.print()

      val dijkstra = new Dijkstra()
      val result = dijkstra.find(graph)

      println(result)

      result.size shouldBe 3
      result("A").distance shouldBe 0
      result("B").distance shouldBe 5
      result("C").distance shouldBe -5
    }
    it("Shortest Path For 3 Elements") {

      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")

      vertexA.addChild(Edge(4, vertexB))
      vertexA.addChild(Edge(8, vertexC))
      vertexB.addChild(Edge(3, vertexC))

      val graph = new Graph(vertexA)
      graph.print()

      val dijkstra = new Dijkstra()
      val result = dijkstra.find(graph)

      println(result)

      result.size shouldBe 3
      result("A").distance shouldBe 0
      result("B").distance shouldBe 4
      result("C").distance shouldBe 7
    }
    it("Shortest Path For 9 Elements") {

      val vertexA = Vertex("A")
      val vertexB = Vertex("B")
      val vertexC = Vertex("C")
      val vertexD = Vertex("D")
      val vertexE = Vertex("E")
      val vertexF = Vertex("F")
      val vertexG = Vertex("G")
      val vertexH = Vertex("H")
      val vertexI = Vertex("I")

      vertexA.addChild(Edge(4, vertexB))
      vertexA.addChild(Edge(8, vertexH))

      vertexB.addChild(Edge(8, vertexC))
      vertexB.addChild(Edge(11, vertexH))
      vertexB.addChild(Edge(4, vertexA))

      vertexC.addChild(Edge(8, vertexB))
      vertexC.addChild(Edge(7, vertexD))
      vertexC.addChild(Edge(2, vertexI))
      vertexC.addChild(Edge(4, vertexF))

      vertexD.addChild(Edge(7, vertexC))
      vertexD.addChild(Edge(9, vertexE))
      vertexD.addChild(Edge(14, vertexF))

      vertexE.addChild(Edge(9, vertexD))
      vertexE.addChild(Edge(10, vertexF))

      vertexF.addChild(Edge(10, vertexE))
      vertexF.addChild(Edge(14, vertexD))
      vertexF.addChild(Edge(4, vertexC))
      vertexF.addChild(Edge(2, vertexG))

      vertexG.addChild(Edge(2, vertexF))
      vertexG.addChild(Edge(1, vertexH))
      vertexG.addChild(Edge(6, vertexI))

      vertexH.addChild(Edge(1, vertexG))
      vertexH.addChild(Edge(7, vertexI))
      vertexH.addChild(Edge(11, vertexB))
      vertexH.addChild(Edge(8, vertexA))

      vertexI.addChild(Edge(2, vertexC))
      vertexI.addChild(Edge(6, vertexG))
      vertexI.addChild(Edge(7, vertexH))

      val graph = new Graph(vertexA)
      graph.print()

      val dijkstra = new Dijkstra()
      val result = dijkstra.find(graph)

      println(result)

      result.size shouldBe 9
      result("A").distance shouldBe 0
      result("B").distance shouldBe 4
      result("C").distance shouldBe 12
      result("D").distance shouldBe 19
      result("E").distance shouldBe 21
      result("F").distance shouldBe 11
      result("G").distance shouldBe 9
      result("H").distance shouldBe 8
      result("I").distance shouldBe 14
    }
  }
}
