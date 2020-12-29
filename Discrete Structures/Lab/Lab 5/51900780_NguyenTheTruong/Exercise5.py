import itertools
def lImplies(p, q):
	if p:
		return q
	return True

print(" - Exercise a:")
S1 = "q -> t"
S2 = "p -> t"
S3 = "r -> t"
P = "p"
C = "t"
print(" %s\n %s\n .%s" %(S2, P, C))
table = list(itertools.product([False, True], repeat = 4))
p = [a[0] for a in table]
q = [a[1] for a in table]
r = [a[2] for a in table]
t = [a[3] for a in table]
S2 = [lImplies(p[i], t[i]) for i in range(len(table))]
print("\n p\t q\t r\t t\t p->t")
for i in range(len(table)):
	print( p[i],"\t", q[i], "\t", r[i], "\t", t[i], "\t", S2[i])
	
print(" - Exercise b:")
P = "p"
Q = "q"
S1 = "~q ^ r"
S2 = "p -> (v^r)"
S3 = "s ^ r"
S4 = "~s -> ~v"
C = "v"
print(" %s\n %s\n .%s" %(P, S2, C))
table = list(itertools.product([False, True], repeat = 3))
p = [a[0] for a in table]
r = [a[1] for a in table]
v = [a[2] for a in table]
S2 = [lImplies(p[i], (v[i] and r[i])) for i in range(len(table))]
print("\n p\t r\t v\t p->(v^r)")
for i in range(len(table)):
	print( p[i], "\t", r[i], "\t", v[i], "\t", S2[i])