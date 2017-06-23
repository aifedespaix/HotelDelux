color 02
@echo =======================================================
@echo Veuillez saisir le chemin du  de wampp,xampp ou easyphp
@echo =======================================================
set /p chemin=
set cheminProj=%~dp0
cd "%chemin%"
SET isodate=%DATE:~6,4%%DATE:~3,2%%DATE:~0,2%
set t=%time:~0,8%
rem replace colons with dashes
set t=%t::=-%
mysqldump.exe -u root hotel > %cheminProj%dump\dump_%isodate%_%t%.sql