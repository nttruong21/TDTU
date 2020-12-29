
# Dec -> Bin
def dec2bin(n):
    result = 0
    while n != 0:
        result = result*10 + n%10
        n //= 2
    return result

# Dec -> Hex
def dec2hex(n):
    li = []
    while n != 0:
        temp = n%16
        if temp == 10:
            li.append("A")
        elif temp == 11:
            li.append("B")
        elif temp == 12:
            li.append("C")
        elif temp == 13:
            li.append("D")
        elif temp == 14:
            li.append("E")
        elif temp == 15:
            li.append("F")
        else:
            li.append(str(temp))
        n //= 16
    result = ""
    for i in range(len(li)-1, -1, -1):
        result += li[i]
    return result

# Bin -> Dec
def bin2dec(n):
    result = 0
    count = 0
    while n != 0:
        result += n%10 * 2**count
        count += 1
        n //= 10
    return result

# Bin -> Hex
def bin2hex(n):
    temp = bin2dec(n)
    return dec2hex(temp)

# Hex -> Dec
def hex2dec(n):
    count = 0
    result = 0
    for i in range(len(n)-1, -1, -1):
        if n[i] == "A" or n[i] == "a":
            result += 10 * 16**count
        elif n[i] == "B" or n[i] == "b":
            result += 11 * 16**count
        elif n[i] == "C" or n[i] == "c":
            result += 12 * 16**count
        elif n[i] == "D" or n[i] == "d":
            result += 13 * 16**count
        elif n[i] == "E" or n[i] == "e":
            result += 14 * 16**count
        elif n[i] == "F" or n[i] == "f":
            result += 15 * 16**count
        else:
            result += int(n[i]) * 16**count
        count += 1
    return result

# Hex -> Bin
def hex2bin(n):
    temp = hex2dec(n)
    return dec2bin(temp)

def convertbase(a, base1, base2):
    result = []
    if base1 == 16:
        s = ""
        for item in a:
            s += str(item)
        if base2 == 2:
            return hex2bin(s)
        else:
            return hex2dec(s)
    elif base1 == 10:
        temp = 0
        for item in a:
            temp = temp*10 + int(item)
        if base2 == 2:
            return dec2bin(temp)
        else:
            return dec2hex(temp)
    elif base1 == 2:
        temp = 0
        for item in a:
            temp = temp*10 + int(item)
        if base2 == 10:
            return bin2dec(temp)
        else:
            return bin2hex(temp)
    else:
        return

print(convertbase([1,1,1],10,16))
