package com.supperslonic.algos.heaps

class MinHeap[TElement  <: Comparable[TElement]] extends Heap[TElement] {
  override def insert(elem: TElement): Unit = {
    heap.append(elem)
    moveUp(heap.size - 1)
   //println(s"=== Insert Heap: $heap")
  }

  override def remove(elem: TElement): Unit = {
    val removeIndex = heap.indexOf(elem)
    val lastIndex = heap.size - 1

    swap(removeIndex, lastIndex)
    heap.remove(lastIndex)

    if (removeIndex != heap.size) {
      if (getMaxBetweenParent(removeIndex) != removeIndex) moveUp(removeIndex) else moveDown(removeIndex)
    }

    //println(s"=== Remove Heap: $heap")
  }

  override def replace(oldElem: TElement, newElem: TElement): Unit = {
    val replaceIndex = heap.indexOf(oldElem)
    heap(replaceIndex) = newElem

    if (replaceIndex != heap.size) {
      if (getMaxBetweenParent(replaceIndex) != replaceIndex) moveUp(replaceIndex) else moveDown(replaceIndex)
    }

    //println(s"=== Replace Heap: $heap")
  }

  def getMin: TElement = heap.head

  private def moveUp(index: Int): Unit = {
    var upIndex = index
    var maxIndex = getMaxBetweenParent(upIndex)

    while (upIndex != maxIndex) {
      swap(maxIndex, upIndex)
      upIndex = maxIndex
      maxIndex = getMaxBetweenParent(upIndex)
    }
  }

  private def moveDown(index: Int): Unit = {
    var downIndex = index
    var minIndex = getMinBetweenChildren(downIndex)
    while (downIndex != minIndex) {
      swap(downIndex, minIndex)
      downIndex = minIndex
      minIndex = getMinBetweenChildren(downIndex)
    }
  }

  private def getMaxBetweenParent(index: Int): Int = {
    getParentIndex(index) match {
      case Some(parent) => if (heap(index).compareTo(heap(parent)) > 0) index else parent
      case None => index
    }
  }

  private def getMinBetweenChildren(index: Int): Int = {

    val max = getLeftChildIndex(index) match {
      case Some(left) => if (heap(index).compareTo(heap(left)) < 0) index else left
      case None => index
    }

    getRightChildIndex(index) match {
      case Some(right) => if (heap(max).compareTo(heap(right)) < 0) max else right
      case None => max
    }
  }
}
