import sbt._
import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._

object build extends Build {

  val appVersion = "0.1.0"
  val scalatraVersion = "$scalatraVersion$"

  lazy val project = Project (
    "$name;format="norm"$",
    file("."),
    settings = ScalatraPlugin.scalatraWithJRebel ++ Seq(

      organization := "$organizationPackage$",
      name := "$name$",
      version := appVersion,

      scalaVersion := "$scalaVersion$",
      scalacOptions ++= Seq("-deprecation", "-feature", "-language:implicitConversions"),

      scalaSource       in Compile <<= (baseDirectory in Compile)(_ / "src"),
      resourceDirectory in Compile <<= (baseDirectory in Compile)(_ / "resources"),
      webappResources   in Compile := Seq(baseDirectory.value / "doc-root"),

      scalaSource       in Test <<= (baseDirectory in Test)(_ / "test"),
      resourceDirectory in Test <<= (baseDirectory in Test)(_ / "resources"),

      resolvers += Classpaths.typesafeReleases,
      //resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
      libraryDependencies ++= Seq(

        // Base webapp stack
        "org.scalatra" %% "scalatra" % scalatraVersion,
        "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % "9.1.5.v20140505" % "container",
        "org.eclipse.jetty" % "jetty-plus" % "9.1.5.v20140505" % "container",
        "javax.servlet" % "javax.servlet-api" % "3.1.0",

        // Database-related
        "postgresql" % "postgresql" % "9.1-901.jdbc4",
        "com.typesafe.slick" %% "slick" % "2.1.0",
        "com.zaxxer" % "HikariCP-java6" % "2.3.8",

        // Support for email, JSON, and password hashing, respectively
        "javax.mail" % "mail" % "1.4.7",
        "com.propensive" %% "rapture-json" % "1.0.6",
        // TODO: Use jbcrypt version 0.4 when it becomes available in the Maven repo.
        "org.mindrot" % "jbcrypt" % "0.3m",

        // Specific to testing
        "org.scalatra" %% "scalatra-scalatest" % scalatraVersion % "test"
      )
    )
  )
}
