package com.supperslonic.algos.trees

import scala.collection.mutable

case class Node(weight: Int = 0, var left: Option[Node] = None, var right: Option[Node] = None) {
  def isLeaf: Boolean = left.isEmpty && right.isEmpty
  def hasLeft: Boolean = left.isDefined
  def hasRight: Boolean = right.isDefined
}

/**
  * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
  * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
  * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
  */
class Tree(val root: Option[Node]) {

  def isBalanced: Boolean = {
    val height = isBalanced(root, 0)
    println(s"Balanced Height: $height")
    height != -1
  }

  def size: Int = {
    val s = size(root, 0)
    println(s"Size: $s")
    s
  }

  def printBoundaries(): String = {
    val stringBuilder = mutable.StringBuilder.newBuilder
    root match{
      case None => stringBuilder.append("None")
      case Some(rootNode) =>
        stringBuilder.append(formatNode(rootNode))
        printLeftTopDown(rootNode.left, isBoundary = true, stringBuilder)
        printRightBottomUp(rootNode.right, isBoundary = true, stringBuilder)
    }

    stringBuilder.mkString
  }

  private def size(node: Option[Node], count: Int): Int = {
    if (node.isDefined) {
      val leftCount = size(node.get.left, count)
      val rightCount = size(node.get.right, count)
      val result = leftCount + rightCount + 1
      result
    } else {
      count
    }
  }

  private def printLeftTopDown(node: Option[Node], isBoundary: Boolean, stringBuilder: mutable.StringBuilder): Unit = {
    if (node.isDefined) {
      if (isBoundary || node.get.isLeaf) stringBuilder.append(formatNode(node.get))
      printLeftTopDown(node.get.left, isBoundary, stringBuilder)
      printLeftTopDown(node.get.right, isBoundary && node.get.left.isEmpty, stringBuilder)
    }
  }

  private def printRightBottomUp(node: Option[Node], isBoundary: Boolean, stringBuilder: mutable.StringBuilder): Unit = {
    if (node.isDefined) {
      printRightBottomUp(node.get.left, isBoundary && node.get.right.isEmpty, stringBuilder)
      printRightBottomUp(node.get.right, isBoundary, stringBuilder)
      if (isBoundary || node.get.isLeaf) stringBuilder.append(formatNode(node.get))
    }
  }

  private def isBalanced(node: Option[Node], count: Int): Int = {
    if (node.isDefined) {
      val leftCount = isBalanced(node.get.left, count)
      if (leftCount == -1) return -1
      val rightCount = isBalanced(node.get.right, count)
      if (rightCount == -1) return -1
      if (Math.abs(leftCount - rightCount) > 1) -1 else Math.max(leftCount, rightCount) + 1
    } else {
      count
    }
  }

  def sumsUpTo(sum: Int): Boolean = {
    sumsUpTo(root, sum, 0)
  }
  def sumsUpTo(node: Option[Node], sum: Int, current: Int): Boolean = {
    if (node.isDefined) {
      if (sumsUpTo(node.get.left, sum, current + node.get.weight)) return true
      if (sumsUpTo(node.get.right, sum, current + node.get.weight)) return true
      false
    } else current == sum
  }

  def preOrder(): Unit = {
    preOrder(root)
    println()
  }

  def preOrder(node: Option[Node]): Unit = {
    if (node.isDefined) {
      print(formatNode(node.get))
      preOrder(node.get.left)
      preOrder(node.get.right)
    }
  }

  def inOrder(): Unit = {
    inOrder(root)
    println()
  }
  def inOrder(node: Option[Node]): Unit = {
    if (node.isDefined) {
      inOrder(node.get.left)
      print(formatNode(node.get))
      inOrder(node.get.right)
    }
  }

  def postOrder(): Unit = {
    postOrder(root)
    println()
  }
  def postOrder(node: Option[Node]): Unit = {
    if (node.isDefined) {
      postOrder(node.get.left)
      postOrder(node.get.right)
      print(formatNode(node.get))
    }
  }

  private def formatNode(node: Node): String = node.weight + ", "
}

object Tree {
  def apply(weights: Seq[Int]): Tree = new Tree(balancedTree(weights, 0))

  private def balancedTree(weights: Seq[Int], index: Int): Option[Node] = {

    if (index >= weights.size) None
    else
      Some(Node(weights(index), balancedTree(weights, 2 * index + 1), balancedTree(weights, 2 * index + 2)))
  }
}
