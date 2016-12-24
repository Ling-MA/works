set title "Temps et vitesse d'execution"
set logscale x
set xlabel "taille du buffer"
set logscale y
set ylabel "temps en seconde"
set style data linespoints
plot "mcat-tm.dat" using 1:2 title "duree",\
     "mcat-tm.dat" using 1:3 title "vitesse"
     
pause -1  "Hit return to continue"
