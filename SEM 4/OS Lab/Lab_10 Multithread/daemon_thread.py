from threading import *
from time import sleep

def f1():
	for i in range(1,4):
	    print("Process 1")
	    sleep(2)

def f2():
	for i in range(1,4):
		print("process 2")


t1=Thread(target=f1,name="process1",daemon=True)
#here t1 will start and pause after the first execution because it has lower priority
t2=Thread(target=f2,name="process2")

t1.start()
t2.start()
