@echo off
echo ���������ʼ�������ݿ�...
pause
::mysql
::create database ktv613
::exit
mysql -h localhost -u root -p ktv613 < ..\ktv613.sql
echo �������
pause