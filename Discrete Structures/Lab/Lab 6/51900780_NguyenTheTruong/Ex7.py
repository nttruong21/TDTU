def dec2bin(n):
    temp = 0
    while n != 0:
        temp = temp*10 + n%2
        n //= 2
    return temp

print("21 ->", dec2bin(21))
