package com.supperslonic.algos.search

import scala.collection.mutable
import scala.util.Random

class LargestKelementInArray {

  private val random = new Random
  def pick(elems: mutable.Seq[Int], k: Int): Int = {

    var leftIndex = 0
    var rightIndex = elems.size - 1

    while (leftIndex <= rightIndex) {

      var pivotIndex = medianPivot(elems, leftIndex, rightIndex)
      //var pivotIndex = randomPivot(leftIndex, rightIndex)
      println(s"Pivot in $elems is elems($pivotIndex)=${elems(pivotIndex)}")

      pivotIndex = partition(elems, leftIndex, rightIndex, pivotIndex)

      if (k - 1 == pivotIndex) {
        return pivotIndex
      } else if (pivotIndex > k - 1) {
        rightIndex = pivotIndex - 1
      } else {
        leftIndex = pivotIndex + 1
      }
    }

    -1
  }

  /**
    * Put all elements that are greater than pivot on the left,
    * all elements that are less than pivot on the right.
    *
    * @param elems      elements
    * @param leftIndex  most left index.
    * @param rightIndex most right index.
    * @return an index of pivot after partitioning.
    */
  private def partition(elems: mutable.Seq[Int],
                        leftIndex: Int,
                        rightIndex: Int,
                        pivotIndex: Int): Int = {

    if(leftIndex == rightIndex) return leftIndex

    val pivot = elems(pivotIndex)
    swap(elems, rightIndex, pivotIndex)

    var leftMaxIndex = leftIndex
    for (i <- leftIndex until rightIndex) {
      if (elems(i) > pivot) {
        swap(elems, i, leftMaxIndex)
        leftMaxIndex += 1
      }
    }

    swap(elems, rightIndex, leftMaxIndex)
    println(s"Partitioned elements: $elems, where pivot=${elems(leftMaxIndex)}")

    leftMaxIndex
  }

  private def randomPivot(leftIndex: Int, rightIndex: Int): Int =
    leftIndex + random.nextInt(rightIndex - leftIndex + 1)

  private def medianPivot(elems: mutable.Seq[Int], leftIndex: Int, rightIndex: Int): Int = {

    val medians = new mutable.ArrayBuffer[Int]()
    val size = rightIndex - leftIndex + 1

    println(s"leftIndex=$leftIndex, rightIndex=$rightIndex, size=$size")

    var i = 0
    while (i < size/5) {
      val startIndex = leftIndex + i * 5
      val endIndex = startIndex + 5
      val sorted = elems.slice(startIndex, endIndex).sorted
      println(s"sorted slice $sorted")
      medians.append(sorted(sorted.size / 2))
      i += 1
    }

    val leftOver = size % 5
    if (leftOver != 0) {

      val startIndex = leftIndex + i * 5
      val endIndex = startIndex + leftOver
      val sorted = elems.slice(startIndex, endIndex).sorted
      println(s"sorted slice $sorted")
      medians.append(sorted(sorted.size / 2))
    }


    println(s"Medians: $medians")
    if(medians.size == 1) 0 else pick(medians, medians.size / 2)
  }

  private def swap(elems: mutable.Seq[Int], index1: Int, index2: Int): Unit = {
    val tmp = elems(index1)
    elems(index1) = elems(index2)
    elems(index2) = tmp
  }
}
