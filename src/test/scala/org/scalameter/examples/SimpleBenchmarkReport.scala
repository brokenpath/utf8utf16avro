package org.scalameter.examples

import org.scalameter.api._

import benchmarking.QuadArray


class SimpleBenchmarkReport extends Bench.OfflineRegressionReport{
  override def reporter: Reporter[Double] = Reporter.Composite(
    new RegressionReporter(
        RegressionReporter.Tester.OverlapIntervals(),
        RegressionReporter.Historian.ExponentialBackoff() ),
    HtmlReporter(true)
    )
  
  val sizes = Gen.range("size")(1024*32, 1024 * 128, 1024*32)
  val arrays : Gen[Array[Int]]= sizes.map(s => QuadArray.infours(s))


  performance of "Range" in {
    measure method "inones" in {
      using(arrays) in {
        a => QuadArray.sum_inones(a)
      }
    }
    measure method "insfours" in {
      using(arrays) in {
        a => QuadArray.sum_insfours(a)
      }
    }
    measure method "intfours" in {
      using(arrays) in {
        a => QuadArray.sum_intfours(a)
      }
    }
  }
}
