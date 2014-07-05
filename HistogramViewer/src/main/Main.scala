package main


import view.Viewer
import javax.swing.SwingUtilities

object Main {
  def main(args: Array[String]) {
    SwingUtilities.invokeLater(new Runnable {
      def run() {
        val Viewer = new Viewer()
      }
    })
  }
}