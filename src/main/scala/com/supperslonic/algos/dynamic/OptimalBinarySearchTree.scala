package com.supperslonic.algos.dynamic

case class NodeFrequency(value: Int, frequency: Int)

class OptimalBinarySearchTree {
  def tree(nodes: Seq[NodeFrequency]): Int = {
    val tabulation = Array.ofDim[Int](nodes.size, nodes.size)

    for (i <- tabulation.indices) tabulation(i)(i) = nodes(i).frequency
    printArray(tabulation)

    for (nodesCount <- 2 to nodes.size) {
      for (i <- 0 to nodes.size - nodesCount) {
        val j = i + nodesCount - 1

        tabulation(i)(j) = Int.MaxValue
        val sumFreq = sumFrequency(nodes, i, j)

        for (k <- i to j) {
          val frequencySubTree = sumFreq +
            (if (k - 1 < i) 0 else tabulation(i)(k - 1)) +
            (if (k + 1 > j) 0 else tabulation(k + 1)(j))

          if (tabulation(i)(j) > frequencySubTree) tabulation(i)(j) = frequencySubTree
        }
        printArray(tabulation)
      }
    }

    tabulation.head.last
  }

  private def printArray(tabulation: Array[Array[Int]]): Unit = {
    tabulation.foreach(line => println(line.toSeq))
    println()
  }

  private def sumFrequency(nodes: Seq[NodeFrequency], startIndex: Int, endIndex: Int): Int = {

    var result = 0
    for (i <- startIndex to endIndex) {
      result += nodes(i).frequency
    }

    result
  }
}
