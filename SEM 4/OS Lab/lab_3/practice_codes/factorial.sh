
echo "Enter the number = "
read n
fact=1

for((i=2;i<=n;i++))
{
	fact=$((fact * i))
}

echo $fact


