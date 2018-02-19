package com.supperslonic.algos.search

import scala.collection.mutable

class LargestRectangularInHistogram {
  def find(histogram: Seq[Int]): Int = {
    val stack = new mutable.ArrayBuffer[Int]()

    var i = 0
    var max = 0
    while (i < histogram.size) {

      if (stack.isEmpty || histogram(i) >= histogram(stack.last)) {
        stack.append(i)
        i += 1
      } else {
        val theHighest = histogram(stack.last)
        stack.remove(stack.size - 1)

        val surface = theHighest * (if (stack.isEmpty) i else i - stack.last - 1)
        if (surface > max) {
          max = surface
        }
      }
    }

    while (stack.nonEmpty) {
      val theHighest = histogram(stack.last)
      stack.remove(stack.size - 1)
      val surface = theHighest * (if (stack.isEmpty) i else i - stack.last - 1)
      if (surface > max) {
        max = surface
      }
    }

    max
  }
}
