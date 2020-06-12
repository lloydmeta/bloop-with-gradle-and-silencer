package com.beachape

import com.github.ghik.silencer.silent

@silent
class ASpec extends ASpecLike {

  it("should w/e") {
    assert(true)
  }

  it("should not error out") {
    assert(Meh.oldSpeak == "meeeeeh")
  }

}
