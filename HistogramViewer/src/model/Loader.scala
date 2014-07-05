package model

import java.io.File
import java.util.Scanner
import scala.collection.mutable.ListBuffer

object Loader {
  def openFile(file: File): List[Array[String]] = {
    println("Loading file")
    val scanner = new Scanner(file)
    var lines = new ListBuffer[String]
    while (scanner.hasNextLine()) {
      lines += scanner.nextLine()
    }
    lines.map(line => line.split(',')).toList
  }
}