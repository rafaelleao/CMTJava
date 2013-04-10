#!/bin/bash

if [ -z "$CMTJAVAC" ]; then
    echo "Please run this command first:"
    echo "$ . ./install.sh" 
    exit 1
fi  

compiler=$CMTJAVAC/cmtjava
parameters="-ea -cp build"

echo "Testing Account"

echo "Test 1"
$compiler $parameters test.Account.Test 1 10
echo "Test 2"
$compiler $parameters test.Account.Test 2 10
echo "Test 3"
$compiler $parameters test.Account.Test 2 100
echo "Test 4"
$compiler $parameters test.Account.Test 4 1000
echo "Test 5"
$compiler $parameters test.Account.Test 4 10000
echo "Test 6"
$compiler $parameters test.Account.Test 10 20000
echo "Test 7"
$compiler $parameters test.Account.Test 10 50000

echo "Testing LinkedList"

echo "Test 1"
$compiler $parameters -Xss100M test.LinkedList.Test 2 100
echo "Test 2"
$compiler $parameters -Xss100M test.LinkedList.Test 4 1000
echo "Test 3"
$compiler $parameters -Xss100M test.LinkedList.Test 6 1000
echo "Test 4"
$compiler $parameters -Xss100M test.LinkedList.Test 2 10000

echo "Testing RedBlackTree"

echo "Test 1"
$compiler $parameters -Xss100M test.RedBlackTree.Test 20 2 2
echo "Test 2"
$compiler $parameters -Xss100M test.RedBlackTree.Test 20 2 1000
echo "Test 3"
$compiler $parameters -Xss100M test.RedBlackTree.Test 10 8 10000
echo "Test 4"
$compiler $parameters -Xss100M -Xmx100M test.RedBlackTree.Test 2 16 10000
