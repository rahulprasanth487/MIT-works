
function Length() 
{
	len=0
	b=$1
	while [ $b -gt 0 ]
	do
		temp=`expr $b % 10`
		len=`expr $len + 1`
		b=`expr $b / 10`
	done
	
	return $len
}

echo -n "Enter the number = "
read num
Length $num
len=$?
echo $len 
