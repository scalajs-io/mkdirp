package io.scalajs.npm

import io.scalajs.RawOptions
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * mkdirp package object
  * @author lawrence.daniels@gmail.com
  */
package object mkdirp {

  type MkdirpCallback = js.Function2[MkdirpError, String, Any]

  /**
    * Mkdirp Enrichment
    * @param m the given [[Mkdirp instance]]
    */
  implicit class MkdirpEnrichment(val m: Mkdirp) extends AnyVal {

    @inline
    def async(path: String, options: MkdirpOptions | RawOptions = null): Promise[String] = {
      promiseWithError1[MkdirpError, String](m(path, options, _))
    }

  }

}
