from threading import *

def Welcome():
	print("Hello world using single thread")

th=Thread(target=Welcome,name="Thread1")
th.start()
