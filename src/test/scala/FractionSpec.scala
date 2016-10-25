import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class FractionSpec extends FlatSpec with Matchers with PropertyChecks {

  "A fractoin" should "work" in {
    forAll { (n: Int, d: Int) =>
      whenever(d != 0 && d != Integer.MIN_VALUE && n != Integer.MIN_VALUE) {
        val f = new Fraction(n, d)

        if (n < 0 && d < 0 || n > 0 && d > 0)
          f.numer should be > 0
        else if (n != 0)
          f.numer should be < 0
        else
          f.numer should be(0)

        f.denom should be > 0
      }
    }
  }
}