def removeLeadZero(A):
    for i in range(len(A)):
            if A[i] != "0":
                return A[i:]
    return "0"

# Exercise 1
def sum(A, B):
    maxLen = max(len(A), len(B))
    A = A.zfill(maxLen)
    B = B.zfill(maxLen)
    result = ""
    count = 0
    for i in range(maxLen-1, -1, -1):
        temp = count
        temp += 1 if A[i] == "1" else 0
        temp += 1 if B[i] == "1" else 0
        result = ("0" if temp%2 == 0 else "1") + result
        count = 0 if temp < 2 else 1
    if count != 0:
        result = "1" + result
    return removeLeadZero(result)
    

# Exercise 2
def dif(A, B):
    if(int(A) < int(B)):
        return "error"
    else:
        maxLen = max(len(A), len(B))
        A = A.zfill(maxLen)
        B = B.zfill(maxLen)
        result = ""
        count = 0
        for i in range(maxLen-1, -1, -1):
            temp = int(A[i]) - int(B[i])
            if temp < 0:
                if count == 0:
                    result = "1" + result
                    count = 1
                else:
                    result = "0" + result
            elif temp == 0:
                if count == 0:
                    result = "0" + result
                else:
                    result = "1" + result
            else:
                if count == 0:
                    result = "1" + result
                else:
                    count = 0
                    result = "0" + result
        return removeLeadZero(result)

# Exercise 3
def prod(A, B):
    result = ""
    for i in range(len(B)-1, -1, -1):
        if B[i] == "1":
            temp = A
            for j in range(1, len(B)-i):
                temp += "0"
            result = sum(result, temp)
    if result == "":
        result = "0"
    return result

# Exercise 4
def bitwiseAnd(A, B):
    maxLen = max(len(A), len(B))
    A = A.zfill(maxLen)
    B = B.zfill(maxLen)
    result = ""
    for i in range(maxLen-1, -1, -1):
        if A[i] == "1" and B[i] == "1":
            result = "1" + result
        else:
            result = "0" + result
    return removeLeadZero(result)

# Exercise 5
def bitwiseOr(A,B):
    maxLen = max(len(A), len(B))
    A = A.zfill(maxLen)
    B = B.zfill(maxLen)
    result = ""
    for i in range(maxLen-1, -1, -1):
        if A[i] == "0" and B[i] == "0":
            result = "0" + result
        else:
            result = "1" + result
    return removeLeadZero(result)

# Exercise 6
def bitwiseXor(A,B):
    maxLen = max(len(A), len(B))
    A = A.zfill(maxLen)
    B = B.zfill(maxLen)
    result = ""
    for i in range(maxLen-1, -1, -1):
        result = ("0" if A[i] == B[i] else "1") + result
    return removeLeadZero(result)

# Exercise 7
def bitwiseNot(A):
    result = ""
    for i in range(len(A)):
        result += "0" if A[i] == "1" else "1"
    return removeLeadZero(result)

# Exercise 8
def bitwiseLeftShift(A):
    result = ""
    for i in range(1, len(A)):
        result += A[i]
    result += A[0]
    return removeLeadZero(result)

# Exercise 9
def bitwiseRightShift(A):
    result = ""
    result += A[len(A)-1]
    for i in range(len(A)-1):
        result += A[i]
    return removeLeadZero(result)

# Exercise 10
def bin2Hex(A):
    dic = {}
    tmp = "0"
    for i in range(16):
        if i < 10:
            dic[tmp.zfill(4)] = str(i)
        else:
            dic[tmp.zfill(4)] = chr(i%10 + 65)
        tmp = sum(tmp, "1")
    maxLen = len(A) + (4 - len(A)%4)
    A = A.zfill(maxLen)
    result = ""
    for i in range(maxLen-1, -1, -4):
        temp = ""
        for j in range(i, i-4, -1):
            temp = A[j] + temp
        for item in dic:
            if item == temp:
                result = dic[item] + result
    return removeLeadZero(result)
