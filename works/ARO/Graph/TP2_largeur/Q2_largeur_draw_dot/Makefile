
CC = gcc

## Options pour la compilation du C
#CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99


all: largeur test

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

largeur:largeur.c graphe.c
	${CC} -Wall -g -std=c99 largeur.c graphe.c -o largeur
test:largeur ex-no.grp
	./largeur ex-no.grp A

.PHONY: all clean

clean:
	rm -f *.o *~ largeur
