package example
import org.scalatest.funsuite.AnyFunSuite

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class HelloTest extends AnyFunSuite {
  test("main method should print the expected message") {
    val expected = "hello\n"
    val stream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(stream)) {
      Hello.main(Array.empty)
    }
    val result = stream.toString
    assert(result == expected)
  }
}
