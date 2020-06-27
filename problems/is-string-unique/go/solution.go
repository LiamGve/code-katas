package main

import "fmt"

// Assumption: All strings are in ASCII

func main() {
	fmt.Println("hello => ", slowUniqueString("hello")) // False
	fmt.Println("world => ", slowUniqueString("world")) // True

	fmt.Println("uniqe => ", fastUniqueString("uniqe")) // True
	fmt.Println("not a unique string... => ",
		fastUniqueString("not a unique string...")) 	// False
}

// O(n^2)
// n + n-1 + n-2 + ... n-(n-1)
func slowUniqueString(word string) bool {
	for i, c := range word {
		for _, ch := range word[i+1:] {
			if (c == ch) {
				return false;
			}
		}
	}
	return true;
}

// O(n)
func fastUniqueString(word string) bool {
	if (len(word) > 128) {
		return false;
	}

	var charBeenSeen [128]bool
	for _, c := range word {
		if (charBeenSeen[c]) {
			return false;
		}
		charBeenSeen[c] = true;
	}
	return true;
}
