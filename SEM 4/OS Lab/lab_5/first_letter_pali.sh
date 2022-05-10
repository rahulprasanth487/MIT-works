x=""

for i in `awk '{print $1}' textfile.txt`
do
	x+=${i:0:1}
done


rev=` echo $x | rev `




if [ $x = $rev ]
then 
	echo "$x is a palindrome"
else
	echo "$x is not a palindrome"
fi


