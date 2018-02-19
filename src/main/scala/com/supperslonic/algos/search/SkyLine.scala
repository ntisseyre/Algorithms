package com.supperslonic.algos.search

import com.supperslonic.algos.heaps.MaxHeap

import scala.collection.mutable

case class Building(left: Int, right: Int, height: Int)
case class BuildingCoordinate(x: Int, isRight: Boolean, building: Building)extends Comparable[BuildingCoordinate]{
  override def compareTo(o: BuildingCoordinate): Int = building.height.compareTo(o.building.height)
}
case class SkyLineResult(x: Int, y: Int)

class SkyLine {

  def find(buildings: Seq[Building]): Seq[SkyLineResult] = {
    val maxHeap = new MaxHeap[BuildingCoordinate]()
    val result = mutable.ArrayBuffer[SkyLineResult]()

    buildings
      .flatMap(building =>
        Seq(BuildingCoordinate(building.left, isRight = false, building),
          BuildingCoordinate(building.right, isRight = true, building)))
      .sortBy(buildingCoordinate => buildingCoordinate.x)
      .foreach(buildingCoordinate => {

        println(buildingCoordinate)

        if (buildingCoordinate.isRight) {
          if(result.last.y == buildingCoordinate.building.height) {
            while (!maxHeap.isEmpty && maxHeap.getMax.building.right <= buildingCoordinate.x) maxHeap.pop()
            val height = if (maxHeap.isEmpty) 0 else maxHeap.getMax.building.height
            result.append(SkyLineResult(buildingCoordinate.x, height))
          }
        } else {
          maxHeap.insert(buildingCoordinate)
          if (result.isEmpty || result.last.y < buildingCoordinate.building.height) {
            result.append(SkyLineResult(buildingCoordinate.x, buildingCoordinate.building.height))
          }
        }
      })
    result
  }
}
