Arr=('A' 'B' 'C' 'D' 'E' 'F' 'G' 'H')

str=""
for i in ${Arr[@]}
do
	str+=$i;
done

echo $str