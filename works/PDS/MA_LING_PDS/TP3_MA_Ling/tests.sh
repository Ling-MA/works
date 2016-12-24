#! /bin/sh
make mtail1
make mtail2
make mtail3
echo"***************************tail -n25 fichier toto.txt a plus de 25 lignes************************************"
# test mtail1.c
./mtail1
echo "**************************tail les fichier moins de 25ligns**************************************"
# test mtail2.c
./mtail2
echo "****************************tail un autre fichiers sauf xxx.txt*********************************************"
#test mtail3.c
./mtail3
