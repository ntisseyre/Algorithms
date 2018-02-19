package com.supperslonic.algos.lists

case class Node[T](value: T, var next: Option[Node[T]] = None)
class SingleLinkedList[T](var root: Option[Node[T]] = None) {

  override def equals(obj: scala.Any): Boolean = this.root.equals(obj.asInstanceOf[SingleLinkedList[T]].root)

  def isEmpty: Boolean = root.isEmpty

  def sort(compare: (Option[Node[T]], Option[Node[T]]) => Int): SingleLinkedList[T] = {
    if (isEmpty) return new SingleLinkedList[T]()
    new SingleLinkedList[T](mergeSort(root, compare))
  }

  private def mergeSort(start: Option[Node[T]], compare: (Option[Node[T]], Option[Node[T]]) => Int): Option[Node[T]] = {
    val middle = halfPointer(start)
    if (middle.isEmpty) return start

    val tmp = middle.get.next
    middle.get.next = None

    var left = mergeSort(start, compare)
    var right = mergeSort(tmp, compare)
    var root: Option[Node[T]] = None

    println(s"==== left=$left, right=$right")

    var previous: Option[Node[T]] = None
    while (left.isDefined || right.isDefined) {
      var next: Option[Node[T]] = None
      if (compare(left, right) > 0) {
        next = right
        right = right.get.next
      } else {
        next = left
        left = left.get.next
      }
      previous match {
        case None => root = next
        case Some(node) => node.next = next
      }
      previous = next
    }

    root
  }

  def halfPointer(): Option[Node[T]] = {
    halfPointer(root)
  }

  def halfPointer(node: Option[Node[T]]): Option[Node[T]] = {

    var pointer = node
    var pointer2Late: Option[Node[T]] = None

    while (pointer.isDefined && pointer.get.next.isDefined) {
      pointer2Late = if (pointer2Late.isDefined) pointer2Late.get.next else pointer
      pointer = pointer.get.next.get.next
    }

    pointer2Late
  }
}

object SingleLinkedList {

  def parseInt(list: String): SingleLinkedList[Int] = {
    val parseItem: (String) => Int = (item) => item.toInt
    parse(list, parseItem)
  }

  def sortInt(list: SingleLinkedList[Int]): SingleLinkedList[Int] = {
    val compare: (Option[Node[Int]], Option[Node[Int]]) => Int = (item1, item2) => {
      if(item1.isEmpty && item2.isEmpty) 0
      else if (item2.isDefined && item1.isEmpty) 1
      else if (item1.isDefined && item2.isEmpty) -1
      else item1.get.value.compareTo(item2.get.value)
    }
    list.sort(compare)
  }

  def parse[T](list: String, parseItem: (String) => T): SingleLinkedList[T] = {

    val result = new SingleLinkedList[T]()
    var resultPointer = result.root

    list.split(",")
      .map(item => item.trim)
      .filter(item => !item.isEmpty)
      .foreach(item => {

        val newNode = Some(Node(parseItem(item)))
        if (resultPointer.isEmpty) {
          result.root = newNode
        } else {
          resultPointer.get.next = newNode
        }

        resultPointer = newNode
      })

    result
  }
}
