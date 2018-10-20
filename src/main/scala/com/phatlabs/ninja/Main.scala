package com.phatlabs.ninja

import com.phatlabs.ninja.controller.NotesController
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

object FinatraDemoApp extends FinatraDemoServer

class FinatraDemoServer extends HttpServer {

  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add(new NotesController)
  }

}
