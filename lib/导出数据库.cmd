@echo off
echo 按任意键开始导出数据库...
pause
mysqldump -h localhost -u root -p ktv613 > ..\ktv613.sql
echo 导出完成
pause