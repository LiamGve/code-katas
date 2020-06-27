# Assumption: All strings are in ASCII


def slowUniqueString(word):
    """ O(n^2)
    n + n-1 + n-2 + ... n-(n-1) """
    for i, c in enumerate(word):
        for j in word[i + 1:]:
            if c == j:
                return False
    return True

def fastUniqueString(word):
    """ O(n) """
    if len(word) > 128:
        return False

    char_been_seen = [False for i in range(128)] 
    for c in word:
        ascii_val = ord(c);
        if char_been_seen[ascii_val]:
            return False
        char_been_seen[ascii_val] = True
    return True


print(slowUniqueString("hello"))                  # False
print(slowUniqueString("world"))                  # True

print(fastUniqueString("uniqe"))                  # True
print(fastUniqueString("not a unique string...")) # False