package main

import "fmt"

func main() {
	fmt.Println(oneRuleAway("pale", "ple"));   // True
	fmt.Println(oneRuleAway("pales", "pale")); // True
	fmt.Println(oneRuleAway("pale", "bale"));  // True
	fmt.Println(oneRuleAway("pale", "pale"));  // True
	fmt.Println(oneRuleAway("pale", "bake"));  // False
}

/*
*  (See python for problem spec)
*  Runtime complexity O(max(originalStr, newStr)) = O(N)
*/ 
func oneRuleAway(original string, newStr string) bool {
	path := len(original) - len(newStr);

	if (path == 0) {
		oneRuleApplied := false
		for i := range original {
			if (original[i] != newStr[i]) {
				if (oneRuleApplied) {
					return false;
				}
				oneRuleApplied = true;
			}
		}
		return true;
	} else if (path == -1) {
		return oneCharAway(newStr, original);
	} else if (path == 1) {
		return oneCharAway(original, newStr);
	}

	return false;
}

func oneCharAway(larger string, smaller string) bool {
	j := 0;
	for i := range smaller {
		if (larger[i] != smaller[j]) {
			if (j != i) {
				return false;
			}
		} else {
			j++;
		}
	}
	return true;
}