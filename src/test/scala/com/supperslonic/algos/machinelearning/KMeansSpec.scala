package com.supperslonic.algos.machinelearning

import org.scalatest.{FunSpec, Matchers}

import scala.util.Random

class KMeansSpec extends FunSpec with Matchers {
  describe("K Means") {
    it("3 cluster of points") {

      val cluster1 = List(
        Data(Point(1, 2)),
        Data(Point(2.5, 1.5)),
        Data(Point(2, 2.8)),
        Data(Point(3, 3)))

      val cluster2 = List(
        Data(Point(2, 4)),
        Data(Point(2.5, 4.5)),
        Data(Point(2.5, 5.5)),
        Data(Point(2, 5)))

      val cluster3 = List(
        Data(Point(5, 3.5)),
        Data(Point(4.5, 5)),
        Data(Point(5.5, 4)),
        Data(Point(4, 4)))

      val data = Random.shuffle(cluster1 ::: cluster2 ::: cluster3)

      val kMeans = new KMeans()
      val result = kMeans.findClusters(3, data, 10)

      val clusters = result.groupBy(item => item.clusterIndex)
      clusters.keys.size shouldBe 3
      println(clusters)

      clusters.values.foreach(cluster => {

        val expectedCluster = if(cluster1.contains(cluster.head)) cluster1
        else if(cluster2.contains(cluster.head)) cluster2 else cluster3
        cluster.size shouldBe expectedCluster.size
        expectedCluster.foreach(expected => cluster.contains(expected) shouldBe true)
      })
    }
  }
}
