#!/bin/bash
FILES=*.sql
for f in *.sql
do
    echo $f
    mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < $f
done

#mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < *.sql
