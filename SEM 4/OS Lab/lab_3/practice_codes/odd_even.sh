#Here we are going to check the number whether it is odd or not


echo "Enter the number = "
read n

if [ `expr $n % 2` == 0 ]
then 
	echo "It is even"
else 
	echo "It is odd"
fi
