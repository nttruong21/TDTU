def nega(str):
    list = str.split(",")
    left = list[0].split(" ")
    right = list[1].split(" ")
    D = []
    temp = []
    for item in left:
        if item == "Exist" or item == "For" or item == "all" or item == "There" or item == "is":
            temp.append(item)
        else:
            D.append(item)
    P = [right[i] for i in range(2, len(right))]
    N = []
    if temp == ["For", "all"]:
        N.append("Exist")
        for item in D:
            N.append(item)
        N.append(",")
        N.append(right[1])
        N.append("not")
        for item in P:
            N.append(item)
    else:
        N = ["For", "all"]
        for item in D:
            N.append(item)
        N.append(",")
        N.append(right[1])
        N.append("not")
        for item in P:
            N.append(item)
    return N


def printNega(N):
    for item in N:
        print(item, end=" ")
    print()


N = nega("For all fishes, they need water to survive.")
print("\na/")
printNega(N)

N = nega("Exist a person, who is left handed")
print("\nb/")
printNega(N)

N = nega("Exist an employee in the company, who is late to work everyday.")
print("\nc/")
printNega(N)

N = nega("For all fishes in this pond, they are Koi fish.")
print("\nd/")
printNega(N)

N = nega("There is at least one creature in the ocean, it can live on land")
print("\ne/")
printNega(N)