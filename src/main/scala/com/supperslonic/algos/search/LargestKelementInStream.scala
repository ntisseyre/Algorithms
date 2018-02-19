package com.supperslonic.algos.search

import com.supperslonic.algos.heaps.MinHeap

class LargestKelementInStream {

  def pick(elems: Iterator[Int], k: Int): Int = {
    val minHeap = new MinHeap[Integer]()

    for (i <- 0 until k) minHeap.insert(elems.next())

    while (elems.hasNext) {

      val elem = elems.next()

      if (elem > minHeap.getMin) {
        minHeap.replace(minHeap.getMin, elem)
      }
    }

    minHeap.getMin
  }
}
