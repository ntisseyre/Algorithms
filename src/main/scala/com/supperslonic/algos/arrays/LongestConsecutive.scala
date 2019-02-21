package com.supperslonic.algos.arrays

import scala.collection.mutable

/**
  * At first look, time complexity looks more than O(n).
  * If we take a closer look, we can notice that it is O(n) under the assumption that hash insert and search take O(1) time.
  * The function S.find() inside the while loop is called at most twice for every element.
  *
  * For example, consider the case when all array elements are consecutive.
  * In this case, the outer find is called for every element, but we go inside the if condition only for the smallest element.
  * Once we are inside the if condition, we call find() one more time for every other element.
  */
class LongestConsecutive {
  def find(elems: Seq[Int]): Int = {

    // Hash all the array elements
    val nextElement = new mutable.HashSet[Int]()
    elems.foreach(elem => nextElement.add(elem))

    var max = 0

    // check each possible sequence from the start
    // then update optimal length
    for (i <- elems.indices) {
      // if current element is the starting
      // element of a sequence

      if (!nextElement.contains(elems(i) - 1)) {
        // Then check for next elements in the
        // sequence
        var j = elems(i)
        while (nextElement.contains(j)) j += 1

        // update  optimal length if this length
        // is more
        //println(elems(i) + " " + j + " " +(j - elems(i)))
        if (max < j - elems(i))
          max = j - elems(i)
      }
    }
    max
  }
}
