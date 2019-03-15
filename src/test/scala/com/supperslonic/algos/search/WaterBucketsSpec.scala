package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class WaterBucketsSpec extends FunSpec with Matchers {
  describe("Can pour water") {
    it("Already final state") {

      val buckets = Seq(Bucket(10, 10), Bucket(10, 3), Bucket(5, 3), Bucket(4, 1))
      val finalState = Seq(1, 3, 3)

      val algorithm = new WaterBuckets()
      val result = algorithm.canPour(buckets, finalState)

      result shouldBe true
    }
    it("4, 4") {

      val buckets = Seq(Bucket(10, 10), Bucket(10, 10), Bucket(5), Bucket(4))
      val finalState = Seq(4, 4)

      val algorithm = new WaterBuckets()
      val result = algorithm.canPour(buckets, finalState)

      result shouldBe true
    }

    it("5, 1") {

      val buckets = Seq(Bucket(10, 10), Bucket(10, 10), Bucket(5), Bucket(4))
      val finalState = Seq(5, 1, 3)

      val algorithm = new WaterBuckets()
      val result = algorithm.canPour(buckets, finalState)

      result shouldBe false
    }
  }
}