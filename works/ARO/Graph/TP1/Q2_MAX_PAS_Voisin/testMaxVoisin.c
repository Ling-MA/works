
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "graphe.h"

int main(int argc, char *argv[]) {

  tGraphe graphe;
  //tNumberoSommet sommet;
  int i;
  int count;
  int voisin[100];
  int max;
  if (argc<2) {
    halt("Usage : %s FichierGraphe\n", argv[0]);
  }


  graphe = grapheAlloue();

  grapheChargeFichier(graphe,  argv[1]);
  count = grapheNbSommets(graphe);
  for (i = 0; i < count; i++) {
    voisin[i]=grapheNbVoisinsSommet(graphe,i);
  }
  for (i = 0; i < count; i++) {
  printf("%d\n", voisin[i]);
  }
  max=voisin[0];
  for (i=1;i <count;i++){
  if(max<voisin[i]){
    max=voisin[i];
  }
  else{}
  }
  printf("%d\n",max);
  for (i = 0; i < count; i++) {
     if (max==voisin[i]) {
       tNomSommet s;
       grapheRecupNomSommet(graphe,i,s);
       printf("%s\n",s);
     }
  }
  //grapheAffiche(graphe);
  grapheLibere(graphe);

  exit(EXIT_SUCCESS);
}
