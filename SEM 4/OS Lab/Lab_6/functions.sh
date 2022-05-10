
function check_Age()
{
	echo -n "Enter the age = "
	read age
	
	if [ $age -gt 18 ]
	then
		echo "You are eligible to vote"
	else
		echo "You are not eligible to vote"
	fi
}


check_Age
