#CREATE A FILE


CREATE () {
	echo -n "Enter the text to be stored = "
	read string
	echo $string>textfile.txt
}

CREATE


SEARCH () {
	echo "Enter the word to search = "
	read sear
	echo "Total count of $sear is = "
	grep -o "$sear" textfile.txt |wc -w

}

SEARCH
