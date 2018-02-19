package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class OptimalBinarySearchTreeSpec extends FunSpec with Matchers {
  describe("Optimal Binary Search Tree") {
    it("4 elements") {
      val nodes = Seq(NodeFrequency(10, 4),
        NodeFrequency(12, 2),
        NodeFrequency(16, 6),
        NodeFrequency(21, 3))

      val optimalBinarySearchTree =  new OptimalBinarySearchTree()
      optimalBinarySearchTree.tree(nodes) shouldBe 26
    }
  }
}
