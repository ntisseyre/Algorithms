package com.supperslonic.algos.trees

import com.supperslonic.algos.common.Color
import com.supperslonic.algos.common.Color.Color
import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class MaxAdjacentColorSpec extends FunSpec with Matchers {
  describe("The count of the largest contiguous block where all colors are the same") {
    it("Green 3") {
      val node = generate(Seq(
        Seq(Color.Green, Color.Green, Color.Green)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Green, 3)
    }
    it("Yellow 1") {
      val node = generate(Seq(
        Seq(Color.Yellow, Color.Green, Color.Yellow)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Yellow, 1)
    }
    it("Red 1") {
      val node = generate(Seq(
        Seq(Color.Red, Color.Yellow, Color.Blue, Color.Red)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Yellow, 1)
    }
    it("Yellow 4") {
      val node = generate(Seq(
        Seq(Color.Yellow, Color.Yellow),
        Seq(Color.Yellow, Color.Yellow)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Yellow, 4)
    }
    it("Red 3") {
      val node = generate(Seq(
        Seq(Color.Blue, Color.Red),
        Seq(Color.Red, Color.Red)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Red, 3)
    }
    it("Blue 3") {
      val node = generate(Seq(
        Seq(Color.Blue, Color.Blue),
        Seq(Color.Blue, Color.Red)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Blue, 3)
    }
    it("Blue 5") {
      val node = generate(Seq(
        Seq(Color.Yellow, Color.Yellow, Color.Blue, Color.Red),
        Seq(Color.Yellow, Color.Blue, Color.Red, Color.Blue),
        Seq(Color.Red, Color.Blue, Color.Blue, Color.Blue)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Blue, 5)
    }
    it("Blue 3 again") {
      val node = generate(Seq(
        Seq(Color.Blue, Color.Red, Color.Blue, Color.Blue),
        Seq(Color.Blue, Color.Blue, Color.Red, Color.Yellow),
        Seq(Color.Red, Color.Yellow, Color.Blue, Color.Red)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Blue, 3)
    }
    it("Large") {
      val node = generate(Seq(
        Seq(Color.Blue, Color.Blue, Color.Yellow, Color.Blue, Color.Blue, Color.Red, Color.Red, Color.Blue, Color.Red, Color.Blue),
        Seq(Color.Blue, Color.Red, Color.Red, Color.Red, Color.Yellow, Color.Red, Color.Red, Color.Red, Color.Yellow, Color.Blue),
        Seq(Color.Yellow, Color.Yellow, Color.Yellow, Color.Yellow, Color.Red, Color.Yellow, Color.Red, Color.Yellow, Color.Yellow, Color.Yellow),
        Seq(Color.Yellow, Color.Yellow, Color.Yellow, Color.Blue, Color.Yellow, Color.Blue, Color.Blue, Color.Blue, Color.Red, Color.Yellow),
        Seq(Color.Blue, Color.Blue, Color.Blue, Color.Red, Color.Yellow, Color.Red, Color.Blue, Color.Red, Color.Yellow, Color.Red),
        Seq(Color.Red, Color.Blue, Color.Blue, Color.Red, Color.Red, Color.Blue, Color.Blue, Color.Red, Color.Yellow, Color.Red),
        Seq(Color.Red, Color.Yellow, Color.Blue, Color.Red, Color.Blue, Color.Red, Color.Yellow, Color.Blue, Color.Blue, Color.Blue),
        Seq(Color.Blue, Color.Yellow, Color.Red, Color.Red, Color.Red, Color.Red, Color.Blue, Color.Blue, Color.Red, Color.Red),
        Seq(Color.Red, Color.Red, Color.Yellow, Color.Blue, Color.Yellow, Color.Yellow, Color.Blue, Color.Red, Color.Red, Color.Yellow),
        Seq(Color.Red, Color.Blue, Color.Blue, Color.Blue, Color.Blue, Color.Blue, Color.Red, Color.Blue, Color.Blue, Color.Yellow),
        Seq(Color.Blue, Color.Red, Color.Blue, Color.Blue, Color.Red, Color.Blue, Color.Blue, Color.Blue, Color.Red, Color.Red),
        Seq(Color.Blue, Color.Red, Color.Blue, Color.Blue, Color.Yellow, Color.Blue, Color.Blue, Color.Blue, Color.Yellow, Color.Red)
      ))

      val maxColor = new MaxAdjacentColor()
      maxColor.max(node) shouldBe MaxColor(Color.Blue, 18)
    }
  }

  private def generate(nodes: Seq[Seq[Color]]): Node[ColorCell] = {

    var rightNode: Option[Node[ColorCell]] = None
    val queue = mutable.Queue[Option[Node[ColorCell]]]()

    for (i <- nodes.size - 1 to 0 by -1) {
      rightNode = None
      for (j <- nodes(i).size - 1 to 0 by -1) {
        val downNode = if (i == nodes.size - 1) None else queue.dequeue()
        val node = Node(ColorCell(nodes(i)(j)), downNode, rightNode)
        rightNode = Some(node)
        if (i != 0) queue.enqueue(rightNode)
      }
    }
    rightNode.get
  }
}
