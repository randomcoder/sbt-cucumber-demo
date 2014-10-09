import templemore.sbt.cucumber.CucumberPlugin._

val commonSettings = Seq(
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.10.4",
  organization := "uk.co.randomcoding",
  scalacOptions in Compile := Seq("-unchecked", "-deprecation", "-feature"))

//val root = project.in(file("."))
//  .settings(commonSettings: _*)
//  .settings(name := "sbt-cucumber-demo")
//  .aggregate(cucumber)

val cucumber = project.in(file("cucumber"))
  .settings(commonSettings: _*)
  .settings(cucumberSettings: _*)
  .settings(
    name := "cucumber",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test",
    publishArtifact in Test := true)

val launcher = project.in(file("launcher"))
  .settings(commonSettings: _*)
  .settings(
    name := "cucumberdemo-launcher",
    libraryDependencies ++= Seq(
      "info.cukes" %% "cucumber-scala" % "1.2.0-SNAPSHOT",
      "org.scala-sbt" % "launcher-interface" % "0.13.5" % "provided"))
  .dependsOn(cucumber % "compile->test")

