import itertools

def lImplements(p, q):
    if p:
        return q
    else:
        return False

def cau_a():
    table = list(itertools.product([False, True], repeat = 3))
    p = [a[0] for a in table]
    q = [a[1] for a in table]
    r = [a[2] for a in table]
    qAr = [q[i] and r[i] for i in range(len(table))]
    left = [(not p[i]) or qAr[i] for i in range(len(table))]
    result = [lImplements(left[i], r[i]) for i in range(len(table))]
    return result

print(cau_a())

def cau_b():
    table = list(itertools.product([False, True], repeat = 2))
    p = [a[0] for a in table]
    q = [a[1] for a in table]
    NpAq = [(not p[i]) and q[i] for i in range(len(table))]
    left = [not(p[i] or NpAq[i]) for i in range(len(table))]
    right = [(not p[i]) and (not q[i]) for i in range(len(table))]
    for i in range(len(table)):
        if left[i] != right[i]:
            return False
    return True

print(cau_b())

def cau_c():
    table = list(itertools.product([False, True], repeat = 2))
    p = [a[0] for a in table]
    q = [a[1] for a in table]
    pIq = [lImplements(p[i], q[i]) for i in range(len(table))]
    Nq = [not q[i] for i in range(len(table))]
    Np = [not p[i] for i in range(len(table))]
    for i in range(len(table)):
        if pIq[i] and Nq[i] and Np[i]:
            return True
    return False

print(cau_c())