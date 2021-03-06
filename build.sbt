sbtPlugin := true

name := "sbt-dirty-money"

organization := "com.eed3si9n"

version := "0.1.0"

sbtVersion in Global := "0.13.0-RC5" 

scalaVersion in Global := "2.10.2" 

description := "sbt plugin for cleaning Ivy2 cache"

licenses := Seq("MIT License" -> url("https://github.com/sbt/sbt-dirty-money/blob/master/LICENSE"))

scalacOptions := Seq("-deprecation", "-unchecked")

publishArtifact in (Compile, packageBin) := true

publishArtifact in (Test, packageBin) := false

publishArtifact in (Compile, packageDoc) := false

publishArtifact in (Compile, packageSrc) := false

publishMavenStyle := false

publishTo <<= (version) { version: String =>
   val scalasbt = "http://scalasbt.artifactoryonline.com/scalasbt/"
   val (name, u) = if (version.contains("-SNAPSHOT")) ("sbt-plugin-snapshots", scalasbt+"sbt-plugin-snapshots")
                   else ("sbt-plugin-releases", scalasbt+"sbt-plugin-releases")
   Some(Resolver.url(name, url(u))(Resolver.ivyStylePatterns))
}

credentials += Credentials(Path.userHome / ".ivy2" / ".sbtcredentials")

// seq(ScriptedPlugin.scriptedSettings: _*)
