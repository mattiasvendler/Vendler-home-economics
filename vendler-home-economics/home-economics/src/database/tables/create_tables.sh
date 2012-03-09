#!/bin/bash
FILES=*.sql
for f in *.sql
do
    echo $f
    time mysql -h127.0.0.1 -P5521 -umsandbox -pmsandbox < $f
done
#mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < account_group.sql
#mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < account_group_accounts.sql