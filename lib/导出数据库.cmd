@echo off
echo ���������ʼ�������ݿ�...
pause
mysqldump -h localhost -u root -p ktv613 > ..\ktv613.sql
echo �������
pause