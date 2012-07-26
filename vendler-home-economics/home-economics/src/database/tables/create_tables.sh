#!/bin/bash
FILES=*.sql
for f in *.sql
do
    echo $f
    time mysql -hlocalhost -P5521 -umsandbox -pmsandbox < $f
done
#mysql -hlocalhost -P5520 -umsandbox -pmsandbox < account_group.sql
#mysql -hlocalhost -P5520 -umsandbox -pmsandbox < account_group_accounts.sql