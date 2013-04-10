#!/bin/bash

echo "*****************"
echo "Compiling CMTJava"
echo "*****************"
make -C src/stm/

echo "*****************"
echo "Compiling samples"
echo "*****************"
make -C src/test/DinningPhilosopher/
make -C src/test/RedBlackTree/
make -C src/test/LinkedList/
make -C src/test/Account/

