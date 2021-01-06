#!/bin/bash

read -p "Enter file name: " data
echo "Unique occurence of String in file its occurence number: "
cat $data |sort | uniq -c



