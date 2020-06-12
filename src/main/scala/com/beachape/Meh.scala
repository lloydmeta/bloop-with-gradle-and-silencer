package com.beachape

object Meh {
  def speak: String = "meh"

  @deprecated("meh", "since forever")
  def oldSpeak: String = "meeeeeh"
}