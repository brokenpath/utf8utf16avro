lazy val benchtest = Project(
  "benchtest",
  file("."),
  settings = Defaults.coreDefaultSettings ++ Seq(
    name := "scalameter-examples",
    organization := "com.storm-enroute",
    scalaVersion := "2.12.10",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint"),
    publishArtifact := false,
    libraryDependencies ++= Seq(
      "com.storm-enroute" %% "scalameter" % version.value % "test" // ScalaMeter version is set in version.sbt
    ),
    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
    ),
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    parallelExecution in Test := false,
    logBuffered := false
  )
)