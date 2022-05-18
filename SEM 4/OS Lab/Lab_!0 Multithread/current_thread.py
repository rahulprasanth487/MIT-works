from threading import *
import threading

def f1():
	curr=threading.currentThread().getName()
	print(curr+" starts executing")
	for i in range(1,4):
		print("P-1")
	
def f2():
	curr=threading.currentThread().getName()
	print(curr+" starts executing")
	for i in range(1,4):
		print("P-2")


t1=Thread(target=f1,name="Process 1")
t2=Thread(target=f2,name="Process 2")

t1.start()
#wait untill t1 terminates
t1.join()

t2.start()
t2.join()

