
/**
 * 1. Two Sum
 *
 * Difficulty: Easy
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

fun main(){
    val array = intArrayOf(2,7,11,15)
    val target = 9
    println("Answer with the solution loop is:")
    twoSumWithLoop(array, target).forEach {
        println(it)
    }
    println("Answer with the solution map is:")
    twoSumWithMap(array, target).forEach {
        println(it)
    }
}

/**
 * [twoSumWithMap] has the Time Complexity of O(n) and Space Complexity of O(n)
 */
fun twoSumWithMap(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int,Int>()
    nums.forEachIndexed{ index, item ->
        val diff = target - item
        if(map.contains(diff)){
            return intArrayOf(index, map[diff]!!)
        } else{
            map[item] = index
        }
    }
    return intArrayOf()
}

/**
 * [twoSumWithLoop] has the Time Complexity of O(n^2) and Space Complexity of O(1)
 */
fun twoSumWithLoop(nums: IntArray, target: Int): IntArray {
    nums.forEachIndexed{ index1, item1 ->
        nums.forEachIndexed{ index2, item2 ->
            if (index1 != index2 && (item1 + item2 == target)){
                return intArrayOf(index1, index2)
            }
        }
    }
    return intArrayOf()
}