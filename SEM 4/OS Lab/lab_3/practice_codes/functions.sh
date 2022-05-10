#1.print using function

HELLO () {
	echo "Function1 is called"
}
#calling function 1
HELLO



#passing argments
HELLO2 () {
	echo "Parameter->1 =  $1"
	echo "Parameter->2 =  $2"
}
HELLO2 A B


#return statements

RETURNING () {
	a=$1
	return $a
}

RETURNING 100

echo $?
