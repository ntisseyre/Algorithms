package com.supperslonic.algos.heaps

import scala.collection.mutable

trait Heap[TElement] {
  val heap = new mutable.ArrayBuffer[TElement]()

  def getParentIndex(childIndex: Int): Option[Int] = if (childIndex == 0) None else Some((childIndex - 1) >> 1)

  def getLeftChildIndex(parentIndex: Int): Option[Int] = {
    val index = parentIndex * 2 + 1
    if (index < heap.size) Some(index) else None
  }

  def getRightChildIndex(parentIndex: Int): Option[Int] = {
    val index = parentIndex * 2 + 2
    if (index < heap.size) Some(index) else None
  }

  def insert(elem: TElement): Unit

  def remove(elem: TElement): Unit

  def replace(oldElem: TElement, newElem: TElement): Unit

  def isEmpty: Boolean = heap.isEmpty

  def pop(): TElement = {
    val head = heap.head
    this.remove(head)
    head
  }

  protected def swap(index1: Int, index2: Int): Unit = {
    val tmp = heap(index1)
    heap(index1) = heap(index2)
    heap(index2) = tmp
  }
}