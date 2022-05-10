
echo "Enter the range to print = "

read a
read b

while [ $a -le $b ]

do 
	echo $a
	
	a=`expr $a + 1`
done
