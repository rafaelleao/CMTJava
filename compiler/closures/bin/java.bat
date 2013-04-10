@echo off
rem find java.exe on path
for %%A in (java.exe) do set JAVA=%%~$PATH:A
rem find CLOSURES root directory which is this script's directory's parent dir
for %%A in ("%~dp0..") do set CLOSURES=%%~fA
rem run it
"%JAVA%" -Xbootclasspath/p:"%CLOSURES%\lib\closures.jar" %*
