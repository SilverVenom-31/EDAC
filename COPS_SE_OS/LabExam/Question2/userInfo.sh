#!/bin/bash
#Created by @AkhilD on 26/1/21.

echo "UserName and shell:  "
cat /etc/passwd | cut -d':' -f1,7 >/tmp/test

while read line; do
	usr=$(echo "$line" | cut -d':' -f1)
	shell=$(echo "$line" | cut -d':' -f2)

	echo "$usr  $shell"

done </tmp/test
