import xlwt
import os
import importlib
def main():
	pass
def randombin(n):

	x=''
	for i in range(n):
		x+=random.sample(['0','1'],1)[0]
	return x
if __name__ == "__main__":
	testname={x:y for x,y in zip(range(10),['sum','dif','prod','bitwiseAnd','bitwiseOr','bitwiseXor','bitwiseNot','bitwiseLeftShift','bitwiseRightShift','bin2Hex'])}
	#testfunction={x:y for x,y in zip(range(10),[sum,dif,prod,bitwiseAnd,bitwiseOr,bitwiseXor,bitwiseNot,bitwiseLeftShift,bitwiseRightShift,bin2Hex])}
	with open('testcases.txt','r') as f:
		lines=f.readlines()
	A=[lines[i].strip() for i in range(0,len(lines),2)]
	B=[lines[i].strip() for i in range(1,len(lines),2)]
	with open('testcases.cases','r') as f2:			
		answers=f2.readlines()
	answers=[answers[i].strip() for i in range(len(answers))]

	Dir=os.listdir()
	Dir=[a[0:-3] for a in Dir if '.py' in a and 'Test' not in a and 'Answer' not in a and 'Score' not in a]
	print(Dir)
	book = xlwt.Workbook()
	sh = book.add_sheet('Sheet1')#Write XLSX HEADER
	sh.write(0,0,'ID')#Write XLSX HEADER
	for i in range(1,len(testname)+1):
		sh.write(0,i,str(testname[i-1]))#Write XLSX HEADER
	sh.write(0,i+1,'Total program point')
	n=1
	ntest=len(A)
	
	for d in Dir:
		#Import Student program 
		mod = importlib.import_module(d)
		calculate=[]
		for a,b in zip(A,B):
			try:
				calculate.append(mod.sum(a,b))
			except:
				calculate.append('no function')
				
			try:
				calculate.append(mod.dif(a,b))
			except:
				calculate.append('no function')
				
			try:
				calculate.append(mod.prod(a,b))
			except:
				calculate.append('no function')
			
			try:
				calculate.append(mod.bitwiseAnd(a,b))
			except:
				calculate.append('no function')
				
			try:
				calculate.append(mod.bitwiseOr(a,b))
			except:
				calculate.append('no function')
			
			try:
				calculate.append(mod.bitwiseXor(a,b))
			except:
				calculate.append('no function')
			
			try:
				calculate.append(mod.bitwiseNot(a))
			except:
				calculate.append('no function')
				
			try:
				calculate.append(mod.bitwiseLeftShift(a))
			except:
				calculate.append('no function')

			try: 
				calculate.append(mod.bitwiseRightShift(a))
			except:
				calculate.append('no function')
			
			try:			
				calculate.append(mod.bin2Hex(a))
			except:
				calculate.append('no function')
#			calculate+=[mod.testfunction[i](a,b) for i in range(6)]
#			calculate+=[mod.testfunction[i](a) for i in range(6,10)]
		Score=[]
		for i in testname:
			score1=0;
			for k in range(ntest):	
				if answers[i+k*10]==calculate[i+k*10]:
					score1+=10/ntest
			Score.append(score1)
		sh.write(n,0,d)
		#Write Scores to XLSX FILE
		for i in range(1,len(Score)+1):
			sh.write(n,i,Score[i-1])
		sh.write(n,i+1,sum(Score)/20)	
		n+=1

	book.save('Score.csv')