name := "finatra-demo"

version := "0.1"

scalaVersion := "2.12.7"

lazy val versions = new {
  val finatra = "2.1.2"
  val logback = "1.1.3"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)

libraryDependencies += "com.twitter" %% "finatra-http" % "18.9.1"
libraryDependencies += "ch.qos.logback" % "logback-classic" % versions.logback
// https://mvnrepository.com/artifact/io.netty/netty-all
libraryDependencies += "io.netty" % "netty-all" % "4.1.30.Final"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.3"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"