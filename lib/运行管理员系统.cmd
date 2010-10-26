@echo off
cd ..
set classpath=%CD%\lib;%CD%\bin;%CD%;%classpath%
java com.xch.server.LoginAdmin
