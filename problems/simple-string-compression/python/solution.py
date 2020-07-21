# Problem:
# Given a string of chars in sequence, perform basic string compression. if compressed string 
# is same length (or larger) as original then return original
#
# Examples:
# aaabbbcccdddd -> a3b3c3d4
# abc -> abc


def compressSlow(inputStr):
    """
    Runtime is O(N + K^2) where N is the inputStr and K is the number of character sequences. I.e
    input shuld be aaabbbcccdddeeefff has 6 char sequences
    """
    compressed = ''
    currentCh = ''
    amountSeen = 0

    for c in inputStr:
        if c != currentCh:
            compressed += currentCh + str(amountSeen)
            currentCh = c
            amountSeen = 1
        elif c == currentCh:
            amountSeen += 1
    
    compressed += currentCh + str(amountSeen)

    if len(compressed[1:]) >= len(inputStr):
        return inputStr

    return compressed[1:]


def compressFast(inputStr):
    """
    Runtime is O(N + K) where N is the inputStr and K is the number of character sequences. I.e
    input shuld be aaabbbcccdddeeefff has 6 char sequences
    """
    currentCh = ''
    amountSeen = 0
    charCountArr = []

    for c in inputStr: # O(N)
        if c != currentCh:
            charCountArr.append(currentCh) # O(1)
            charCountArr.append(str(amountSeen)) # O(1)
            currentCh = c
            amountSeen = 1
        elif c == currentCh:
            amountSeen += 1

    charCountArr.append(currentCh)
    charCountArr.append(str(amountSeen))

    output = ''.join(charCountArr[2:]) # O(K) (technically O(2K) since the [2:] runs in K time too)

    if len(output) >= len(inputStr):
        return inputStr

    return output


# TESTS

# print(compressSlow('aaaabbbbccccddddeeeef')) # a4b4c4d4e4f1
# print(compressSlow('aaaabbbbccccddddeeeefgggijjjppp')) # a4b4c4d4e4f1g3i1j3p3
# print(compressSlow('gg')) # gg
# print(compressSlow('ggg')) # g3
# print(compressSlow('abcd')) # abcd

print(compressFast('aaaabbbbccccddddeeeef')) # a4b4c4d4e4f1
print(compressFast('aaaabbbbccccddddeeeefgggijjjppp')) # a4b4c4d4e4f1g3i1j3p3
print(compressFast('gg')) # gg
print(compressFast('ggg')) # g3
print(compressFast('abcd')) # abcd

