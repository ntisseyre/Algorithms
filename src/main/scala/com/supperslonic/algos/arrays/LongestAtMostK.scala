package com.supperslonic.algos.arrays

class LongestAtMostK {
  def find(elems: Seq[Int], k: Int): Option[(Int, Int)] = {

    val partialSum = new Array[Int](elems.size)
    partialSum(0) = elems.head
    for (i <- 1 until elems.size) partialSum(i) = partialSum(i - 1) + elems(i)

    val minSum = new Array[Int](elems.size)
    minSum(elems.size - 1) = partialSum.last
    for (i <- elems.size - 2 to 0 by -1) minSum(i) = Math.min(partialSum(i), minSum(i + 1))

    println(s"Original:    $elems")
    println(s"Partial Sum: ${partialSum.toSeq}")
    println(s"Min Sum:     ${minSum.toSeq}")

    var a = 0
    var b = 0
    var maxLength = 0
    var result: Option[(Int, Int)] = None

    while (a < elems.size && b < elems.size) {

      val minCurrent = if (a > 0) minSum(b) - partialSum(a - 1) else minSum(b)
      println(s"a=$a, b=$b, minCurrent=$minCurrent")

      if (minCurrent <= k) {
        val currentLength = b - a + 1
        if (currentLength > maxLength) {
          maxLength = currentLength
          result = Some((a, b))
        }
        b += 1
      }
      else {
        a += 1
      }
    }

    result
  }
}
