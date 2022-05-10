Arr=(9 8 7 6 5 4 3 2 1)

for ((i=0;i< ${#Arr[*]};++i))
do
	for((j=0;j<${#Arr[*]}-i-1;++j))
	do
		if((${Arr[j]}>${Arr[j+1]}))
		then
			temp=${Arr[j]}
			Arr[j]=${Arr[j+1]}
			Arr[j+1]=$temp
		fi
		echo ${Arr[@]}
	done
done

echo ${Arr[@]}
