package com.supperslonic.algos.heaps

class MaxHeap[TElement <: Comparable[TElement]] extends Heap[TElement] {

  override def insert(elem: TElement): Unit = {
    heap.append(elem)
    moveUp(heap.size - 1)
    println(s"=== Insert Heap: $heap")
  }

  override def remove(elem: TElement): Unit = {
    val removeIndex = heap.indexOf(elem)
    val lastIndex = heap.size - 1

    swap(removeIndex, lastIndex)
    heap.remove(lastIndex)

    if (removeIndex != heap.size) {
      if (getMinBetweenParent(removeIndex) != removeIndex) moveUp(removeIndex) else moveDown(removeIndex)
    }

    println(s"=== Remove Heap: $heap")
  }

  override def replace(oldElem: TElement, newElem: TElement): Unit = {
    val replaceIndex = heap.indexOf(oldElem)
    heap(replaceIndex) = newElem

    if (replaceIndex != heap.size) {
      if (getMinBetweenParent(replaceIndex) != replaceIndex) moveUp(replaceIndex) else moveDown(replaceIndex)
    }

    println(s"=== Replace Heap: $heap")
  }

  def getMax: TElement = heap.head

  private def moveDown(index: Int): Unit = {
    var downIndex = index
    var maxIndex = getMaxBetweenChildren(downIndex)
    while (downIndex != maxIndex) {
      swap(downIndex, maxIndex)
      downIndex = maxIndex
      maxIndex = getMaxBetweenChildren(downIndex)
    }
  }

  private def moveUp(index: Int): Unit = {
    var upIndex = index
    var minIndex = getMinBetweenParent(upIndex)

    while (upIndex != minIndex) {
      swap(minIndex, upIndex)
      upIndex = minIndex
      minIndex = getMinBetweenParent(upIndex)
    }
  }

  private def getMinBetweenParent(index: Int): Int = {
    getParentIndex(index) match {
      case Some(parent) => if (heap(index).compareTo(heap(parent)) < 0) index else parent
      case None => index
    }
  }

  private def getMaxBetweenChildren(index: Int): Int = {

    val max = getLeftChildIndex(index) match {
      case Some(left) => if (heap(index).compareTo(heap(left)) > 0) index else left
      case None => index
    }

    getRightChildIndex(index) match {
      case Some(right) => if (heap(max).compareTo(heap(right)) > 0) max else right
      case None => max
    }
  }
}
