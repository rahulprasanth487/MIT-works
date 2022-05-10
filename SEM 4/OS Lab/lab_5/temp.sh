a=` grep -Eo [0-9]+ alphanumberic.txt `
for i in $a
do 
	echo $i
done
