package com.supperslonic.algos.sorting

import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class InsertionSortSpec extends FunSpec with Matchers {
  describe("Sorting") {
    it("Can Sort") {
      val elems = mutable.Seq(2, 3, 8, 6, 7, 1)
      val algo = new InsertionSort()

      algo.sort(elems)
      elems shouldBe Seq(1, 2, 3, 6, 7, 8)
    }
    it("Can Sort with Duplicates") {
      val elems = mutable.Seq(2, 6, 3, 8, 1, 6, 7, 1, 2)
      val algo = new InsertionSort()

      algo.sort(elems)
      elems shouldBe Seq(1, 1, 2, 2, 3, 6, 6, 7, 8)
    }
    it("Single Element") {
      val elems = mutable.Seq(2)
      val algo = new InsertionSort()

      algo.sort(elems)
      elems shouldBe Seq(2)
    }
    it("2 Elements") {
      val elems = mutable.Seq(6, 3)
      val algo = new InsertionSort()

      algo.sort(elems)
      elems shouldBe Seq(3, 6)
    }
    it("Already sorted Elements") {
      val elems = mutable.Seq(1, 2, 3, 4, 5, 6)
      val algo = new InsertionSort()

      algo.sort(elems)
      elems shouldBe Seq(1, 2, 3, 4, 5, 6)
    }
  }
}