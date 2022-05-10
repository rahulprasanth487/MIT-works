Arr=()
echo -n "Enter the length of the array = "
read len

for((i=0;i<len;++i))
do
	echo -n "element = "
	read Arr[$i]
done


echo ${Arr[*]}

echo -n "Enter the index of the element to delete = ";
read n


ele=${Arr[$n]}
echo -n "Temporary removal from the array = "
echo ${Arr[@]/$ele/}
echo -n "Original Array = "
echo ${Arr[*]}
echo -n "Permanent removal from the array = "
unset Arr[n]
echo ${Arr[*]}

echo -n "Original Array after removal= "
echo ${Arr[*]}