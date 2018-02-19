package com.supperslonic.algos.lists

import org.scalatest.{FunSpec, Matchers}

class SingleLinkedListSpec extends FunSpec with Matchers {
  describe("Parse Single Linked List") {
    it("Empty string") {
      val singleLinkedList = SingleLinkedList.parseInt("")
      singleLinkedList.isEmpty shouldBe true
    }
    it("Single element string") {
      val list = "1"
      val singleLinkedList = SingleLinkedList.parseInt(list)

      singleLinkedList.root shouldBe Some(Node(1))
    }
    it("2 elements string") {
      val list = "1, 2"
      val singleLinkedList = SingleLinkedList.parseInt(list)

      singleLinkedList.root shouldBe Some(Node(1, Some(Node(2))))
    }
    it("3 elements string") {
      val list = "1, 2, 3"
      val singleLinkedList = SingleLinkedList.parseInt(list)

      singleLinkedList.root shouldBe Some(Node(1, Some(Node(2, Some(Node(3))))))
    }
  }
  describe("Half Single Linked List") {
    it("Empty List") {
      val singleLinkedList = SingleLinkedList.parseInt("")
      singleLinkedList.halfPointer() shouldBe None
    }
    it("Single element") {
      val singleLinkedList = SingleLinkedList.parseInt("1")
      singleLinkedList.halfPointer() shouldBe None
    }
    it("2 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("1, 2")
      singleLinkedList.halfPointer().get.value shouldBe 1
    }
    it("3 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("1, 2, 3")
      singleLinkedList.halfPointer().get.value shouldBe 1
    }
    it("4 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("1, 2, 3, 4")
      singleLinkedList.halfPointer().get.value shouldBe 2
    }
    it("10 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("1, 2, 3, 4, 5, 6, 7, 8, 9, 10")
      singleLinkedList.halfPointer().get.value shouldBe 5
    }
    it("11 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11")
      singleLinkedList.halfPointer().get.value shouldBe 5
    }
    it("12 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12")
      singleLinkedList.halfPointer().get.value shouldBe 6
    }
  }
  describe("Sort") {
    it("Empty List") {
      val singleLinkedList = SingleLinkedList.parseInt("")
      SingleLinkedList.sortInt(singleLinkedList).isEmpty shouldBe true
    }
    it("Single element") {
      val singleLinkedList = SingleLinkedList.parseInt("1")
      SingleLinkedList.sortInt(singleLinkedList) shouldBe SingleLinkedList.parseInt("1")
    }
    it("2 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("2, 1")
      SingleLinkedList.sortInt(singleLinkedList) shouldBe SingleLinkedList.parseInt("1, 2")
    }
    it("3 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("2, 3, 1")
      SingleLinkedList.sortInt(singleLinkedList) shouldBe SingleLinkedList.parseInt("1, 2, 3")
    }
    it("4 elements") {
      val singleLinkedList = SingleLinkedList.parseInt("2, 4, 3, 1")
      SingleLinkedList.sortInt(singleLinkedList) shouldBe SingleLinkedList.parseInt("1, 2, 3, 4")
    }
    it("Multi elements") {
      val singleLinkedList = SingleLinkedList.parseInt("3, 2, 2, 11, 7, 5, 11")
      SingleLinkedList.sortInt(singleLinkedList) shouldBe SingleLinkedList.parseInt("2, 2, 3, 5, 7, 11, 11")
    }
  }
}
