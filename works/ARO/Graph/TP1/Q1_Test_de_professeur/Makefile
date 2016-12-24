
CC = gcc

## Options pour la compilation du C
#CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99


all: testAnalyseur test

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

testAnalyseur:testAnalyseur.c graphe.c
	${CC} -Wall -g -std=c99 testAnalyseur.c graphe.c -o testAnalyseur

test:testAnalyseur ex-no.grp ex-oo.grp
	./testAnalyseur ex-no.grp
	./testAnalyseur ex-oo.grp


.PHONY: all clean

clean:
	rm -f *.o *~ testAnalyseur
