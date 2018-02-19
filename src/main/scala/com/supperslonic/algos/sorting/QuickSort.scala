package com.supperslonic.algos.sorting

import scala.collection.mutable
/**
  * When does the worst case of Quicksort occur?
  *
  * The answer depends on strategy for choosing pivot. In early versions of Quick Sort where leftmost (or rightmost) element is chosen
  * as pivot, the worst occurs in following cases:
  *
  * 1) Array is already sorted in same order.
  * 2) Array is already sorted in reverse order.
  * 3) All elements are same (special case of case 1 and 2)
  *
  * Since these cases are very common use cases, the problem was easily solved by choosing either a random index for the pivot,
  * choosing the middle index of the partition or (especially for longer partitions) choosing the median of the first,
  * middle and last element of the partition for the pivot.
  *
  * With these modifications, the worst case of Quick sort has less chances to occur, but worst case can still occur if the input array
  * is such that the maximum (or minimum) element is always chosen as pivot.
  */
class QuickSort {
  def sort(elems: mutable.Seq[Int], startIndex: Int, endIndex: Int): Unit = {

    var i = startIndex
    var j = endIndex
    // calculate pivot number, I am taking pivot as middle index number
    val pivot = elems(startIndex + (endIndex - startIndex) / 2)

    while (i <= j) {

      /**
        * In each iteration, we will identify a number from left side which
        * is greater then the pivot value, and also we will identify a number
        * from right side which is less then the pivot value. Once the search
        * is done, then we exchange both numbers.
        */
      while (elems(i) < pivot) i += 1
      while (elems(j) > pivot) j -= 1

      //swap
      if (i <= j) {
        val tmp = elems(i)
        elems(i) = elems(j)
        elems(j) = tmp

        //move index to next position on both sides
        i += 1
        j -= 1
      }
    }

    println(elems)
    // call quickSort() method recursively
    if(startIndex < j) sort(elems, startIndex, j)
    if(i < endIndex) sort(elems, i, endIndex)
  }
}
