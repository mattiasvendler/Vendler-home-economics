#!/bin/bash
cd tables/
./create_tables.sh
cd ../data
echo "Inserting data"
#time mysql -h127.0.0.1 -P5521 -umsandbox -pmsandbox < insert.sql
echo "Inserting data done"
cd ../procedures
./compile.sh
