package benchmarking


object  QuadArray{
   def infours(i: Int) : Array[Int] = 0.until(i*4).toArray


   def sum_intfours(a: Array[Int]) : Int = {
      var s = 0
      var i = 0
      val length = a.length
      while (i < length) {
         s += a(i) + a(i+1) + a(i+2) + a(i+3)
         i += 4
      }
      s
   }

   def sum_insfours(a: Array[Int]) : Int = {
   var s = 0
      var i = 0
      val length = a.length
      while (i < length) {
         s += a(i) 
         s += a(i+1) 
         s += a(i+2) 
         s += a(i+3)
         i += 4
      }
      s
   }


   def sum_inones(a: Array[Int]) : Int = {
   var s = 0
      var i = 0
      val length = a.length
      while (i < length) {
         s += a(i)
         i += 1 
      }
      s
   }


}