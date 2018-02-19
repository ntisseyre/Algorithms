package com.supperslonic.algos.trees

import org.scalatest.{FunSpec, Matchers}

class TreeSpec extends FunSpec with Matchers {

  describe("Tree") {
    it("Empty array") {
      val nodes = Seq.empty[Int]

      val tree = Tree(nodes)
      tree.root shouldBe None

      tree.isBalanced shouldBe true
      tree.size shouldBe nodes.size
    }
    it("Single Element") {
      val nodes = Seq(1)

      val tree = Tree(nodes)
      tree.root shouldBe Some(Node(1))

      tree.isBalanced shouldBe true
      tree.size shouldBe nodes.size
    }
    it("2 Elements") {
      val nodes = Seq(1, 2)

      val tree = Tree(nodes)
      tree.root shouldBe Some(Node(1, Some(Node(2))))

      tree.isBalanced shouldBe true
      tree.size shouldBe nodes.size
    }
    it("3 Elements") {
      val nodes = Seq(1, 2, 3)

      val tree = Tree(nodes)
      tree.root shouldBe Some(Node(1, Some(Node(2)), Some(Node(3))))

      tree.isBalanced shouldBe true
      tree.size shouldBe nodes.size
    }
    it("Multi Elements") {
      val nodes = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
      val tree = Tree(nodes)
      tree.preOrder()
      tree.inOrder()
      tree.postOrder()

      tree.isBalanced shouldBe true
      tree.size shouldBe nodes.size
      tree.sumsUpTo(21) shouldBe false
    }
  }
  describe("Print Boundaries") {
    /**
      *        20
      *     /     \
      *    8      22
      *   / \       \
      *  4  12      25
      *    /  \
      *   10  14
      */
    it("Can Print 1") {

      val node10 = Node(10)
      val node14 = Node(14)
      val node12 = Node(12, Some(node10), Some(node14))
      val node25 = Node(25)

      val node4 = Node(4)
      val node8 = Node(8, Some(node4), Some(node12))
      val node22 = Node(22, None, Some(node25))

      val root = Node(20, Some(node8), Some(node22))
      val tree = new Tree(Some(root))

      val result =  tree.printBoundaries()
      println(result)

      result shouldBe "20, 8, 4, 10, 14, 25, 22, "
    }

    /**
      *        40
      *     /      \
      *    20      60
      *   / \    /   \
      *  10 30  50   70
      *   \      \
      *    5     55
      *     \
      *      45
      */
    it("Can Print 2") {

      val node45= Node(45)
      val node5 = Node(5, None, Some(node45))
      val node10 = Node(10, None, Some(node5))
      val node30 = Node(30)
      val node20 = Node(20, Some(node10), Some(node30))

      val node55 = Node(55)
      val node50 = Node(50, None, Some(node55))
      val node70 = Node(70)
      val node60 = Node(60, Some(node50), Some(node70))

      val root = Node(40, Some(node20), Some(node60))
      val tree = new Tree(Some(root))

      val result =  tree.printBoundaries()
      println(result)

      result shouldBe "40, 20, 10, 5, 45, 30, 55, 70, 60, "
    }

    /**
      *        1
      *     /      \
      *    2       3
      *   / \    /  \
      *  4   5  6    7
      *     /    \    \
      *    8      9    10
      */
    it("Can Print 3") {

      val node8= Node(8)
      val node5 = Node(5, Some(node8), None)
      val node4 = Node(4)
      val node2 = Node(2, Some(node4), Some(node5))

      val node9 = Node(9)
      val node6 = Node(6, None, Some(node9))
      val node10 = Node(10)
      val node7 = Node(7, None, Some(node10))
      val node3 = Node(3, Some(node6), Some(node7))

      val root = Node(1, Some(node2), Some(node3))
      val tree = new Tree(Some(root))

      val result =  tree.printBoundaries()
      println(result)

      result shouldBe "1, 2, 4, 8, 9, 10, 7, 3, "
    }
  }
}
