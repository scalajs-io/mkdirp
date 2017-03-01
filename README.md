Mkdirp API for Scala.js
================================
[mkdirp](https://www.npmjs.com/package/mkdirp) - Recursively mkdir, like mkdir -p

### Description

Like mkdir -p, but in node.js!

### Build Dependencies

* [SBT v0.13.13](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

Using `Mkdirp` asynchronously via callbacks

```scala
import io.scalajs.npm.mkdirp._

Mkdirp("/tmp/foo/bar/baz", { (err, result) =>
  println(if(err == null) s"Created: $result" else "Doh!")
})
```

Using `Mkdirp` asynchronously via promises

```scala
import io.scalajs.npm.mkdirp._
import scala.util.{Success, Failure}

Mkdirp.async("/tmp/foo/bar/baz").future onComplete {
    case Success(result) => println(s"Created: $result")
    case Failure(e) =>
      println(s"Failed: ${Option(e).map(_.getMessage).orNull}")
}
```

Using `Mkdirp` synchronously 

```scala
import io.scalajs.npm.mkdirp._
import scala.util.{Success, Failure}

val result = Mkdirp.sync("/tmp/foo/bar/baz")
println(s"Created: $result")
```

### Artifacts and Resolvers

To add the `Mkdirp` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "mkdirp" % "0.5.1-2"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```