package com.supperslonic.algos.heaps

import org.scalatest.{FunSpec, Matchers}

class MinHeapSpec extends FunSpec with Matchers {
  describe("Add to Min Heap") {
    it("1") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)

      algorithm.getMin shouldBe 1
      algorithm.heap shouldBe Seq(1)
    }
    it("2 -> 1") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(2)
      algorithm.insert(1)

      algorithm.getMin shouldBe 1
      algorithm.heap shouldBe Seq(1, 2)
    }
    it("3 -> 1 -> 2") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(3)
      algorithm.insert(1)
      algorithm.insert(2)

      algorithm.getMin shouldBe 1
      algorithm.heap shouldBe Seq(1, 3, 2)
    }
    it("1 -> 2 -> 3") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)

      algorithm.getMin shouldBe 1
      algorithm.heap shouldBe Seq(1, 2, 3)
    }
    it("Large") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(10)
      algorithm.insert(17)
      algorithm.insert(8)
      algorithm.insert(3)
      algorithm.insert(49)
      algorithm.insert(15)

      algorithm.getMin shouldBe 3
      algorithm.heap shouldBe Seq(3, 8, 10, 17, 49, 15)
    }
  }
  describe("Remove from Min Heap") {
    it("1") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.remove(1)

      algorithm.isEmpty shouldBe true
    }
    it("1->2 remove 2") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.remove(2)

      algorithm.heap shouldBe Seq(1)
    }
    it("1->2->3 remove 3") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)
      algorithm.remove(3)

      algorithm.heap shouldBe Seq(1, 2)
    }
    it("1->2->3 remove 1") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)
      algorithm.remove(1)

      algorithm.heap shouldBe Seq(2, 3)
    }
    it("1->2->3 remove 2") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)
      algorithm.remove(2)

      algorithm.heap shouldBe Seq(1, 3)
    }
    it("Remove Large") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(10)
      algorithm.insert(24)
      algorithm.insert(33)
      algorithm.insert(20)
      algorithm.insert(78)
      algorithm.insert(15)
      algorithm.remove(20)

      algorithm.heap shouldBe Seq(10, 24, 15, 33, 78)
    }
    it("Remove Root from Large") {
      val algorithm = new MinHeap[Integer]()
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

      val minElement = algorithm.pop()

      minElement shouldBe 1
      algorithm.heap shouldBe Seq(2, 4, 3, 14, 22, 39, 33, 45, 17)
    }
  }
  describe("Replace in Min Heap") {
    it("1 -> 2") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.replace(1, 2)

      algorithm.heap shouldBe Seq(2)
    }
    it("1->2 replace 2->3") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.replace(2, 3)

      algorithm.heap shouldBe Seq(1, 3)
    }
    it("1->2->3 replace 3->1") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(1)
      algorithm.insert(2)
      algorithm.insert(3)
      algorithm.replace(3, 1)

      algorithm.heap shouldBe Seq(1, 2, 1)
    }
    it("Replace Large") {
      val algorithm = new MinHeap[Integer]()
      algorithm.insert(10)
      algorithm.insert(24)
      algorithm.insert(33)
      algorithm.insert(20)
      algorithm.insert(78)
      algorithm.insert(15)
      algorithm.replace(20, 68)

      algorithm.heap shouldBe Seq(10, 24, 15, 68, 78, 33)
    }
    it("Replace Root from Large") {
      val algorithm = new MinHeap[Integer]()
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
      algorithm.replace(1, 30)

      algorithm.heap shouldBe Seq(2, 4, 3, 14, 22, 39, 30, 45, 17, 33)
    }
  }
}
