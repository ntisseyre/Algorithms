package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class DeleteKeySpec extends FunSpec with Matchers {
  describe("Delete Key"){
    it("One element") {
      val algo = new DeleteKey()

      val elems = mutable.Seq(1)
      algo.delete(elems, 2)

      elems shouldBe Seq(1)
    }
    it("One element removed") {
      val algo = new DeleteKey()

      val elems = mutable.Seq(1)
      algo.delete(elems, 1)

      elems shouldBe Seq(0)
    }
    it("Multiple keys") {
      val algo = new DeleteKey()

      val elems = mutable.Seq(2, 3, 4, 3, 5, 6, 3, 5)
      algo.delete(elems, 3)

      elems shouldBe Seq(2, 4, 5, 6, 5, 0, 0, 0)
    }
    it("Multiple keys with last element") {
      val algo = new DeleteKey()

      val elems = mutable.Seq(2, 3, 4, 3, 5, 6, 3, 5, 3)
      algo.delete(elems, 3)

      elems shouldBe Seq(2, 4, 5, 6, 5, 0, 0, 0, 0)
    }
  }
}
