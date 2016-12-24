
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "graphe.h"

int main(int argc, char *argv[]) {

  tGraphe graphe;
  //tNumberoSommet sommet;
  int i;
  int count;
  if (argc<2) {
    halt("Usage : %s FichierGraphe\n", argv[0]);
  }


  graphe = grapheAlloue();

  grapheChargeFichier(graphe,  argv[1]);
  count = grapheNbSommets(graphe);
  for (i = 0; i < count; i++) {
    if(grapheNbVoisinsSommet(graphe,i)==0){
      tNomSommet s;
      grapheRecupNomSommet(graphe, i, s);
      printf("%s\n", s);
    }
  }
  //grapheAffiche(graphe);
  grapheLibere(graphe);

  exit(EXIT_SUCCESS);
}
