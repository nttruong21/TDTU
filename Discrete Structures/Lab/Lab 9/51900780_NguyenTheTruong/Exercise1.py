

# Exercise a
def mPlus(A, B):
    if len(A) != len(B) or len(A[0]) != len(B[0]):
        return "Error"
    else:
        result = [[0 for _ in range(len(A[0]))] for _ in range(len(A))]
        for i in range(len(A)):
            for j in range(len(A[0])):
                result[i][j] = A[i][j] + B[i][j]
        return result

# Exercise b
def mMinus(A, B):
    if len(A) != len(B) or len(A[0]) != len(B[0]):
        return "Error"
    else:
        result = [[0 for _ in range(len(A[0]))] for _ in range(len(A))]
        for i in range(len(A)):
            for j in range(len(A[0])):
                result[i][j] = A[i][j] - B[i][j]
        return result

# Exercise c
def mMultiply(A, B):
    if len(A[0]) != len(B):
        return "Error"
    else:
        result = [[0 for _ in range(len(B[0]))] for _ in range(len(A))]
        for i in range(len(A)):
            for j in range(len(B[0])):
                temp = 0
                for k in range(len(A[0])):
                    temp += A[i][k] * B[k][j]
                result[i][j] = temp
        return result

# Exercise d
def mTranspose(A):
    result = [[0 for _ in range(len(A))] for _ in range(len(A[0]))]
    for i in range(len(A[0])):
        for j in range(len(A)):
            result[i][j] = A[j][i]
    return result

# Exercise e
A = [[1, 2], [3, 4]]
B = [[2, 0], [1, 2]]
print(mMultiply(A, B))
print(mMultiply(B, A))

# Exercise f
A = [[1, 4, 6, 10], [2, 7, 5, 3]]
B = [[1, 4, 6], [2, 7, 5], [9, 0, 11], [3, 1, 0]]
print(mMultiply(A, B))
print(mTranspose(A))
print(mTranspose(B))
    