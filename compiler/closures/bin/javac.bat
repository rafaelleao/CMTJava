@echo off
rem find javac.exe on path
for %%A in (javac.exe) do set JAVAC=%%~$PATH:A
rem find CLOSURES root directory which is this script's directory's parent dir
for %%A in ("%~dp0..") do set CLOSURES=%%~fA
rem run it
"%JAVAC%" -J-Xbootclasspath/p:"%CLOSURES%\lib\closures.jar" -source 7 -d . %*
