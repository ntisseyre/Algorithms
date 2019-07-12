package com.supperslonic.algos.graphs

import com.supperslonic.algos.common
import com.supperslonic.algos.common.Color
import com.supperslonic.algos.common.Color.Color
import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class ColorGraphSpec extends FunSpec with Matchers {
  describe("Color adjacent nodes in different color") {
    it("2 Nodes, 2 colors") {

      implicit val availableColors: Set[common.Color.Value] = Set(Color.Red, Color.Green)
      val vertexA = Vertex("A", vertexColor())
      val vertexB = Vertex("B", vertexColor())

      vertexA.addChild(Edge(1, vertexB))
      vertexB.addChild(Edge(1, vertexA))

      val graph = new Graph(vertexA)
      val algorithm = new ColorGraph()

      val canColor = algorithm.color(graph)

      canColor shouldBe true
      algorithm.getColorOpt(vertexA) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertexB) shouldBe Some(Color.Green)
    }

    it("2 Nodes, 1 color") {

      implicit val availableColors: Set[common.Color.Value] = Set(Color.Red)
      val vertexA = Vertex("A", vertexColor())
      val vertexB = Vertex("B", vertexColor())

      vertexA.addChild(Edge(1, vertexB))
      vertexB.addChild(Edge(1, vertexA))

      val graph = new Graph(vertexA)
      val algorithm = new ColorGraph()

      val canColor = algorithm.color(graph)

      canColor shouldBe false
    }

    it("9 Nodes, 3 colors") {

      implicit val availableColors: Set[common.Color.Value] = Set(Color.Red, Color.Green, Color.Blue)
      val vertexA = Vertex("A", vertexColor())
      val vertexB = Vertex("B", vertexColor())
      val vertexC = Vertex("C", vertexColor())
      val vertexD = Vertex("D", vertexColor())
      val vertexE = Vertex("E", vertexColor())
      val vertexF = Vertex("F", vertexColor())
      val vertexG = Vertex("G", vertexColor())
      val vertexH = Vertex("H", vertexColor())
      val vertexI = Vertex("I", vertexColor())

      vertexA.addChild(Edge(1, vertexB))
      vertexA.addChild(Edge(1, vertexD))
      vertexA.addChild(Edge(1, vertexE))

      vertexB.addChild(Edge(1, vertexA))
      vertexB.addChild(Edge(1, vertexC))
      vertexB.addChild(Edge(1, vertexE))
      vertexB.addChild(Edge(1, vertexF))

      vertexC.addChild(Edge(1, vertexF))
      vertexC.addChild(Edge(1, vertexB))

      vertexD.addChild(Edge(1, vertexA))
      vertexD.addChild(Edge(1, vertexG))
      vertexD.addChild(Edge(1, vertexE))
      vertexD.addChild(Edge(1, vertexH))

      vertexE.addChild(Edge(1, vertexA))
      vertexE.addChild(Edge(1, vertexB))
      vertexE.addChild(Edge(1, vertexF))
      vertexE.addChild(Edge(1, vertexD))
      vertexE.addChild(Edge(1, vertexH))
      vertexE.addChild(Edge(1, vertexI))

      vertexF.addChild(Edge(1, vertexB))
      vertexF.addChild(Edge(1, vertexC))
      vertexF.addChild(Edge(1, vertexE))
      vertexF.addChild(Edge(1, vertexI))

      vertexG.addChild(Edge(1, vertexD))
      vertexG.addChild(Edge(1, vertexH))

      vertexH.addChild(Edge(1, vertexG))
      vertexH.addChild(Edge(1, vertexD))
      vertexH.addChild(Edge(1, vertexE))
      vertexH.addChild(Edge(1, vertexI))

      vertexI.addChild(Edge(1, vertexH))
      vertexI.addChild(Edge(1, vertexE))
      vertexI.addChild(Edge(1, vertexF))


      val graph = new Graph(vertexA)
      val algorithm = new ColorGraph()

      val canColor = algorithm.color(graph)

      canColor shouldBe true
      algorithm.getColorOpt(vertexA) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertexB) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertexC) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertexD) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertexE) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertexF) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertexG) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertexH) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertexI) shouldBe Some(Color.Blue)
    }

    it("27 Nodes, 3 colors") {

      implicit val availableColors: Set[common.Color.Value] = Set(Color.Red, Color.Green, Color.Blue)
      val vertex1 = Vertex("01", vertexColor())
      val vertex2 = Vertex("02", vertexColor())
      val vertex3 = Vertex("03", vertexColor())
      val vertex4 = Vertex("04", vertexColor())
      val vertex5 = Vertex("05", vertexColor())
      val vertex6 = Vertex("06", vertexColor())
      val vertex7 = Vertex("07", vertexColor())
      val vertex8 = Vertex("08", vertexColor())
      val vertex9 = Vertex("09", vertexColor())
      val vertex10 = Vertex("10", vertexColor())

      val vertex11 = Vertex("11", vertexColor())
      val vertex12 = Vertex("12", vertexColor())
      val vertex13 = Vertex("13", vertexColor())
      val vertex14 = Vertex("14", vertexColor())
      val vertex15 = Vertex("15", vertexColor())
      val vertex16 = Vertex("16", vertexColor())
      val vertex17 = Vertex("17", vertexColor())
      val vertex18 = Vertex("18", vertexColor())
      val vertex19 = Vertex("19", vertexColor())
      val vertex20 = Vertex("20", vertexColor())

      val vertex21 = Vertex("21", vertexColor())
      val vertex22 = Vertex("22", vertexColor())
      val vertex23 = Vertex("23", vertexColor())
      val vertex24 = Vertex("24", vertexColor())
      val vertex25 = Vertex("25", vertexColor())
      val vertex26 = Vertex("26", vertexColor())
      val vertex27 = Vertex("27", vertexColor())

      vertex1.addChild(Edge(1, vertex2))
      vertex1.addChild(Edge(1, vertex22))

      vertex2.addChild(Edge(1, vertex1))
      vertex2.addChild(Edge(1, vertex22))

      vertex3.addChild(Edge(1, vertex4))
      vertex3.addChild(Edge(1, vertex6))
      vertex3.addChild(Edge(1, vertex8))

      vertex4.addChild(Edge(1, vertex3))
      vertex4.addChild(Edge(1, vertex7))
      vertex4.addChild(Edge(1, vertex8))

      vertex5.addChild(Edge(1, vertex9))

      vertex6.addChild(Edge(1, vertex3))
      vertex6.addChild(Edge(1, vertex11))

      vertex7.addChild(Edge(1, vertex4))
      vertex7.addChild(Edge(1, vertex11))

      vertex8.addChild(Edge(1, vertex3))
      vertex8.addChild(Edge(1, vertex4))
      vertex8.addChild(Edge(1, vertex13))
      vertex8.addChild(Edge(1, vertex22))

      vertex9.addChild(Edge(1, vertex5))
      vertex9.addChild(Edge(1, vertex13))

      vertex10.addChild(Edge(1, vertex11))
      vertex10.addChild(Edge(1, vertex14))

      vertex11.addChild(Edge(1, vertex6))
      vertex11.addChild(Edge(1, vertex7))
      vertex11.addChild(Edge(1, vertex10))
      vertex11.addChild(Edge(1, vertex15))

      vertex12.addChild(Edge(1, vertex16))
      vertex12.addChild(Edge(1, vertex17))

      vertex13.addChild(Edge(1, vertex8))
      vertex13.addChild(Edge(1, vertex9))
      vertex13.addChild(Edge(1, vertex17))

      vertex14.addChild(Edge(1, vertex10))

      vertex15.addChild(Edge(1, vertex11))

      vertex16.addChild(Edge(1, vertex12))
      vertex16.addChild(Edge(1, vertex19))
      vertex16.addChild(Edge(1, vertex20))
      vertex16.addChild(Edge(1, vertex21))

      vertex17.addChild(Edge(1, vertex12))
      vertex17.addChild(Edge(1, vertex13))

      vertex18.addChild(Edge(1, vertex19))
      vertex18.addChild(Edge(1, vertex23))
      vertex18.addChild(Edge(1, vertex24))

      vertex19.addChild(Edge(1, vertex16))
      vertex19.addChild(Edge(1, vertex18))
      vertex19.addChild(Edge(1, vertex24))
      vertex19.addChild(Edge(1, vertex25))
      vertex19.addChild(Edge(1, vertex26))

      vertex20.addChild(Edge(1, vertex16))
      vertex20.addChild(Edge(1, vertex21))
      vertex20.addChild(Edge(1, vertex27))

      vertex21.addChild(Edge(1, vertex16))
      vertex21.addChild(Edge(1, vertex20))
      vertex21.addChild(Edge(1, vertex27))

      vertex22.addChild(Edge(1, vertex1))
      vertex22.addChild(Edge(1, vertex2))
      vertex22.addChild(Edge(1, vertex8))
      vertex22.addChild(Edge(1, vertex23))

      vertex23.addChild(Edge(1, vertex18))
      vertex23.addChild(Edge(1, vertex22))
      vertex23.addChild(Edge(1, vertex24))

      vertex24.addChild(Edge(1, vertex18))
      vertex24.addChild(Edge(1, vertex19))
      vertex24.addChild(Edge(1, vertex23))
      vertex24.addChild(Edge(1, vertex25))

      vertex25.addChild(Edge(1, vertex19))
      vertex25.addChild(Edge(1, vertex24))
      vertex25.addChild(Edge(1, vertex26))

      vertex26.addChild(Edge(1, vertex19))
      vertex26.addChild(Edge(1, vertex25))
      vertex26.addChild(Edge(1, vertex27))

      vertex27.addChild(Edge(1, vertex20))
      vertex27.addChild(Edge(1, vertex21))
      vertex27.addChild(Edge(1, vertex26))

      val graph = new Graph(vertex1)
      val algorithm = new ColorGraph()

      val canColor = algorithm.color(graph)

      canColor shouldBe true
      algorithm.getColorOpt(vertex1) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex2) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex3) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex4) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertex5) shouldBe Some(Color.Blue)

      algorithm.getColorOpt(vertex6) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex7) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex8) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex9) shouldBe Some(Color.Red)

      algorithm.getColorOpt(vertex10) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex11) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex12) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex13) shouldBe Some(Color.Blue)

      algorithm.getColorOpt(vertex14) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex15) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex16) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex17) shouldBe Some(Color.Red)

      algorithm.getColorOpt(vertex18) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex19) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex20) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex21) shouldBe Some(Color.Green)

      algorithm.getColorOpt(vertex22) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertex23) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertex24) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertex25) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertex26) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertex27) shouldBe Some(Color.Red)
    }

    it("States of Australia, 3 colors") {

      implicit val availableColors: Set[common.Color.Value] = Set(Color.Red, Color.Green, Color.Blue)
      val vertexWA = Vertex("WA", vertexColor())
      val vertexNT = Vertex("NT", vertexColor())
      val vertexQ = Vertex("Q", vertexColor())
      val vertexNSW = Vertex("NSW", vertexColor())
      val vertexV = Vertex("V", vertexColor())
      val vertexSA = Vertex("SA", vertexColor())

      vertexWA.addChild(Edge(1, vertexNT))
      vertexWA.addChild(Edge(1, vertexSA))

      vertexNT.addChild(Edge(1, vertexWA))
      vertexNT.addChild(Edge(1, vertexSA))
      vertexNT.addChild(Edge(1, vertexQ))

      vertexSA.addChild(Edge(1, vertexWA))
      vertexSA.addChild(Edge(1, vertexNT))
      vertexSA.addChild(Edge(1, vertexQ))
      vertexSA.addChild(Edge(1, vertexNSW))
      vertexSA.addChild(Edge(1, vertexV))

      vertexQ.addChild(Edge(1, vertexNT))
      vertexQ.addChild(Edge(1, vertexSA))
      vertexQ.addChild(Edge(1, vertexNSW))

      vertexV.addChild(Edge(1, vertexSA))
      vertexV.addChild(Edge(1, vertexNSW))

      val graph = new Graph(vertexWA)
      val algorithm = new ColorGraph()

      val canColor = algorithm.color(graph)

      canColor shouldBe true
      algorithm.getColorOpt(vertexWA) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertexNT) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertexSA) shouldBe Some(Color.Green)
      algorithm.getColorOpt(vertexQ) shouldBe Some(Color.Red)
      algorithm.getColorOpt(vertexNSW) shouldBe Some(Color.Blue)
      algorithm.getColorOpt(vertexV) shouldBe Some(Color.Red)
    }
  }

  private def vertexColor()(implicit colors: Set[Color]): VertexColor = {
    val availableColors = mutable.Set[Color]()
    colors.foreach(color => availableColors.add(color))
    VertexColor(availableColors = availableColors)
  }
}
