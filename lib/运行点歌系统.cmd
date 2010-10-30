@echo off
cd ..
set classpath=%CD%\lib\miglayout-3.7-swing.jar;%CD%\lib\pinyin4j-2.5.0.jar;%CD%\lib\mysql-connector-java-5.0.4-bin.jar;%CD%\bin;%CD%;%classpath%
java com.xch.client.LoginUser
