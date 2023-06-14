/**
 * 2. Add Two Numbers
 *
 * Difficulty: Medium
 *
 *  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
fun main() {

//    val l1 = ListNode(2, ListNode(4, ListNode(3)))
//    val l2 = ListNode(5, ListNode(6, ListNode(4)))

    val l1 = ListNode(9)
    val l2 = ListNode(
        1,
        ListNode(
            9,
            ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9))))))))
        )
    )

    val solution = AddTwoNumbersLinkedListRecursion()
//    val solution = AddTwoNumbersLinkedListLoop()

    println("----> Sum is")
    println(solution.addTwoNumbers(l1, l2))
}

data class ListNode(
    var value: Int,
    var next: ListNode? = null
)

class AddTwoNumbersLinkedListRecursion {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val numStr1 = sum(l1, "")
        val numStr2 = sum(l2, "")

        val sum = numStr1.toBigInteger() + numStr2.toBigInteger()
        val sumStr = sum.toString()


        var root: ListNode? = null

        sumStr.forEach{ char ->
            val nextItem = root
            root = ListNode(char.toString().toInt())
            root?.next = nextItem
        }
        return root
    }

    fun sum(li: ListNode?, numStr: String): String{
        val newStr = "${li!!.value}$numStr"
        if(li.next == null){
            return newStr
        }
        return sum(li.next, newStr)
    }
}

class AddTwoNumbersLinkedListLoop {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var numStr1 = ""
        var numStr2 = ""
        var currentItem1 = l1
        while (currentItem1?.value != null) {
            numStr1 = "${currentItem1.value}$numStr1"
            currentItem1 = currentItem1.next
        }

        var currentItem2 = l2
        while (currentItem2?.value != null) {
            numStr2 = "${currentItem2.value}$numStr2"
            currentItem2 = currentItem2.next
        }

        val sum = numStr1.toBigInteger() + numStr2.toBigInteger()
        val sumStr = sum.toString()

        var root: ListNode? = null

        sumStr.forEach { char ->
            val nextItem = root
            root = ListNode(char.toString().toInt())
            root?.next = nextItem
        }
        return root
    }
}