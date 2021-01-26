#!/bin/bash
#Created by @AkhilD on 26/1/21
echo "List of files: "
ls | wc -l

echo "Count of pdf files: "
ls *.pdf | wc -l

echo "Count of docx files: "
ls *.docx | wc -l

for f in *.pdf; do
        mv -- "$f" "${f%.pdf}.docx"
done

pdf=$(ls *.pdf | wc -l)
echo "Count of pdf files after renaming: $pdf"

echo "Count of docx files after renaming "
ls *.docx | wc -l

echo "Files which have underscore: "
ls | grep "[_]"
