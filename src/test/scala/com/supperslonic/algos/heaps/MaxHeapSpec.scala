package com.supperslonic.algos.heaps

import org.scalatest.{FunSpec, Matchers}

class MaxHeapSpec extends FunSpec with Matchers {
  describe("Add to Max Heap") {
    it("1") {
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)

      algorithm.getMax shouldBe 1
      algorithm.heap shouldBe Seq(1)
    }
    it("2 -> 1") {
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(2)
      algorithm.insert(1)

      algorithm.getMax shouldBe 2
      algorithm.heap shouldBe Seq(2, 1)
    }
    it("3 -> 1 -> 2") {
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(3)
      algorithm.insert(1)
      algorithm.insert(2)

      algorithm.getMax shouldBe 3
      algorithm.heap shouldBe Seq(3, 1, 2)
    }
    it("1 -> 2 -> 3") {
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)

      algorithm.getMax shouldBe 3
      algorithm.heap shouldBe Seq(3, 1, 2)
    }
    it("Large") {
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(10)
      algorithm.insert(17)
      algorithm.insert(8)
      algorithm.insert(3)
      algorithm.insert(49)
      algorithm.insert(15)

      algorithm.getMax shouldBe 49
      algorithm.heap shouldBe Seq(49, 17, 15, 3, 10, 8)
    }
  }
  describe("Remove from Max Heap") {
    it("1"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.remove(1)

      algorithm.isEmpty shouldBe true
    }
    it("1->2 remove 2"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.remove(2)

      algorithm.heap shouldBe Seq(1)
    }
    it("1->2->3 remove 3"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)
      algorithm.remove(3)

      algorithm.heap shouldBe Seq(2, 1)
    }
    it("1->2->3 remove 1"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)
      algorithm.remove(1)

      algorithm.heap shouldBe Seq(3, 2)
    }
    it("1->2->3 remove 2"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)
      algorithm.remove(2)

      algorithm.heap shouldBe Seq(3, 1)
    }
    it("Remove Large"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(10)
      algorithm.insert(24)
      algorithm.insert(33)
      algorithm.insert(20)
      algorithm.insert(78)
      algorithm.insert(15)
      algorithm.remove(20)

      algorithm.heap shouldBe Seq(78, 33, 24, 10, 15)
    }
    it("Remove Root from Large"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(45)
      algorithm.insert(39)
      algorithm.insert(3)
      algorithm.insert(17)
      algorithm.insert(33)
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(4)
      algorithm.insert(14)
      algorithm.insert(22)

      val maxElement = algorithm.pop()

      maxElement shouldBe 45
      algorithm.heap shouldBe Seq(39, 33, 3, 17, 22, 1, 2, 4, 14)
    }
  }
  describe("Replace in Max Heap") {
    it("1 -> 2"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.replace(1, 2)

      algorithm.heap shouldBe Seq(2)
    }
    it("1->2 replace 2->3"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.replace(2, 3)

      algorithm.heap shouldBe Seq(3, 1)
    }
    it("Replace Large"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(10)
      algorithm.insert(24)
      algorithm.insert(33)
      algorithm.insert(20)
      algorithm.insert(78)
      algorithm.insert(15)
      algorithm.replace(20, 45)

      algorithm.heap shouldBe Seq(78, 45, 24, 10, 33, 15)
    }
    it("Replace Root in Large"){
      val algorithm = new MaxHeap[Integer]()
      algorithm.insert(45)
      algorithm.insert(39)
      algorithm.insert(3)
      algorithm.insert(17)
      algorithm.insert(33)
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(4)
      algorithm.insert(14)
      algorithm.insert(22)
      algorithm.replace(45, 6)

      algorithm.heap shouldBe Seq(39, 33, 3, 17, 22, 1, 2, 4, 14, 6)
    }
  }
}
