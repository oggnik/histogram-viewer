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

object Toolbar {
  val READY = 0
  val OPENING = 1
}

class Toolbar extends Panel with ActionListener {
  val chooser = new JFileChooser()
  var status = Toolbar.READY
  
  val load = new JButton("Load")
  val statusLabel = new JLabel("Ready")
  setStatus(Toolbar.READY)
  
  load.addActionListener(this)
  
  setLayout(new FlowLayout(FlowLayout.LEFT))
  add(load)
  add(statusLabel)
  
  def actionPerformed(e: ActionEvent): Unit = {
    if (status == Toolbar.READY) {
      setStatus(Toolbar.OPENING)
      val returnValue = chooser.showOpenDialog(this)
      if (returnValue == JFileChooser.APPROVE_OPTION) {
        println("Opening")
        val file = chooser.getSelectedFile()
        val model = Loader.openFile(file)
      }
    }
    setStatus(Toolbar.READY)
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