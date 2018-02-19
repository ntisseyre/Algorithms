package com.supperslonic.algos.search

/**
  * https://www.youtube.com/watch?v=LPFhl65R7ww
  */
class FindMedianSortedArrays {
  def pick(elems1: Seq[Int], elems2: Seq[Int]): Double = {

    if (elems1.size > elems2.size) return pick(elems2, elems1)

    var left = 0
    var right = elems1.size
    val partitionSize = elems1.length + ((elems2.length - elems1.size) >> 1)

    while (left <= right) {
      val partition1 = left + ((right - left) >> 1)
      val partition2 = partitionSize - partition1

      val maxLeft1 = if (partition1 == 0) Int.MinValue else elems1(partition1 - 1)
      val minRight1 = if (partition1 == elems1.size) Int.MaxValue else elems1(partition1)

      val maxLeft2 = if (partition2 == 0) Int.MinValue else elems2(partition2 - 1)
      val minRight2 = if (partition2 == elems2.size) Int.MaxValue else elems2(partition2)

      if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
        if (((elems1.size + elems2.size) & 1) == 0) {
          //even number of elements
          return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) >> 1
        } else {
          //odd number of elements
          return Math.max(maxLeft1, maxLeft2)
        }
      } else if (maxLeft1 > minRight2) {
        right = partition1 - 1
      } else {
        left = partition1 + 1
      }
    }

    throw new IllegalArgumentException()
  }
}
