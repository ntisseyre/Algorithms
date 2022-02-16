package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class NextPremutationSpec extends FunSpec with Matchers {
  describe("Next Premutation") {
    it("1023 -> 1032") {

      val elems = mutable.Seq(1, 0, 2, 3)
      val logic = new NextPremutation()

      val result = logic.compute(elems)
      println(result)
      result shouldBe Seq(1, 0, 3, 2)
    }
    it("1032 -> 1203") {
      val elems = mutable.Seq(1, 0, 3, 2)
      val logic = new NextPremutation()

      val result = logic.compute(elems)
      println(result)
      result shouldBe Seq(1, 2, 0, 3)
    }
    it("1203 -> 1230") {
      val elems = mutable.Seq(1, 2, 0, 3)
      val logic = new NextPremutation()

      val result = logic.compute(elems)
      println(result)
      result shouldBe Seq(1, 2, 3, 0)
    }
    it("1230 -> 1302") {
      val elems = mutable.Seq(1, 2, 3, 0)
      val logic = new NextPremutation()

      val result = logic.compute(elems)
      println(result)
      result shouldBe Seq(1, 3, 0, 2)
    }
    it("534976 -> 536479") {
      val elems = mutable.Seq(5, 3, 4, 9, 7, 6)
      val logic = new NextPremutation()

      val result = logic.compute(elems)
      println(result)
      result shouldBe Seq(5, 3, 6, 4, 7, 9)
    }
    it("4321 -> 4321") {
      val elems = mutable.Seq(4, 3, 2, 1)
      val logic = new NextPremutation()

      val result = logic.compute(elems)
      println(result)
      result shouldBe Seq(4, 3, 2, 1)
    }
  }
}
