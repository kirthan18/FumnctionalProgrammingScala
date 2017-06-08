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
  def balanceNonRecursive(chars: List[Char]): Boolean = {
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

  def balance(chars: List[Char]): Boolean = {
    balance_(chars, 0)
  }

  def balance_(chars: List[Char], top: Int): Boolean = {
    if (chars.isEmpty) top == 0
    else {
      if (chars.head == '(') balance_(chars.tail, top + 1)
      else if (chars.head == ')') top > 0 && balance_(chars.tail, top - 1)
      else balance_(chars.tail, top)
    }
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    countChange_(money, coins, 0)
  }

  def countChange_(money: Int, coins: List[Int], index:Int): Int = {
    if (money < 0) 0
    else if (money == 0) 1
    else if (index == coins.size && money > 0) 0
    else countChange_(money, coins, index + 1) + countChange_(money - coins(index), coins, index)
  }
}
