package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(urlify("i npu  t   "))
}

// O(N) + O(N) = O(N)
func urlify(rawInput string) string {
	encoded := strings.TrimSpace(rawInput)
	return strings.ReplaceAll(encoded, " ", "%20")
}
