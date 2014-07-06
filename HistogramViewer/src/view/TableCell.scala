package view

import javax.swing.JPanel
import javax.swing.JLabel
import java.awt.Dimension
import java.awt.Color
import javax.swing.BorderFactory

class TableCell(contents: String) extends JPanel {
  /*
   * Start GUI Creation
   */
  val label = new JLabel(contents)
  label.setForeground(Color.BLACK)
  setBorder(BorderFactory.createLineBorder(Color.black))
  add(label)
  /*
   * End GUI Creation
   */
}