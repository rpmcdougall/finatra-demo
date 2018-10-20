package com.phatlabs.ninja.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class NotesController extends Controller {

  get("/notes") { request: Request =>

    "Test 123"

  }

}
