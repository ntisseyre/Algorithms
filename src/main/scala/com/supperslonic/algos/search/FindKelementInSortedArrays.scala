package com.supperslonic.algos.search

class FindKelementInSortedArrays {

  def pick(elems1: Seq[Int], elems2: Seq[Int], k: Int): Double = {

    var left = Math.max(0, k - elems2.size)
    var right = Math.min(elems1.size, k)

    while (left < right) {
      val partition1 = left + ((right - left) >> 1)
      val partition2 = Math.max(0, k - partition1)

      val maxLeft1 = if (partition1 == 0) Int.MinValue else elems1(partition1 - 1)
      val minRight1 = if (partition1 >= elems1.size) Int.MaxValue else elems1(partition1)

      val maxLeft2 = if (partition2 == 0) Int.MinValue else elems2(partition2 - 1)
      val minRight2 = if (partition2 >= elems2.size) Int.MaxValue else elems2(partition2)

      if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
        return Math.max(maxLeft1, maxLeft2)
      } else if (maxLeft1 > minRight2) {
        right = partition1 - 1
      } else {
        left = partition1 + 1
      }
    }

    //left == right
    val maxLeft1 = if (right <= 0) Int.MinValue else elems1(right - 1)
    val maxLeft2 = if (k - right <= 0) Int.MinValue else elems2(k - right - 1)
    Math.max(maxLeft1, maxLeft2)
  }
}
