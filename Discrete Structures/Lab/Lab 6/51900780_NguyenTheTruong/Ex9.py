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



print("35631->", dec2hex(35631))
