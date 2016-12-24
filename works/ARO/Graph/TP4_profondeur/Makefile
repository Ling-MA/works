
CC = gcc

## Options pour la compilation du C
#CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99


all:profondeur test

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

profondeur:profondeur.c graphe.c
	${CC} -Wall -g -std=c99 profondeur.c graphe.c -o profondeur
test:profondeur ex-no.grp
	./profondeur ex-no.grp A

.PHONY: all clean

clean:
	rm -f *.o *~  profondeur
