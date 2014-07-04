import java.awt._
import javax.swing._

object Main {
  def main(args: Array[String]) {
    SwingUtilities.invokeLater(new Runnable {
      def run() {
        val Viewer = new Viewer()
      }
    })
  }
}