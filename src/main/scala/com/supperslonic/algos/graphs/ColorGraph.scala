package com.supperslonic.algos.graphs

import com.supperslonic.algos.common.Color.Color

import scala.collection.mutable

case class Constraint(vertexA: Vertex, vertexB: Vertex)
case class VertexColor(var color: Option[Color] = None, availableColors: mutable.Set[Color])
/**
  * Color a graph, where adjacent nodes can't have same color.
  * If this is not possible, return false.
  */
class ColorGraph {

  def color(graph: Graph): Boolean = color(graph.root)

  private def color(vertex: Vertex): Boolean = {

    val availableColors = getAvailableColors(vertex).iterator

    while (availableColors.hasNext) {
      val color = availableColors.next()

      //Pick one color and see if solution is possible
      setColor(vertex, color)
      val possibleSolutionExist = filterAvailableColors(vertex)
      println(s"possibleSolutionExist=$possibleSolutionExist")

      if (possibleSolutionExist && colorAdjacent(vertex)) {
        //Solution is possible for this color
        return true
      } else {
        //Solution is not possible for this color
        resetColor(vertex)
      }
    }

    false
  }

  private def colorAdjacent(vertex: Vertex): Boolean = {
    println(s"adjacent=${vertex.getChildren}")
    vertex.getChildren
      .map(edge => edge.toVertex)
      .filter(child => getColorOpt(child).isEmpty)
      .map(child => color(child))
      .forall(canColor => canColor)
  }

  /**
    * Filter available colors for adjacent vertexes.
    *
    * @param vertex vertex with set color.
    * @return False if an empty list of AvailableColors is detected, current solution is doomed for failure
    */
  private def filterAvailableColors(vertex: Vertex): Boolean = {
    val queue = mutable.Queue[Constraint]()
    enqueueAdjacent(vertex, queue)

    while (queue.nonEmpty) {
      val constraint = queue.dequeue()

      println(s"constraint=$constraint")
      val availableColorsA = getAvailableColors(constraint.vertexA)
      val availableColorsB = getAvailableColors(constraint.vertexB)
      val setColor = getColorOpt(constraint.vertexA)

      //Remove color that is already set
      if (setColor.isDefined) {
        if (availableColorsB.remove(setColor.get)) {
          if (availableColorsB.isEmpty) {
            return false
          } else {
            //Verify constraints of adjacent vertexes
            enqueueAdjacent(constraint.vertexB, queue)
          }
        }
      }

      //Verify available colors have options for adjacent vertexes
      if (availableColorsA.size == 1 && availableColorsB.size == 1 && availableColorsA.head == availableColorsB.head) {
        return false
      }
    }

    true
  }

  private def setColor(vertex: Vertex, color: Color): Unit = {
    vertex.data.asInstanceOf[VertexColor].color = Some(color)
  }

  private def resetColor(vertex: Vertex): Unit = {
    val color = getColorOpt(vertex).get
    vertex.data.asInstanceOf[VertexColor].color = None
    vertex.getChildren
      .map(edge => edge.toVertex)
      .filter(child => getColorOpt(child).isEmpty)
      .foreach(child => getAvailableColors(child).add(color))
  }

  def getColorOpt(vertex: Vertex): Option[Color] = vertex.data.asInstanceOf[VertexColor].color

  private def getAvailableColors(vertex: Vertex): mutable.Set[Color] = vertex.data.asInstanceOf[VertexColor].availableColors

  private def enqueueAdjacent(vertex: Vertex, queue: mutable.Queue[Constraint]): Unit = {
    vertex.getChildren
      .map(edge => edge.toVertex)
      .filter(child => getColorOpt(child).isEmpty)
      .foreach(child => queue.enqueue(Constraint(vertex, child)))
  }
}
