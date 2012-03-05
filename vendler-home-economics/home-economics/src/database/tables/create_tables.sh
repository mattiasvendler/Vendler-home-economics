#!/bin/bash
mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < account.sql
mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < account_group.sql
mysql -h127.0.0.1 -P5520 -umsandbox -pmsandbox < account_group_accounts.sql