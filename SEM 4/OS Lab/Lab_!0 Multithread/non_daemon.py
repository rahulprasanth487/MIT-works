from threading import *
from time import sleep
# user defined function 1
def m1():
	for i in range(3):
		print("Good Morning...")
		sleep(1)

# user defined function 2

def m2():
	for i in range(3):
		print("Good Evening...")

# user defined function 3
def m3():
	for i in range(3):
		print("Good Night...")


print("----------------------------------------------------------")
print("\tNon Daemon Thread(User Threads)")
print("----------------------------------------------------------")
# creating objects for multiple threads
# Non Daemon Threads


t1=Thread(target=m1,name="Morning")
t2=Thread(target=m2,name="Evening")
t3=Thread(target=m3,name="Night")
# start the threads by calling start method
t1.start()
t1.join()
t2.start()
t2.join()
t3.start()
t3.join()
