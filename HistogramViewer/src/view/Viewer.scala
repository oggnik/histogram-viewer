package view

import java.io.File

import javax.swing.JFrame
import model.Loader

class Viewer extends JFrame {
  
  private var loadedData: List[Array[String]] = null
  
  /*
   * Start GUI Creation
   */
  setSize(800, 600)
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  setVisible(true)
  val toolbar = new Toolbar(this)
  
  add(toolbar)
  /*
   * End GUI Creation
   */
  
  def loadFile(file: File): Unit = {
    loadedData = Loader.openFile(file)
    loadedData.foreach(line => println(line.mkString(", ")))
  }
}