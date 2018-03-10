package com.supperslonic.algos.machinelearning

import scala.util.Random

case class Point(x: Double, y: Double)
case class Data(point: Point, var clusterIndex: Int = 0){
  override def equals(obj: scala.Any): Boolean = point.eq(obj.asInstanceOf[Data].point)
}

class KMeans {
  def findClusters(k: Int, data: Seq[Data], maxIterations: Int): Seq[Data] = {
    require(data.size >= k)
    val means = initializeMeans(k, data)
    val clusterSize = Array.ofDim[Int](k)

    var iteration = 0
    var hasUpdate = true
    while (hasUpdate && iteration < maxIterations) {

      hasUpdate = false
      data.foreach(item => {
        val clusterIndex = detectCluster(item, means)
        clusterSize(clusterIndex) += 1
        updateMean(clusterSize(clusterIndex), item, clusterIndex, means)

        if(item.clusterIndex != clusterIndex) {
          item.clusterIndex  = clusterIndex
          hasUpdate = true
        }
      })

      iteration += 1
    }

    data
  }

  private def initializeMeans(k: Int, data: Seq[Data]): Array[Data] = {
    Random.shuffle(data).take(k).toArray
  }

  private def updateMean(size: Int, item: Data, index: Int, means: Array[Data]): Unit = {

    val meanPoint = means(index).point
    means(index) = Data(Point(
      (meanPoint.x * size + item.point.x) / (size + 1),
      (meanPoint.y * size + item.point.y) / (size + 1)))
  }

  private def detectCluster(item: Data, means: Seq[Data]): Int = {
    var min = Double.MaxValue
    var index = 0
    for (i <- means.indices) {
      val distance = euclideanDistance(item.point, means(i).point)
      if (distance < min) {
        min = distance
        index = i
      }
    }
    index
  }

  private def euclideanDistance(point1: Point, point2: Point) =
    Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2))
}
