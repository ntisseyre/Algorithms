import sbt._

object Dependencies {

  val scalaVersion = "2.12.4"

  private val scalaTestV = "3.0.1"

  //TEST
  private val testScalaLib = "org.scalatest" %% "scalatest" % scalaTestV  % "test"

  val commonDependencies = Seq()
  val algorithmsDependencies = Seq(testScalaLib)
}
