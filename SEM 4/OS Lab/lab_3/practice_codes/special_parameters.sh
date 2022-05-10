echo "File name = $0"
echo "First Parameter = $1"
echo "Second Prameter = $2"
echo "Third parameter = $3"

#nth parameter will be like $n

echo "QUoted values or all values  = $*";
echo "Total parameters = $#"





##USING FOR LOOP

echo "using FOR LOOP : "

for token in $*
do 
	echo $token
done
