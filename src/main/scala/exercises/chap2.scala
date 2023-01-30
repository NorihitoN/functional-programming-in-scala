package exercises

object MyModule {
  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = 
      if (n <= 0) acc
      else go(n-1, n*acc)
    
    go(n, 1)
  }

  // exercise 2.1 fibonacci
  def fibonacci(n: Int): Int = {
    def go(n: Int): Int = 
      if (n == 0) 0
      else if (n == 1) 1
      else go(n-1) + go(n-2)
    go(n)
  }

  // exercise 2.1 fibonacci - another solution
  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int =
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)
    loop(n, 0, 1)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(x, factorial(x))
  }

  private def formatFib(x: Int) = {
    val msg = "The fibonacci of %d is %d"
    msg.format(x, fibonacci(x))
  }

  private def formatFib2(x: Int) = {
    val msg = "The fibonacci of %d is %d"
    msg.format(x, fib(x))
  }

  // List 2.4
  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  // List 2.6
  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n+1)
    loop(0)
  }

  // Exercise 2.2 - check array is sorted
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean = 
      if (n >= as.length-1) true
      else if (ordered(as(n), as(n+1))) false
      else go(n+1)
    go(0)
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-40))
    println(formatFactorial(6))
    println(formatFib(7))
    println(formatFib2(7))

    println(formatResult("abs", -40, abs))
    println(formatResult("factorial", 6, factorial))
    println(formatResult("fibonacci", 7, fib))
  }
}
