case class Fraction(n: Int, d: Int) {

  val numer = if (d < 0) -1 * n else n
  val denom = d.abs

  override def toString = numer + " / " + denom
}