def toLoE(A):
    li = []
    visited = [[False for _ in range(len(A[0]))] for _ in range(len(A))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            if(A[i][j] != 0 and visited[i][j] == False):
                visited[i][j] = True
                visited[j][i] = True
                li.append([i, j, A[i][j]])
    return li

A = [[0, 0, 2, 3, 3, 0],
[0, 0, 3, 2, 0, 0],
[2, 3, 0, 2, 8, 6],
[3, 2, 2, 0, 0, 5],
[3, 0, 8, 0, 0, 3],
[0, 0, 6, 5, 3, 0]]
print(toLoE(A))