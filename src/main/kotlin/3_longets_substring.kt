@file:Suppress("SpellCheckingInspection")

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Difficulty: Medium
 *
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

fun main() {
//    val input = "ohvhjdml"
    val input = "abcdefgh"
    println("Longest substring length is: ${lengthOfLongestSubstring(input)}")
}

fun lengthOfLongestSubstring(s: String): Int { //ohvhjdml

    val tempSubstrings = mutableListOf<MutableMap<Char, Boolean>>()
    val finalSubstrings = mutableListOf<MutableMap<Char, Boolean>>()

    s.forEach { char ->
        tempSubstrings.add(mutableMapOf())
        val validSubStrings = mutableListOf<MutableMap<Char, Boolean>>()
        tempSubstrings.forEach { substring ->
            if (substring[char] == true) {
                validSubStrings.add(substring)
            } else {
                substring[char] = true
            }
        }

        validSubStrings.forEach { substring ->
            finalSubstrings.add(substring)
            tempSubstrings.remove(substring)
        }
        validSubStrings.clear()
    }

    var longestSubstring = 0

    tempSubstrings.forEach { substring ->
        if (substring.size > longestSubstring) {
            longestSubstring = substring.size
        }
    }

    finalSubstrings.forEach { substring ->
        if (substring.size > longestSubstring) {
            longestSubstring = substring.size
        }
    }

    return longestSubstring
}