function Sum()
{
	su=0
	Arr=("$@")
	for i in ${Arr[*]}
	do
		su=$(($su+$i))
	done
	
	return $su
}
a=(1 2 3 4 5)
Sum ${a[@]}
s=$?
echo "Sum of the elements = $s"