plugins {
    scala
    bloop
}

val scalaVersion = "2.12.11"
val scalaVersionSuffix = scalaVersion.split('.').take(2).joinToString(".")

repositories {
    mavenCentral()
}

configurations.create("scalacPlugin")

dependencies {
    implementation("org.scala-lang:scala-library:$scalaVersion")

    implementation("com.github.ghik:silencer-lib_$scalaVersion:1.7.0")
    scalaCompilerPlugins( "com.github.ghik:silencer-plugin_$scalaVersion:1.7.0")
    testImplementation("org.scalatest:scalatest_$scalaVersionSuffix:3.1.2")
    testImplementation("org.scalatestplus:junit-4-12_$scalaVersionSuffix:3.1.2.0")

}



tasks.withType<ScalaCompile> {
    scalaCompileOptions.additionalParameters = listOf(
            "-feature",
            "-target:jvm-1.8",
            "-language:_",
            "-Xlint:infer-any",
            "-Xlint:unsound-match",
            "-Xlint:stars-align",
            "-Xlog-reflective-calls",
            "-Xlint:nullary-override",
            "-Xlint:option-implicit",
            "-Xlint:delayedinit-select",
            "-Xlint:package-object-classes",
            "-Xlint:by-name-right-associative",
            "-Ywarn-inaccessible",
            "-Xlint:private-shadow",
            "-Xlint:type-parameter-shadow",
            "-Ypartial-unification",
            "-Xfatal-warnings"
    )
}

tasks.register<Jar>("testJar") {
    archiveClassifier.set("tests")
    from(sourceSets.test.get().output)
}
configurations.create("tests") {
    extendsFrom(configurations.testRuntime.get())
}
artifacts {
    add("tests", tasks.named("testJar"))
}
