package main

import "fmt"

func main() {
	fmt.Println(permutationSlow("abc", "cab"))       // True
	fmt.Println(permutationSlow("abc", "cba"))       // True
	fmt.Println(permutationSlow("abcd", "ab"))       // False
	fmt.Println(permutationSlow("abcd", "abqd"))     // False
	fmt.Println(permutationSlow("abcd", "abcddcba")) // False
	fmt.Println(permutationSlow("zxy", "zzxyx"))     // False
}

// Runtime complexity = O(N^2) since permutation and word are same length by definition of permutation
// Space complexity = O(1)
func permutationSlow(word string, permutation string) bool {
	if (len(word) != len(permutation)) {
		return false;
	}

	for _, c := range permutation {
		if (!contains(word, c)) {
			return false;
		}
	}
	return true;
}

// Runtime complexity = O(N), where N is word or permutation since word and permutation have equal length
// Space complexity = O(1) since array for ascii is always fixed length of 128
// If we make assumption that only ascii characters then we can speed up algo slightly
func permutationFast(word string, permutation string) bool {
	if (len(word) != len(permutation)) {
		return false
	}

	var chars [128]int;

	for _, c := range permutation {
		chars[c]++;
	}

	for _, c := range word {
		chars[c]--;
		if (chars[c] < 0) {
			return false;
		}
	}
	return true;
}

// Helper function runs in O(word)
func contains(word string, c rune) bool {
	for _, ch := range word {
		if c == ch {
			return true;
		}
	}
	return false;
}
