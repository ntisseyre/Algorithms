import sbt._

object Dependencies {

  val scalaVersion = "2.13.10"

  private val scalaTestV = "3.1.2"

  //TEST
  private val testScalaLib = "org.scalatest" %% "scalatest" % scalaTestV  % "test"

  val commonDependencies = Seq()
  val algorithmsDependencies = Seq(testScalaLib)
}
