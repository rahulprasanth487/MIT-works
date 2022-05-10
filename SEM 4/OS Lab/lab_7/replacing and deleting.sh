Arr=("Rahul" "Prasanth" "123456")

echo ${Arr[@]//"Rahul"/"RAHUL"}
echo ${Arr[@]//"a"/"A"}
echo ${Arr[@]//"2345"/"XXXX"}


