function Count()
{
	name="$1"
	#len=` echo $name | wc -c `
	len=` expr length "$name"`
	echo "Your name has $len number of letters"
	
	rev=` echo $name | rev `


	if [ $name == $rev ]
	then 
		echo "It is a palindrome as well"
	else
		echo "It is not a palindrome"
	fi

}




echo -n "Enter your name = "
read name

Count $name
