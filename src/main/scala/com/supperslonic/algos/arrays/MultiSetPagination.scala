package com.supperslonic.algos.arrays

trait Car {
  val licensePlate: String
}

case class Volkswagen(licensePlate: String) extends Car

case class Honda(licensePlate: String) extends Car

case class BMW(licensePlate: String) extends Car

case class Tesla(licensePlate: String) extends Car

/*


Application API:
--------------
getCars(offset: Int, limit: Int): List<Car>

Storage API:
------------
count(carMake: String): Int
getCars(offset: Int, limit: Int, carMake: String): List<Car>


Storage
--------
Volkswagen - 3
----------
VW-1
VW-2
VW-3

Honda - 5
----------
H-1
H-2
....
H-5

BMW - 7
----------
BMW-1
BMW-2
....
BMW-7

Tesla - 10
----------
T-1
T-2
....
T-10

3 8 15 25
offset = 5
count = 10

8 - 5 - 1 = 2 for Honda
5-2
 */

object Cars {
  val CarMakes = Seq("Volkswagen", "Honda", "BMW", "Tesla")
}

case class CarMakeChunk(offset: Int, limit: Int)

class MultiSetPagination(storage: CarStorage) {

  def getCars(offset: Int, limit: Int): Seq[(String, CarMakeChunk)] = {
    var carMakeCount = 0
    var leftLimit = limit
    var newOffset = offset

    val chunks = Cars.CarMakes.flatMap(carMake => {
      if (leftLimit == 0) {
        None
      } else {
        val count = storage.count(carMake)
        carMakeCount += count
        if (carMakeCount > newOffset) {
          val carMakeOffset = if (newOffset == 0) 0 else {
            newOffset = 0
            if (count == carMakeCount) offset else count - (carMakeCount - offset)
          }
          val carMakeLimit = Math.min(count - carMakeOffset, leftLimit)
          leftLimit -= carMakeLimit
          Some(carMake -> CarMakeChunk(carMakeOffset, carMakeLimit))
        } else {
          None
        }
      }
    })

    chunks
  }
}

trait CarStorage {
  def count(carMake: String): Int

  def getCars(offset: Int, limit: Int, carMake: String): Seq[Car]
}
