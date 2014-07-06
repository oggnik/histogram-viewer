package view

import javax.swing.JPanel
import javax.swing.JFrame

class HistogramView(data: List[Double]) extends JFrame {
  if (data.length != 0) {
    /*
     * Start GUI Creation
     */
    setTitle("Histogram View")
    setSize(500, 500)
    setVisible(true)
    /*
     * End GUI Creation
     */
  }
}