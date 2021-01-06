#!/bin/bash
##Created by @AkhilDarge on 20/10/20

##users count is stored in /tmp/data2 and run script:[# ./userMonitoring & ] in this format for background

while true; do
	cat /etc/passwd | grep -v "nfsnobody" | awk -F':' '{print $3}' >/tmp/data

	while read line; do
		if [ $line -gt 999 ]; then
			cat /etc/passwd | grep -w "$line" >>/tmp/data2

		fi

	done </tmp/data

	users=$(wc -l /tmp/data2 | awk -F' ' '{print $1}')
	echo "Number of users: $users" >/tmp/data2

	sleep 1
done
