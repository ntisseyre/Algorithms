package com.supperslonic.algos.lists

class AddListBasedIntegers {

  def add(number1: SingleLinkedList[Int], number2: SingleLinkedList[Int]): SingleLinkedList[Int] = {

    val result = new SingleLinkedList[Int]()
    var carryOn = 0
    var n1Pointer = number1.root
    var n2Pointer = number2.root
    val zeroNode = Node(0)
    var resultPointer = result.root

    while (n1Pointer.isDefined || n2Pointer.isDefined || carryOn !=0) {
      var sum = n1Pointer.getOrElse(zeroNode).value + n2Pointer.getOrElse(zeroNode).value + carryOn
      if (sum > 9) {
        sum = sum - 10
        carryOn = 1
      } else {
        carryOn = 0
      }

      val newNode = Some(Node(sum))

      if (resultPointer.isEmpty) {
        result.root = newNode
      } else {
        resultPointer.get.next = newNode
      }

      resultPointer = newNode
      n1Pointer = n1Pointer.getOrElse(zeroNode).next
      n2Pointer = n2Pointer.getOrElse(zeroNode).next
    }

    result
  }
}
