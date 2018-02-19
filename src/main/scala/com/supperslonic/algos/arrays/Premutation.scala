package com.supperslonic.algos.arrays

import scala.collection.mutable

class Premutation {
  def apply(elems: mutable.Seq[String], premutation: mutable.Seq[Int]): Seq[String] = {

    for (i <- premutation.indices) {

      while (premutation(i) != i) {
        val targetIndex = premutation(i)

        //which element and where it should go -> tmp
        val tmp = elems(targetIndex)
        val tmpIndex = premutation(targetIndex)

        //put element on a new position
        elems(targetIndex) = elems(i)
        premutation(targetIndex) = targetIndex

        //put tmp into current position
        elems(i) = tmp
        premutation(i) = tmpIndex
      }
    }

    elems
  }
}
