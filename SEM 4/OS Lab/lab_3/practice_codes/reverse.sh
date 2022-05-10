echo -n "Enter the number = "
read x
n=$x
rev=0

while [ $n -gt 0 ]

do
	rem=`expr $n % 10`
	rev=`expr $rev \* 10 + $rem`
	n=`expr $n / 10`
done



if [ $x == $rev ]
then 
	echo "It is an palindrome"
else 
	echo "It is not a palindrome"
fi
