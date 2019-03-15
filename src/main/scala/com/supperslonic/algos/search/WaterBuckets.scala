package com.supperslonic.algos.search

import scala.collection.mutable

case class Bucket(capacity: Int, var state: Int = 0) {
  def isFull: Boolean = capacity == state
  def availableCapacity: Int = capacity - state
}

class WaterBuckets {

  def canPour(buckets: Seq[Bucket], finalState: Seq[Int]): Boolean  = {
    val visited = mutable.Set[Seq[Int]]()
    canPour(buckets, finalState, visited)
  }

  private def canPour(buckets: Seq[Bucket], finalState: Seq[Int], visited: mutable.Set[Seq[Int]]): Boolean = {

    println(buckets.map(b => b.state).mkString(","))

    if (isInState(buckets, finalState)) return true

    for (i <- buckets.indices) {
      for (j <- buckets.indices) {
        if (i != j) {

          val source = buckets(i)
          val destination = buckets(j)

          if (!destination.isFull) {
            val availableCapacity = destination.availableCapacity
            val pour = Math.min(availableCapacity, source.state)
            source.state -= pour
            destination.state += pour
            val state = buckets.map(b => b.state)

            if (!visited.contains(state)) {
              visited.add(state)
              if (canPour(buckets, finalState, visited)) return true
            }

            source.state += pour
            destination.state -= pour
          }
        }
      }
    }

    false
  }

  private def isInState(buckets: Seq[Bucket], finalState: Seq[Int]): Boolean = {
    val usedIndexes = mutable.Set[Int]()
    !finalState.exists(state => missing(state, buckets, usedIndexes))
  }

  private def missing(state: Int, buckets: Seq[Bucket], usedIndexes: mutable.Set[Int]): Boolean = {
    for (i <- buckets.indices) {
      if (buckets(i).state == state && !usedIndexes.contains(i)) {
        usedIndexes.add(i)
        return false
      }
    }
    true
  }
}
