def dec2bin(n):
    a = n//1
    b = n - a
    temp1 = 0
    while a != 0:
        temp1 = temp1*10 + a%2
        a //= 2
    # u1 = 2u0 - r1
    # r2 = 2u1
    temp2 = 0
    count = 0
    while b != 0:
        r = int(2*b)
        b = 2*b - r
        temp2 = temp2*10 + r
        count += 1
    temp2 /= 10**count
    return temp1 + temp2

print(dec2bin(0.3))