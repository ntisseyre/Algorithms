package com.supperslonic.algos.lists

import org.scalatest.{FunSpec, Matchers}

class AddListBasedIntegersSpec extends FunSpec with Matchers {

  describe("Add List-Based Integers") {
    it("Both are empty") {
      val number1 = SingleLinkedList.parseInt("")
      val number2 = SingleLinkedList.parseInt("")

      val bigInt = new AddListBasedIntegers()
      val result = bigInt.add(number1, number2)

      result.root shouldBe None
    }
    it("Number1 is Not Defined") {
      val number1 = SingleLinkedList.parseInt("")
      val number2 = SingleLinkedList.parseInt("1, 2, 3")

      val bigInt = new AddListBasedIntegers()
      val result = bigInt.add(number1, number2)

      result.root shouldBe Some(Node(1, Some(Node(2, Some(Node(3))))))
    }
    it("Number2 is Not Defined") {
      val number1 = SingleLinkedList.parseInt("1, 2, 3")
      val number2 = SingleLinkedList.parseInt("")

      val bigInt = new AddListBasedIntegers()
      val result = bigInt.add(number1, number2)

      result.root shouldBe Some(Node(1, Some(Node(2, Some(Node(3))))))
    }
    it("324 + 453") {
      val number1 = SingleLinkedList.parseInt("4, 2, 3")
      val number2 = SingleLinkedList.parseInt("3, 5, 4")

      val bigInt = new AddListBasedIntegers()
      val result = bigInt.add(number1, number2)

      result.root shouldBe Some(Node(7, Some(Node(7, Some(Node(7))))))
    }
    it("999 + 999") {
      val number1 = SingleLinkedList.parseInt("9, 9, 9")
      val number2 = SingleLinkedList.parseInt("9, 9, 9")

      val bigInt = new AddListBasedIntegers()
      val result = bigInt.add(number1, number2)

      result.root shouldBe Some(Node(8, Some(Node(9, Some(Node(9, Some(Node(1))))))))
    }
  }
}
