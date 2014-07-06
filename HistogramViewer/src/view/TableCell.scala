package view

import javax.swing.JPanel
import javax.swing.JLabel

class TableCell(contents: String) extends JPanel {
  /*
   * Start GUI Creation
   */
  val label = new JLabel(contents)
  add(label)
  /*
   * End GUI Creation
   */
}