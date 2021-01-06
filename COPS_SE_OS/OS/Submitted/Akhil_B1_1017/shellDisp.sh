#!/bin/bash
echo "All shells of users: "
cat /etc/shells


usr=$(whoami)
echo ">>>>>>>>>>$usr is using shell:"
cat /etc/passwd | grep "$usr" | cut -d':' -f7
