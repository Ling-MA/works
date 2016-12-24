#! /bin/sh

# test Makefile
#complier mdu.c
make mdu
#test mdu.c
./mdu -b taille
#clean mdu
make clean
