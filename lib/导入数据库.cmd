@echo off
echo 按任意键开始导入数据库...
pause
::mysql
::echo create database ktv613;
::exit;
mysql -h localhost -u root -p ktv613 < ..\ktv613.sql
echo 导入完成
pause