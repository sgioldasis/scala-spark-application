name := "spark-scala-application"
version := "0.0.0-SNAPSHOT"
organization := "savas.etl"

scalaVersion := "2.12.10"
val sparkVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
  "org.apache.spark" %% "spark-sql"  % sparkVersion % Provided,
  "org.apache.spark" %% "spark-hive" % sparkVersion % Provided,
  "com.github.scopt" %% "scopt"      % "3.5.0"      % Compile,
  "org.scalactic"    %% "scalactic"  % "3.2.0"      % "test, it",
  "org.scalatest"    %% "scalatest"  % "3.2.0"      % "test, it"
)

//libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0" % "test, it"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test, it"

// test run settings
//parallelExecution in Test := false
assembly / test := {}

// Enable integration tests
Defaults.itSettings
lazy val root = project.in(file(".")).configs(IntegrationTest)

// Measure time for each test
Test / testOptions += Tests.Argument("-oD")
IntegrationTest / testOptions += Tests.Argument("-oD")

// Scoverage settings
coverageExcludedPackages := "<empty>;.*storage.*"
coverageMinimum := 70
coverageFailOnMinimum := true

// Scalastyle settings
scalastyleFailOnWarning := false
scalastyleFailOnError := true

// Publish settings
//publishTo := Some("Sonatype Snapshots Nexus" at "https://oss.sonatype.org/content/repositories/snapshots")
//publishTo := {
//  val nexus = "https://my.artifact.repo.net/"
//  if (isSnapshot.value)
//    Some("snapshots" at nexus + "content/repositories/snapshots")
//  else
//    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
//}
//credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
