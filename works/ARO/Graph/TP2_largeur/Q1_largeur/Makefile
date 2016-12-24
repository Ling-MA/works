
CC = gcc

## Options pour la compilation du C
#CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99


all:couleur_visu test

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

couleur_visu:couleur_visu.c graphe.c
	${CC} -Wall -g -std=c99 couleur_visu.c graphe.c -o couleur_visu
test:couleur_visu ex-no.grp
	./couleur_visu ex-no.grp C
ps:visu.dot
	dot -Tps visu.dot -o visu.ps

.PHONY: all clean

clean:
	rm -f *.o *~ visu couleur_visu  *.dot *.ps
