def checkOneAwayRule(originalStr, newStr):
    """ Problem: given 2 strings, tell whether they are one move away from each other.
    There are 3 possible moves that can be made
    1. Replace char hello -> hellp
    2. Remove char  hello -> ello
    3. Add char     hello -> hellos
    Function should return True if one (or less) moves away and False when more than 1
    move away. See print lines at bottom for examples

    Runtime complexity of solution O(min(originalStr, newStr)) = O(N)
    """
    path = len(originalStr) - len(newStr)
    
    if path == 0:
        oneRuleApplied = False
        for i, _ in enumerate(originalStr):
            if originalStr[i] != newStr[i]:
                if oneRuleApplied:
                    return False
                oneRuleApplied = True
        return True
    elif path == -1:
        return checkAddCharacter(newStr, originalStr)
    elif path == 1:
        return checkAddCharacter(originalStr, newStr)

    return False


def checkAddCharacter(original, smaller):
    i = 0
    j = 0
    while i < len(original) and j < len(smaller):
        if smaller[i] != original[j]:
            if i != j:
                return False
        else:
            i += 1
        j += 1
    return True


print(checkOneAwayRule("pale", "ple"))   # True
print(checkOneAwayRule("pales", "pale")) # True
print(checkOneAwayRule("pale", "bale"))  # True
print(checkOneAwayRule("pale", "pale"))  # True
print(checkOneAwayRule("pale", "bake"))  # False