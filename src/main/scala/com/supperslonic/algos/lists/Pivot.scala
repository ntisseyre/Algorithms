package com.supperslonic.algos.lists

class Pivot {
  def pivoting(pivotValue: Int, list: SingleLinkedList[Int]): SingleLinkedList[Int] = {

    var current = list.root
    var less: Option[Node[Int]] = None
    var pivotRoot: Option[Node[Int]] = None
    var pivot: Option[Node[Int]] = None
    var greaterRoot: Option[Node[Int]] = None
    var greater: Option[Node[Int]] = None

    while (current.isDefined) {
      if (current.get.value < pivotValue) {
        if (less.isDefined) {
          less.get.next = current
        } else {
          list.root = current
        }
        less = current
      } else if (current.get.value == pivotValue) {
        if (pivotRoot.isEmpty) {
          pivotRoot = current
        } else {
          pivot.get.next = current
        }
        pivot = current
      } else {
        if (greaterRoot.isEmpty) {
          greaterRoot = current

        } else {
          greater.get.next = current
        }
        greater = current
      }

      current = current.get.next
    }

    if(less.isDefined) less.get.next = pivotRoot
    if(pivot.isDefined) pivot.get.next = greaterRoot
    if(greater.isDefined) greater.get.next = None

    list
  }
}
