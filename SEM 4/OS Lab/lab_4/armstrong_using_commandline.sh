a=$1

function Length() 
{
	len=0
	b=$a
	while [ $b -gt 0 ]
	do
		temp=`expr $b % 10`
		len=`expr $len + 1`
		b=`expr $b / 10`
	done
	
	return $len
}
Length
len=$?

echo $len



arm=0

Armstrong()
{
 	tot=0
	x=$a
	
	while [ $x -gt 0 ]
	do
		temp=`expr $x % 10`
		tot=$(($tot+$(($temp**$len))))
		x=`expr $x / 10`
	done

	#echo $tot;
	arm=$tot
}

Armstrong 

 
echo $arm



if [ $a == $arm ]
then 
	echo "It is an armstrong number"
else
	echo "It is NOT an armstrong number"
fi

