package view

import javax.swing.JPanel
import javax.swing.JFrame
import java.awt.BorderLayout

class HistogramView(data: List[Double]) extends JFrame {
  if (data.length != 0) {
    /*
     * Start GUI Creation
     */
    setTitle("Histogram View")
    setSize(500, 500)
    setLayout(new BorderLayout())
    val stat = new StatView(data)
    add(stat, BorderLayout.EAST)
    val info = stat.getInfo()
    
    setVisible(true)
    /*
     * End GUI Creation
     */
  }
}