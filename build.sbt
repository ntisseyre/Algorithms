import sbt._
import Keys._

version := "1.0"
scalaVersion := Dependencies.scalaVersion
logLevel := Level.Warn

lazy val root = AlgorithmsProject(".",
  name = "algorithms",
  description = "root",
  projectDependencies = Seq(),
  libraryDependencies = Dependencies.algorithmsDependencies)
  .aggregate()