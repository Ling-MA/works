#! /bin/sh -uf
#
# mcat -- campagne d'appels a mcat-scd
#
# squelette de shell script

# make mcat_scd from mcat_scd.c
make mcat_scd
make calculer
# La commande a tester
MCAT=./mcat_scd
MCAL=./calculer
# Le fichier de temps a generer
TIME_FILE=mcat-tm.dat

# la commande gnu time
TIME_CMD="/usr/bin/time"
# les options de cette commande
OPT="-f"
TIME_OPT="%e"

#TIME_OPT="-f %e %U %S"

#initialisation du fichier en entree
dd if=/dev/zero of=100Mo bs=1k count=100k

# initialisation du fichier de résultats
rm -f $TIME_FILE && echo "# duree vitesse" > $TIME_FILE


# boucle pour le time
for size in `awk 'BEGIN { for( i=1; i<=8388608; i*=2 ) print i }'`; do
    export MCAT_BUFSIZ=$size
    echo $MCAT_BUFSIZ
    printf "$MCAT_BUFSIZ " >> $TIME_FILE
    $TIME_CMD $OPT "$TIME_OPT" $MCAT "100Mo"  > /dev/null 2>> $TIME_FILE
    $MCAL $TIME_CMD $OPT "$TIME_OPT" $MCAT "100Mo"> /dev/null 2>> $TIME_FILE
done
#printf "mcat_scd"
#$TIME_CMD "$TIME_OPT" ./mcat_scd "100Mo"  > /dev/null

gnuplot run.gnu
set term png
set output "mcat_scd.png"

# un exemple de redirection des sorties standard et d'erreur
$TIME_CMD "$TIME_OPT" ls > /dev/null 2>> $TIME_FILE

# eof

rm 100Mo
rm mcat_scd
