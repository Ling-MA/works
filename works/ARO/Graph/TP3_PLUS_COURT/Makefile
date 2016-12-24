
CC = gcc

## Options pour la compilation du C
#CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99


all:d test

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

d:d.c graphe.c
	${CC} -Wall -g -std=c99 d.c graphe.c -o d
test:d ex-no.grp
	./d ex-no.grp C
ps:visu.dot
	dot -Tps visu.dot -o visu.ps

.PHONY: all clean

clean:
	rm -f *.o *~  d visu couleur_visu  *.dot *.ps
