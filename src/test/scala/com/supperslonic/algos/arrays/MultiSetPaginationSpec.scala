package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

class MultiSetPaginationSpec extends FunSpec with Matchers {
  describe("Multi set pagination") {
    it("Starts with zero") {

      val cars = Map("Volkswagen" -> 3, "Honda" -> 5, "BMW" -> 7, "Tesla" -> 10)
      val storage = new TestCarStorage(cars)
      val multiSet = new MultiSetPagination(storage)

      multiSet.getCars(0, 1) shouldBe Seq("Volkswagen" -> CarMakeChunk(0, 1))
      multiSet.getCars(0, 3) shouldBe Seq("Volkswagen" -> CarMakeChunk(0, 3))
      multiSet.getCars(0, 5) shouldBe Seq("Volkswagen" -> CarMakeChunk(0, 3), "Honda" -> CarMakeChunk(0, 2))
      multiSet.getCars(2, 5) shouldBe Seq("Volkswagen" -> CarMakeChunk(2, 1), "Honda" -> CarMakeChunk(0, 4))
      multiSet.getCars(5, 7) shouldBe Seq("Honda" -> CarMakeChunk(2, 3), "BMW" -> CarMakeChunk(0, 4))
      multiSet.getCars(24, 1) shouldBe Seq("Tesla" -> CarMakeChunk(9, 1))
      multiSet.getCars(100, 1) shouldBe Seq.empty
    }
  }

  class TestCarStorage(cars: Map[String, Int]) extends CarStorage {
    override def count(carMake: String): Int = cars(carMake)

    override def getCars(offset: Int, limit: Int, carMake: String): Seq[Car] = ???
  }

}
