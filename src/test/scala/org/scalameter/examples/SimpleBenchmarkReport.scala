package org.scalameter.examples

import org.scalameter.api._



class SimpleBenchmarkReport extends Bench.OfflineRegressionReport{
  override def reporter: Reporter[Double] = Reporter.Composite(
    new RegressionReporter(
        RegressionReporter.Tester.OverlapIntervals(),
        RegressionReporter.Historian.ExponentialBackoff() ),
    HtmlReporter(true)
    )
  
  val sizes = Gen.range("size")(300000, 1500000, 600000)

  val ranges = for {
    size <- sizes
  } yield 0 until size

  performance of "Range" in {
    measure method "map" in {
      using(ranges) in {
        r => r.map(_ + 1)
      }
    }
    measure method "map2" in {
      using(ranges) in {
        r => r.map(_ * 1 + 2)
      }
    }
  }
}
