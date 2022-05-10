x=""
cnt=0;
while read -r line;
do 
	x+=${line:$cnt:1}
	cnt=$(($cnt+1));

done < textfile.txt;

rev=` echo $x | rev `



if [ $x = $rev ]
then 
	echo "$x is a palindrome"
else
	echo "$x is not a palindrome"
fi


