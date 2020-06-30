package main

import "fmt"

/*
 * Problem: check if any of a string's permutations are a palindrome
 * e.g.
 *  Input: rraceca
 *  Output: true ('racecar' is a palindrome and permutation of input)
 */
func main() {
	fmt.Println(hasPalindromePermutation("racerac")) // true
	fmt.Println(hasPalindromePermutation("abcdefg")) // false
}

/**
* Runtime complexity O(N)
* Space complexity O(N)
 */
func hasPalindromePermutation(input string) bool {
	var asciiChars [128]int

	for _, c := range input {
		asciiChars[c]++
	}
	seenOddAlready := false
	for _, c := range asciiChars {
		if c%2 != 0 {
			if seenOddAlready {
				return false
			}
			seenOddAlready = true
		}
	}
	return true
}
