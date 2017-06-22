@echo =======================================================
@echo Veuillez saisir le chemin du  de wampp,xampp ou easyphp
@echo =======================================================
set /p chemin=
set chemin_proj=%~dp0
set user = %username%
cd "%chemin%"
rem CACLS %chemin_proj%dump /E /G "%user%":W
lcacls %chemin_proj%dump  /grant %user%:(d,W)
mysqldump.exe -u root --opt hotel -h locaC:\wamp64\bin\mysql\mysql5.7.14\binlhost --result-file=%chemin_proj%dump\dump_%date%_%time%.sql