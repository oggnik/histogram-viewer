package view

import java.io.File
import javax.swing.JFrame
import model.Loader
import javax.swing.JPanel
import java.awt.BorderLayout
import javax.swing.JScrollPane
import java.awt.Dimension
import HistogramView.HistogramView

class Viewer extends JFrame {
  
  private var loadedData: List[Array[String]] = null
  private var table: TableView = null
  
  /*
   * Start GUI Creation
   */
  setTitle("Table View")
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
    
    table = new TableView(loadedData)
    val tableScrollPane = new JScrollPane(table)
    tableScrollPane.setPreferredSize(new Dimension(600, 500))
    contentPane.add(tableScrollPane, BorderLayout.CENTER)
    revalidate()
    repaint()
  }
  
  def chooseColumn(column: Integer): Unit = {
    println("Choosing Column: " + column)
    
    val columnData = loadedData.map(line => line(column))
    val doubleData = columnData.filter(value => try { Some(value.toDouble); true } catch { case _ => false }).map(value => value.toDouble)
    val histogramPanel = new HistogramView(doubleData)
  }
}