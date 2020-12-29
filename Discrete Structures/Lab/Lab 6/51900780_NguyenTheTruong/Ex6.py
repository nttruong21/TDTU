def lcm(a, b):
    pro = a*b
    while b != 0:
        temp = b
        b = a%b
        a = temp
    return pro/a

print("lcm(12, 8) = ", lcm(12, 8))