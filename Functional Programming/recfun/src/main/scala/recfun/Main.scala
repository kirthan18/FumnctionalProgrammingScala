package recfun

import scala.collection.mutable

object Main {
  def main(args: Array[String]) {
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(pascal(col, row) + " ")
//      println()
//    }
    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
    println(balance(":-)".toList))
    println(balance("())(".toList))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = ???
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      val stack = mutable.Stack[Char]()

      for (c <- chars) {
        if (c == '(') stack.push('(')
        else if (c == ')') {
          if (stack.isEmpty) return false
          else if (stack.top == '(') stack.pop()
        }
      }
      stack.isEmpty
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
