package com.supperslonic.algos.lists

import org.scalatest.{FunSpec, Matchers}

class PivotSpec extends FunSpec with Matchers {

  describe("Pivot") {
    it("Empty list") {
      val singleLinkedList = SingleLinkedList.parseInt("")

      val pivot = new Pivot
      val result = pivot.pivoting(3, singleLinkedList)

      result.isEmpty shouldBe true
    }
    it("Single Element") {
      val singleLinkedList = SingleLinkedList.parseInt("1")

      val pivot = new Pivot
      val result = pivot.pivoting(1, singleLinkedList)

      result shouldBe SingleLinkedList.parseInt("1")
    }
    it("3 Elements") {
      val singleLinkedList = SingleLinkedList.parseInt("1, 2, 3")

      val pivot = new Pivot
      val result = pivot.pivoting(3, singleLinkedList)

      result shouldBe SingleLinkedList.parseInt("1, 2, 3")
    }
    it("Multi Elements") {
      val singleLinkedList = SingleLinkedList.parseInt("3, 2, 2, 11, 7, 5, 3, 11, 1")

      val pivot = new Pivot
      val result = pivot.pivoting(3, singleLinkedList)

      result shouldBe SingleLinkedList.parseInt("2, 2, 1, 3, 3, 11, 7, 5, 11")
    }
  }

}
