def urlify(rawInput):
    """ Complexity O(N) for rstrip and O(N) for building of encoded string
    so overall complexity is O(N) """
    encoded = ''
    for c in rawInput.rstrip():
        if c == ' ':
            encoded += '%20'
        else:
            encoded += c
    return encoded

print(urlify('i npu  t   '))