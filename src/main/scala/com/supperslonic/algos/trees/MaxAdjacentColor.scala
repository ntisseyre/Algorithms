package com.supperslonic.algos.trees

import java.util.UUID

import com.supperslonic.algos.common.Color.Color

import scala.collection.mutable

case class ColorCell(color: Color, var groupId: Option[UUID] = None)

case class MaxColor(color: Color, count: Int)

case class ColorCounter(var max: Int, var current: Int)

class MaxAdjacentColor() {
  val globalCounter: mutable.Map[UUID, Either[UUID, MaxColor]] = mutable.Map[UUID, Either[UUID, MaxColor]]()

  def max(node: Node[ColorCell]): MaxColor = {

    walk(node)
    //println(globalCounter)

    val result = globalCounter
        .map(item => item._2 match {
          case Left(_) => None
          case Right(maxColor) => Some(maxColor)
        })
        .filter(item => item.isDefined)
      .maxBy {  value => (value.get.count, value.get.color) }

    result.get
  }

  private def walk(node: Node[ColorCell]): Unit = {

    val leftOriginal = handleCell(node.data.color, node.left)
    val rightOriginal = handleCell(node.data.color, node.right)

    val leftWalk = leftOriginal.map(uuid => getGroupId(uuid))
    val rightWalk = rightOriginal.map(uuid => getGroupId(uuid))

    //println(s"leftWalk=$leftWalk, rightWalk=$rightWalk")

    if (leftWalk.isEmpty && rightWalk.isEmpty) {
      //println("No Adj")
      //Most bottom right or no adjacent
      val groupId = UUID.randomUUID()
      node.data.groupId = Some(groupId)
      setCount(groupId, node, 1)
    } else if (leftWalk.isDefined && rightWalk.isDefined) {
      //println("Both Adj")

      val groupId = rightWalk.get
      if (leftWalk.get == rightWalk.get) {
        //Same group
        setCount(groupId, node, getCount(groupId) + 1)
      } else {
        //Merge groups
        setCount(groupId, node, getCount(leftWalk.get) + getCount(groupId) + 1)
        referCount(leftWalk.get, groupId)
      }
      node.data.groupId = Some(groupId)

    } else if (leftWalk.isDefined) {
      //println("Only Left")
      node.data.groupId = leftWalk
      setCount(leftWalk.get, node, getCount(leftWalk.get) + 1)
    } else {
      //println("Only Right")
      node.data.groupId = rightWalk
      setCount(rightWalk.get, node, getCount(rightWalk.get) + 1)
    }

    //println(s"========= $globalCounter")
  }

  private def handleCell(parentColor: Color,
                         optNode: Option[Node[ColorCell]]): Option[UUID] = {

    optNode match {
      case None => None
      case Some(node) =>
        if (node.data.groupId.isEmpty) walk(node)
        if (node.data.color == parentColor) node.data.groupId else None
    }
  }

  private def getGroupId(originalGroupId: UUID): UUID = {
    globalCounter(originalGroupId) match {
      case Left(uuid) => getGroupId(uuid)
      case Right(_) => originalGroupId
    }
  }

  private def referCount(fromGroupId: UUID, toGroupId: UUID): Unit = {
    globalCounter.put(fromGroupId, Left(toGroupId))
  }

  private def setCount(groupId: UUID, node: Node[ColorCell], count: Int): Unit = {
    globalCounter.put(groupId, Right(MaxColor(node.data.color, count)))
  }

  private def getCount(groupId: UUID): Int = {
    globalCounter(groupId) match {
      case Left(uuid) => getCount(uuid)
      case Right(maxColor) => maxColor.count
    }
  }
}