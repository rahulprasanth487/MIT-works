from threading import *

def f1():
	for i in range(1,4):
		print("Process 1")

def f2():
	for i in range(1,4):
		print("process 2")


t1=Thread(target=f1,name="process1")
t2=Thread(target=f2,name="process2")

t1.start()
t2.start()

