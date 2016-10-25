import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks
import org.scalacheck.Shapeless._
import org.scalacheck.Arbitrary._

@RunWith(classOf[JUnitRunner])
class FractionSpec extends FlatSpec with Matchers with PropertyChecks {

  "A fraction" should "have positive denom (with a label)" in {
    val fractions = arbitrary[Fraction].filter(f => f.denom != 0 && f.denom > Int.MinValue)

    forAll(fractions :| "any valid fraction") {
      _.denom should be > 0
    }
  }

  it should "have positive denom (expressed differnently)" in {
    forAll { f: Fraction =>
      whenever(f.denom != 0 && f.denom > Int.MinValue) {
        f.denom should be > 0
      }
    }
  }
}