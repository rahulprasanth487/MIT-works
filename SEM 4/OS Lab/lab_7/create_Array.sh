Arr=()
echo -n "Enter the length of the array = "
read len

for((i=0;i<len;++i))
do
	echo -n "element = "
	read Arr[$i]
done


echo ${Arr[*]}