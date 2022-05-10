Arr=(1 2 3 4) #homogeneous array
Arr2=("Rahul" 11 22 33 44)	#heterogeneous array

echo "Array 1---->"
echo ${Arr[*]}


echo "Array 2---->"

for i in ${Arr2[*]}
do
	echo $i 
done

echo -n "Displayed using index value = "
echo ${Arr[2]}