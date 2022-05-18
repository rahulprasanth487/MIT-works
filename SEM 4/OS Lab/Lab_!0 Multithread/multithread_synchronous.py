#Join is a synchronization method that blocks the calling thread (that is, the thread that calls the method) until the thread whose Join method is called has completed. Use this method to ensure that a thread has been terminated


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
#wait untill t1 terminates
t1.join()

t2.start()
t2.join()

