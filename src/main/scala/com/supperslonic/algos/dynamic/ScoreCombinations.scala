package com.supperslonic.algos.dynamic

class ScoreCombinations {

  def count(points: Seq[Int], score: Int): Option[Int] = {

    var count = new Array[Int](score + 1)
    count(0) = 1

      for (j <- 0 to score)
        for (p <- points.indices) {
          val point = points(p)
          println(s"$point, $j")
          if (j >= point) {
            count(j) = count(j) + count(j - point)
          }

          println(count.toSeq)
        }

    count.lastOption
  }
}
