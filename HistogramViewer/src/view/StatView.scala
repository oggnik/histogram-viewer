package view

import javax.swing.JPanel
import javax.swing.JLabel
import java.awt.FlowLayout
import java.awt.GridLayout

class StatView(data: List[String]) extends JPanel {
  val max = data.maxBy(num => num.toInt).toInt
  /*
   * Start GUI Creation
   */
  setLayout(new GridLayout(0, 1, 10, 5))
  val maxLabel = new JLabel("Max: " + max)
  
  add(maxLabel)
  /*
   * End GUI Creation
   */
}