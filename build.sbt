ThisBuild / scalaVersion := "2.13.10"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "Exercises",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % Test,
  )

