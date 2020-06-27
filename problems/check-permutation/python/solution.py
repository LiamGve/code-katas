
def permutationSlow(word, permutation):
    """ Runtime complexity = O(N^2) 
    since permutation and word are same length by definition of permutation
    Space complexity = O(1) """

    if len(word) != len(permutation):
        return False

    for c in permutation:
        if c not in word:
            return False
    return True


def permutationFast(word, permutation):
    """ Runtime complexity = O(N), where N is word or permutation since word and permutation have equal length
    Space complexity = O(1) since array for ascii is always fixed length of 128
    If we make assumption that only ascii characters then we can speed up algo slightly """

    if len(word) != len(permutation):
        return False

    chars = [0 for i in range(128)]

    for c in permutation:
        chars[ord(c)] += 1

    for c in word:
        chars[ord(c)] -= 1
        if chars[ord(c)] < 0:
            return False

    return True

print(permutationSlow("abc", "cab"))        # True
print(permutationFast("abc", "cba"))        # True
print(permutationSlow("abcd", "ab"))        # False
print(permutationFast("abcd", "abqd"))      # False
print(permutationSlow("abcd", "abcddcba"))  # False
print(permutationFast("zxy", "zzxyx"))      # False