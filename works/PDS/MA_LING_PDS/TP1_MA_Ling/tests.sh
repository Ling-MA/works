#! /bin/sh

# test Makefile
#complier prlimit.c
make prlimit
#complier maccess.c
make maccess
#complier maccess+.c
make maccess2

# test prlimit
./prlimit

# test option lecture maccess
./maccess -r

# text option écriture maccess 
./maccess -w
 
# test option execution maccess
./maccess -x

# test option existence maccess
./maccess -f

#test option erreur maccess
./maccess -v

# test option lecture maccess+
./maccess+ -r maccess+.c

# text option écriture maccess+
./maccess+ -w maccess+.c

# test option execution maccess+
./maccess+ -x maccess+.c

# test option existence maccess+
./maccess+ -f maccess+.c

# test option erreur maccess+
./maccess+ -v maccess+.c
# clean my file maccess maccess+ prlimit
make clean
