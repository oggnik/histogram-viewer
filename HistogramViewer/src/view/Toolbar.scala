package view

import javax.swing.JLabel
import javax.swing.JButton
import java.awt.Panel
import java.awt.event.ActionEvent
import java.awt.FlowLayout
import java.awt.Color
import java.awt.event.ActionListener
import javax.swing.JFileChooser
import model.Loader
import javax.swing.JOptionPane

object Toolbar {
  val READY = 0
  val OPENING = 1
}

class Toolbar(viewer: Viewer) extends Panel with ActionListener {
  val chooser = new JFileChooser()
  var status = Toolbar.READY

  /*
   * Start Gui Creation
   */
  val load = new JButton("Load")
  val chooseCol = new JButton("Choose Column")
  val statusLabel = new JLabel("Ready")
  setStatus(Toolbar.READY)

  load.addActionListener(this)
  chooseCol.addActionListener(this)

  setLayout(new FlowLayout(FlowLayout.LEFT))
  add(load)
  add(chooseCol)
  add(statusLabel)
  /*
   * End Gui Creation
   */

  def actionPerformed(e: ActionEvent): Unit = {
    if (e.getSource() == load) {
      if (status == Toolbar.READY) {
        setStatus(Toolbar.OPENING)
        val returnValue = chooser.showOpenDialog(this)
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          println("Opening")
          val file = chooser.getSelectedFile()
          viewer.loadFile(file)
        }
        setStatus(Toolbar.READY)
      }
    } else if (e.getSource() == chooseCol) {
      if (status == Toolbar.READY) {
        val column = JOptionPane.showInputDialog(viewer, "Enter Column").toInt - 1
        viewer.chooseColumn(column)
        setStatus(Toolbar.READY)
      }
    }
    
  }

  def setStatus(s: Integer): Unit = {
    status = s
    if (status == Toolbar.READY) {
      statusLabel.setText("Ready")
      statusLabel.setForeground(Color.GREEN.darker())
    } else if (status == Toolbar.OPENING) {
      statusLabel.setText("Opening")
      statusLabel.setForeground(Color.BLUE.darker())
    }
  }
}