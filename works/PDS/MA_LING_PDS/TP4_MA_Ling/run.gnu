set title "Temps et vitesse d'execution"
set logscale x
set xlabel "taille du buffer"
set logscale y
set ylabel "temps en seconde"
set style data linespoints
plot "mcat-tm.dat" using 1:2 title "real", \
     "mcat-tm.dat" using 1:3 title "user", \
     "mcat-tm.dat" using 1:4 title "sys"
     
pause -1  "Hit return to continue"
