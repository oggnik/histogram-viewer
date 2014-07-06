package view

import javax.swing.JPanel
import java.awt.GridLayout

class TableView(data: List[Array[String]]) extends JPanel {
  val dataWidth = data.maxBy(line => line.length).length
  val dataHeight = data.length
  
  /*
   * Start GUI Creation
   */
  val cells = Array.ofDim[TableCell](dataWidth, dataHeight)
  
  setLayout(new GridLayout(dataHeight, dataWidth))
  
  for (y <- 0 until dataHeight) {
    val line = data(y)
    for (x <- 0 until dataWidth) {
      val cellData = line(x)
      val tableCell = new TableCell(cellData)
      cells(x)(y) = tableCell
      add(tableCell)
    }
  }
  /*
   * End GUI Creation
   */
}