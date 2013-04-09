#!/bin/bash

echo 
"***************
Compiling CMTJava
**************"
make -C src/stm/

echo "Compiling samples"
make -C src/test/DinningPhilosopher/
make -C src/test/RedBlackTree/
make -C src/test/LinkedList/
make -C src/test/Account/

