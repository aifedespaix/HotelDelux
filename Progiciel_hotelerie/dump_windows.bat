color 02
@echo off
set cheminProj=%~dp0
SET isodate=%DATE:~6,4%%DATE:~3,2%%DATE:~0,2%
set t=%time:~0,8%
rem replace colons with dashes
set t=%t::=-%
@echo =======================================================
@echo En recherche de mysqldump.exe
@echo =======================================================
IF EXIST C:\Program Files (x86)\EasyPHP-DevServer-14.1VC9\binaries\mysql\bin GOTO KEVIN
IF EXIST C:\wamp64\bin\mysql\mysql5.7.14\bin GOTO THOMAS
IF EXIST C:\C:\xampp\mysql\bin GOTO JOAN


:KEVIN
@echo =======================================================
@echo MysqlDump.exe trouvee
@echo =======================================================
@echo =======================================================
@echo Création du dump
@echo =======================================================
cd "C:\Program Files (x86)\EasyPHP-DevServer-14.1VC9\binaries\mysql\bin"
mysqldump.exe -u root hotel --add-drop-table --skip-add-locks > %cheminProj%dump\dump_%isodate%_%t%.sql%
@echo =======================================================
@echo Dump OK
@echo =======================================================
pause
exit

:THOMAS
@echo =======================================================
@echo MysqlDump.exe trouvee
@echo =======================================================
@echo =======================================================
@echo Création du dump
@echo =======================================================
cd "C:\wamp64\bin\mysql\mysql5.7.14\bin"
mysqldump.exe -u root hotel --add-drop-table --skip-add-locks > %cheminProj%dump\dump_%isodate%_%t%.sql%
@echo =======================================================
@echo Dump OK
@echo =======================================================
pause
exit

:JOAN
@echo =======================================================
@echo MysqlDump.exe trouvee
@echo =======================================================
@echo =======================================================
@echo Création du dump
@echo =======================================================
cd "C:\xampp\mysql\bin"
mysqldump.exe -u root hotel --add-drop-table --skip-add-locks > %cheminProj%dump\dump_%isodate%_%t%.sql%
@echo =======================================================
@echo Dump OK
@echo =======================================================
pause
exit