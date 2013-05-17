package week7

object lazyEvaluation03 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(616); 
/*
--------------------------
Lazy Evaluation
  if tail is called several times, it could potentially be re-evaluated
  and be costly.
  
  If we store the result of the first evaluation and re-use that later,
  we can avoid this problem.
  
  This is 'lazy evaluation'.
*/
/*
--------------------------
  Haskell always uses lazy evaluation.
  Scala uses strict by default, but allows lazy with 'lazy val' form:

    lazy val x = expr
    
    Consider following program:
*/
  def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
  };System.out.println("""expr: => Int""");$skip(10); val res$0 = 
  
  expr;System.out.println("""res0: Int = """ + $show(res$0))}
/*
  This has the side effect of printing:       x  (evaluated when you declare 'expr')
                                              z
                                              y
                                              (does not print x again, because x as a val is already evaluated)
                                              z
                                              (does not print y again, because y was already lazily-evaluated)
--------------------------
Lazy Vals and Streams

  def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
    def head = hd
    lazy val tail = tl
    ...
  }
*/
}
