def hasPalindromePermutation(input):
    """ Check if any of a string's permutations are a palindrome
    e.g.
        Input: rraceca
        Output: true ('racecar' is a palindrome and permutation of input)

    Runtime complexity O(N)
    Space complexity O(N) """

    asciiChars = [0 for i in range(128)]
    for c in input:
        asciiChars[ord(c)] += 1
    
    seenOneOdd = False

    for c in asciiChars:
        if c % 2 != 0:
            if seenOneOdd:
                return False

            seenOneOdd = True
    
    return True

print(hasPalindromePermutation('racerac'))
print(hasPalindromePermutation('abcdefg'))
