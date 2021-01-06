#!/bin/bash
##Created by @AkhilDarge on 21/10/20.
read -p "Enter a String: " str

strlen=${#str}

if [ "$strlen" -gt 7 ]; then
	if [[ $str =~ [0-9] ]]; then
		#echo "Input contains number"
		if [[ $str =~ [A-Z] ]]; then

			if [[ $str =~ [a-z] ]]; then
				echo "Bravo!!!! String is accepted"
				exit
			else
				echo "String should contain lowercase"
				exit
			fi

		else
			echo "String should contain uppercase"

			exit
		fi

	else
		echo "String should contain some numerical"
		exit
	fi
	echo "$strlen"
else
	echo "String should be 8 character"
	exit
fi
