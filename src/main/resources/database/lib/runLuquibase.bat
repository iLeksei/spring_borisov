call java -Duser.language=en -classpath ../lib/ojdbs6.jar;../lib/liquibase-core.3.2.2.jar liquibase.integration.commandline.Main ^
--changeLogFile=%1 ^
--logFile=%2 ^
update %3 %4 %5 %6 %7 %8 %9
