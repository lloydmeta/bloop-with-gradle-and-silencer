rootProject.name = "bloop-on-gradle-with-silencer"

buildscript {

    repositories {
        // Add here whatever repositories you're already using
        mavenCentral()
        maven("https://repo.gradle.org/gradle/libs-releases-local/")
    }

    dependencies {
        classpath("ch.epfl.scala:gradle-bloop_2.12:1.4.1")
    }


}