package view

import java.awt._
import javax.swing._

class Viewer extends JFrame {
  setSize(400, 400)
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  setVisible(true)
  val toolbar = new Toolbar()
  
  add(toolbar)
}