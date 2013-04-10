#!/bin/bash

#generate the jar tool used to compile the programs
make -C compiler

#set an environment variable with the path of the compiler code/tools
folder=$PWD"/compiler"
export CMTJAVAC=$folder

