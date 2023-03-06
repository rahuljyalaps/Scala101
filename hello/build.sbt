name := "Scala Learning"
scalaVersion     := "2.12.11"
version          := "0.1.0-SNAPSHOT"
organization     := "com.example"
organizationName := "example"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % Test

assembly / mainClass := Some("example.Hello")
