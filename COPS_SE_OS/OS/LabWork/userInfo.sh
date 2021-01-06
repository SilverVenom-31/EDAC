#!/bin/bash
##Created by @AkhilDarge on 15/10/20.

read -p "Enter username: " user
cat /etc/passwd | grep -E "(bash|sh|zsh|tcsh|ksh)" | grep -v "root" | awk -F':' '{print $1}' >/tmp/data

while read line; do
	cat /etc/shadow | grep "$line" | grep "\!\!" | awk -F':' '{print $1}' >>/tmp/data2

done </tmp/data

##if false then returns true in bash script;

if grep -q $user /tmp/data; then ##if grep command executes(matched) successfully then returns 0
	cat /etc/passwd | grep $user
	if grep -q $user /tmp/data2; then
		echo "$user password has not set"
	fi
else
	echo "User does not exists"

fi
