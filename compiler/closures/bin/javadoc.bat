@echo off
rem find javadoc.exe on path
for %%A in (javadoc.exe) do set JAVADOC=%%~$PATH:A
rem find CLOSURES root directory which is this script's directory's parent dir
for %%A in ("%~dp0..") do set CLOSURES=%%~fA
rem run it
"%JAVADOC%" -J-Xbootclasspath/p:"%CLOSURES%\lib\closures.jar" -source 7 -d . %*
