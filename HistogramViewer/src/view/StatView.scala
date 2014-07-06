package view

import java.awt.GridLayout

import javax.swing.JLabel
import javax.swing.JPanel

class StatView(data: List[Double]) extends JPanel {
  if (data.length != 0) {
    val amount = data.length
    val max = data.max
    val min = data.min
    val average = (data.sum) / data.length
    /*
     * Start GUI Creation
     */
    setLayout(new GridLayout(0, 1, 10, 5))
    val amountLabel = new JLabel("Amount: " + amount)
    val maxLabel = new JLabel("Max: " + max)
    val minLabel = new JLabel("Min: " + min)
    val avgLabel = new JLabel("Average: " + average)

    add(amountLabel)
    add(maxLabel)
    add(minLabel)
    add(avgLabel)
    /*
     * End GUI Creation
     */
  }
}