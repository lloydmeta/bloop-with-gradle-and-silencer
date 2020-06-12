## Bloop with Gradle and Silencer

This is a minimal recreation of an issue I encountered with Bloop and Gradle with `scalaCompilerPlugins` for
setting scalac plugins

### The Gradle project works fine

```shell
❯ ./gradlew test

BUILD SUCCESSFUL in 6s
3 actionable tasks: 3 executed
```

### The `bloopInstall` task finishes

```shell script
❯ ./gradlew bloopInstall

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.5/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 501ms
2 actionable tasks: 2 executed
```

### bloop test fails due to unsilenced deprecation error

```shell
❯ bloop test bloop-on-gradle-with-silencer
Compiling bloop-on-gradle-with-silencer-test (1 Scala source)
[E] [E1] src/test/scala/com/beachape/ASpec.scala:13:11
[E]      method oldSpeak in object Meh is deprecated (since since forever): meh
[E]      L13:     assert(Meh.oldSpeak == "meeeeeh")
[E]                     ^
[W] src/test/scala/com/beachape/ASpec.scala: L13 [E1]
Compiled bloop-on-gradle-with-silencer-test (266ms)
[E] Failed to compile 'bloop-on-gradle-with-silencer-test'
```