function prime()
{
	n=$1
	for((i=2;i<n;++i))
	{
		if(($n%$i==0));
		then
			return 0
		fi
	
	}

	return 1
}
echo -n "Enter the number  = "
read n
prime $n
num=$?

if(($num==0))
then 
	echo "It is a Non-prime number "
else
	echo "It is a prime number "
fi
