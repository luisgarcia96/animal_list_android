package com.animals.safety.utils

fun String.capitalize(input: String?): String {
  val sb = StringBuilder(input)
  sb.setCharAt(0, sb[0].uppercaseChar())
  return sb.toString()
}
