
a=` grep -Eo [0-9]+ alphanumberic.txt `




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

arm=0


function Armstrong()
{
 	tot=0
	x=$1
	
	while [ $x -gt 0 ]
	do
		temp=`expr $x % 10`
		tot=$(($tot+$(($temp**$len))))
		x=`expr $x / 10`
	done

	arm=$tot
}



for i in $a
do 
	echo $i

	Length $i
	len=$?


	Armstrong $i


	if [ $i -eq $arm ]
	then 
		echo "It is an armstrong number"
	else
		echo "It is NOT an armstrong number"
	fi
done

