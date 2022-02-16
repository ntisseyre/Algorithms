package com.supperslonic.algos.graphs

import org.scalatest.{FunSpec, Matchers}

class FindBoxInLimitedRoomsSpec extends FunSpec with Matchers {
  describe("Find all the boxes in the rooms with a limited number of rooms to visit") {

    /*

              Room1
         /            \
     Room2             Room3
      /               /       \
   Room4(box) ->  Room5(box)   Room6
                                \
                               Room7
                            /   |    \
                        Room8  Room9  Room10(box)


    limit = 3
   ------------------
    Room1 -> Room2 -> Room4
    Room1 -> Room3 -> Room5


    limit = 4
    ------------------
    Room1 -> Room2 -> Room4
    Room1 -> Room2 -> Room4 -> Room5
    Room1 -> Room3 -> Room5
    */

    it("No boxes") {

      val room1 = Vertex("Room 1")
      val room2 = Vertex("Room 2")
      val room3 = Vertex("Room 3")
      val room4 = Vertex("Room 4")

      room1.addChild(Edge(1, room2))
      room1.addChild(Edge(1, room3))
      room2.addChild(Edge(1, room4))
      room4.addChild(Edge(1, room1))

      val graph = new Graph(room1)

      val algorithm = new FindBoxInLimitedRooms()
      val result = algorithm.find(graph, 10)

      result shouldBe Seq.empty[String]
    }

    it("Single room, single box") {

      val room1 = Vertex("Room 1", true)
      val graph = new Graph(room1)

      val algorithm = new FindBoxInLimitedRooms()
      val result = algorithm.find(graph, 1)

      result shouldBe Seq("Room 1")
    }

    it("Multiple boxes") {

      val room1 = Vertex("Room 1", true)
      val room2 = Vertex("Room 2")
      val room3 = Vertex("Room 3")
      val room4 = Vertex("Room 4", true)

      room1.addChild(Edge(1, room2))
      room1.addChild(Edge(1, room3))
      room2.addChild(Edge(1, room4))
      room4.addChild(Edge(1, room1))

      val graph = new Graph(room1)

      val algorithm = new FindBoxInLimitedRooms()
      val result = algorithm.find(graph, 10)

      result shouldBe Seq("Room 1", "Room 1 -> Room 2 -> Room 4", "Room 1 -> Room 2 -> Room 4 -> Room 1")
    }
  }
}
