
cnt=0;
for i in `awk '{print tolower($1)}' textfile.txt`
do 
	x=$i;
	rev=` echo $i | rev `;
	if [ $x = $rev ]
	then 
		echo "'$x' is a Palidrome";
	fi
done


