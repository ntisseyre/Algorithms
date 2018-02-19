package com.supperslonic.algos.search

import scala.collection.mutable

class FindKClosestInSortedArray {

  def pick(elems: Seq[Int], k: Int, elem: Int): Seq[Int] = {

    val result = new mutable.ArrayBuffer[Int]()

    var left = findCrossOver(elems, 0, elems.size - 1, elem)
    var right = left + 1

    if(elems(left) == elem) left -=1

    // Compare elements on left and right of crossover
    // point to find the k closest elements
    while(left >= 0 && right < elems.size && result.size != k) {
      if(elem - elems(left) < elems(right) - elem) {
        result.append(elems(left))
        left -= 1
      } else {
        result.append(elems(right))
        right += 1
      }
    }

    while(result.size != k && right < elems.size) {
      result.append(elems(right))
      right += 1
    }

    while(result.size != k && left >=0) {
      result.append(elems(left))
      left -= 1
    }

    result
  }

  /**
    * Function to find the cross over point:
    * the point before which elements are smaller than or equal to x and after which greater than x
    */
  def findCrossOver(elems: Seq[Int], startIndex: Int, endIndex: Int, elem: Int): Int = {
    println(s"left=$startIndex, right=$endIndex")
    if(elems(startIndex) >= elem) {
      startIndex
    } else if(elems(endIndex) < elem) {
     endIndex
    } else {
      val middleIndex = startIndex + ((endIndex - startIndex) >> 1)
      println(middleIndex)

      if (elems(middleIndex) <= elem && elems(middleIndex + 1) > elem) {
        middleIndex
      } else if (elems(middleIndex) < elem) {
        println("Going right")
        findCrossOver(elems, middleIndex + 1, endIndex, elem)
      } else {
        println("Going left")
        findCrossOver(elems, startIndex, middleIndex - 1, elem)
      }
    }
  }
}
