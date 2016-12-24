
CC = gcc

## Options pour la compilation du C
#CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99

all: testPasVoisin testMaxVoisin test
%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

testPasVoisin:testPasVoisin.c graphe.c
	${CC} -Wall -g -std=c99 testPasVoisin.c graphe.c -o testPasVoisin
testMaxVoisin:testMaxVoisin.c graphe.c
	${CC} -Wall -g -std=c99 testMaxVoisin.c graphe.c -o testMaxVoisin 
test:testPasVoisin ex-no.grp
	./testPasVoisin ex-no.grp
	./testMaxVoisin ex-no.grp

       
.PHONY: all clean

clean:
	rm -f *.o *~ testPasVoisin testMaxVoisin
