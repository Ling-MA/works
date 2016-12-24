
CC = gcc

## Options pour la compilation du C
#CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99

all:visu_no visu_o test draw
%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

visu_no:visu_no.c graphe.c
	${CC} -Wall -g -std=c99 visu_no.c graphe.c -o visu_no

visu_o:visu_o.c graphe.c
	${CC} -Wall -g -std=c99 visu_o.c graphe.c -o visu_o	

test:visu_no visu_o ex-no.grp ex-oo.grp 
	./visu_no ex-no.grp
	./visu_o ex-oo.grp
draw:visu_no.dot visu_o.dot
	dot -Tps visu_no.dot -o visu_no.ps
	dot -Tps visu_o.dot -o visu_o.ps

.PHONY: all clean

clean:
	rm -f *.o *~ testAnalyseur visu_no visu_o *.ps *.dot
