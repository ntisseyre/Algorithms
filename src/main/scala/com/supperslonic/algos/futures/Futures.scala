package com.supperslonic.algos.futures

import java.util.concurrent.Executors

import com.supperslonic.algos.futures.Futures.FuturesResult

import scala.concurrent.{ExecutionContext, ExecutionContextExecutorService, Future}
import scala.util.{Failure, Success}

object Futures {
  type FuturesResult = String
}

class Futures {

  implicit val executionContext: ExecutionContextExecutorService = ExecutionContext.fromExecutorService(
    Executors.newFixedThreadPool(2)
  )

  def transform(throwException: Boolean): Future[FuturesResult] = {
    //val fInt = Future(getInt)
    //val fStr = Future(getString(42, throwException))

    val futuresResult = for {
      intResult <- Future(getInt)
      stringResult <- Future(getString(intResult/*42*/, throwException))
    } yield stringResult

    futuresResult.transform {
      case Success(value) =>
        println(s"Success: $value")
        Success(value)
      case Failure(exception) =>
        println(s"Failure: ${exception.getMessage}")
        Failure(exception)
    }
  }

  def sleep(): Future[String] = {
    for {
      _ <- Future({
        Thread.sleep(2000)
        println("Wake up!")
      })
      stringResult <- Future("stringResult")
    } yield stringResult
  }

  private def getInt: Int = {
    Thread.sleep(1000)
    println("Getting int")
    41 + 1
  }

  private def getString(value: Int, throwException: Boolean) = {
    println("Getting String")
    if (throwException) {
      throw new RuntimeException("Ooops!")
    } else {
      value.toString
    }
  }
}
