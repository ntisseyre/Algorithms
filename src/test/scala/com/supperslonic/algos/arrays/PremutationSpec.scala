package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class PremutationSpec extends FunSpec with Matchers {
  describe("Premutation") {
    it("abcd") {

      val elems = mutable.Seq("a", "b", "c", "d")
      val premutation = mutable.Seq(2, 0, 1, 3)
      val logic = new Premutation()

      val result = logic.apply(elems, premutation)

      println(result)
      result shouldBe Seq("b", "c", "a", "d")
    }
  }
}
