#! /bin/sh
make multif
make race
make observation
echo "-------------------test multif-------------------------------"
# test multif.c
./multif
echo"--------------------test race----------------------------------"
# test race.c
./race
echo"-------------------test observation----------------------------"
#test observation
./observation
make clean
