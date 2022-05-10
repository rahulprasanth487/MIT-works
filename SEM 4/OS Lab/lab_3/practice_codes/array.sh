
#1.
echo "Arrays:- "

Array1=(1,2,3,4,5,6,7,8,9,10)

for i in $Array1
do 
	echo $i
done



#2
echo "Array2: = ";

Array2=("Hello" "World")
Array2[2]="Bye"

echo "${Array2[*]}"
