package view

import java.io.File
import javax.swing.JFrame
import model.Loader
import javax.swing.JPanel
import java.awt.BorderLayout
import javax.swing.JScrollPane
import java.awt.Dimension

class Viewer extends JFrame {
  
  private var loadedData: List[Array[String]] = null
  
  /*
   * Start GUI Creation
   */
  setSize(800, 600)
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  private val contentPane = new JPanel()
  contentPane.setLayout(new BorderLayout())
  val toolbar = new Toolbar(this)
  contentPane.add(toolbar, BorderLayout.NORTH)
  
  add(contentPane)
  setVisible(true)
  /*
   * End GUI Creation
   */
  
  def loadFile(file: File): Unit = {
    loadedData = Loader.openFile(file)
    
    contentPane.removeAll()
    contentPane.add(toolbar, BorderLayout.NORTH)
    
    val table = new TableView(loadedData)
    val scrollPane = new JScrollPane(table)
    scrollPane.setPreferredSize(new Dimension(600, 500))
    contentPane.add(scrollPane, BorderLayout.CENTER)
    revalidate()
    repaint()
  }
}