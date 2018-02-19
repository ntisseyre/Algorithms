import sbt._

object AlgorithmsProject {

  def apply(path: String,
            name: String,
            description: String,
            projectDependencies: Seq[ClasspathDep[ProjectReference]],
            libraryDependencies: Seq[ModuleID]): Project = Project(id = name, base = file(path))
    .settings(Seq(
      Keys.fork in Test := true,
      Keys.name := name,
      Keys.description := description,
      Keys.resolvers ++=  Seq(Resolver.mavenLocal, {
        Credentials(Path.userHome / ".ivy2" / ".credentials")
        Resolver.url("grubhub-repo", url("https://artifactory.grubhub.com/artifactory"))(Resolver.ivyStylePatterns)
      }),
      Keys.libraryDependencies ++= Dependencies.commonDependencies ++ libraryDependencies) ++
      projectSettings)
    .dependsOn(projectDependencies:_*)

  private lazy val projectSettings = commonSettings ++ buildSettings

  private lazy val commonSettings = Seq(
    Keys.organization := "supperslonic",
    Keys.organizationName := "SupperSlonic")

  private lazy val buildSettings = Seq(
    Keys.scalaVersion := Dependencies.scalaVersion
  )
}