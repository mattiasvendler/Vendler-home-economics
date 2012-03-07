#!/bin/bash
cd tables/
./create_tables.sh
cd ../data
time mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < insert.sql
cd ../procedures
./compile.sh
