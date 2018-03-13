package com.supperslonic.algos.search

import scala.collection.mutable

case class Point(x: Int, y: Int)

case class Slope(x: Int, y: Int)

class MaxPointsOnLine {
  def maxPoints(points: Array[Point]): Int = {
    var max = 0
    val slopes = mutable.Map[Slope, Int]()

    for (i <- points.indices) {

      var overlapPoints = 0
      var currentMax = 0

      for (j <- i + 1 until points.length) {

        if (points(i) == points(j)) {
          overlapPoints += 1
        } else {
          val y = points(i).y - points(j).y
          val x = points(i).x - points(j).x

          val slope = if (x == 0 && y == 0) {
            Slope(0, 0)
          } else {
            val gcd = greatestCommonDivisor(y, x)
            //println(gcd)
            Slope(x / gcd, y / gcd)
          }

          slopes.get(slope) match {
            case None => slopes.put(slope, 1)
            case Some(count) => slopes.put(slope, count + 1)
          }

          currentMax = Math.max(currentMax, slopes(slope))
        }

        //println(slopes)
      }

      max = Math.max(max, currentMax + overlapPoints + 1)
      slopes.clear()

    }

    max
  }

  def greatestCommonDivisor(a: Int, b: Int): Int = {
    b match {
      case 0 => a
      case _ => greatestCommonDivisor(b, a % b) // tail recursion
    }
  }
}
