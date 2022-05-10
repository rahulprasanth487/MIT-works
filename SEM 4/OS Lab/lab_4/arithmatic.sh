echo "Enter the values"
echo -n "a = "
read a
echo -n "b = "
read b


#addition

echo "Addition = $(($a+$b))"
echo "Subtraction = $(($a-$b))"
echo "MUltiplication = $(($a*$b))"
echo "floor Division = $(($a/$b))"
echo "Division = $(($a/$b))"|bc
echo "Modulus = $(($a%$b))"



