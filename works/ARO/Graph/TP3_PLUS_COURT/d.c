#include <stdlib.h>
#include <stdio.h>
#include<string.h>
#include "graphe.h"

static int d[MAX_SOMMETS];
static tNumeroSommet pred[MAX_SOMMETS];

typedef enum {ROUGE=0,BLEU=1,VERT=2} tCouleur;
typedef tCouleur tTabCouleur[MAX_SOMMETS];

static tTabCouleur couleur;
void plusCourteChaine(tGraphe graphe, tNumeroSommet sommet) {
	int nbSommet, i;
	tFileSommets file;
	nbSommet = grapheNbSommets(graphe);

	for (i = 0; i < nbSommet; ++i) {
		couleur[i] = BLEU;
	}
  couleur[sommet] = VERT;
	file = fileSommetsAlloue();

	d[sommet] = 0;
	pred[sommet] = -1;
  fileSommetsEnfile(file, sommet);

	while(!fileSommetsEstVide(file)) {
		tNumeroSommet x, y;
		int nbVoisin;
		x = fileSommetsDefile(file);
		nbVoisin = grapheNbVoisinsSommet(graphe, x);
		for(i = 0; i < nbVoisin; i++) {
			y = grapheVoisinSommetNumero(graphe, x, i);
			if(couleur[y] == BLEU) {
				couleur[y] = VERT;
				fileSommetsEnfile(file, y);
				d[y] = d[x] + 1;
				pred[y] = x;
			}
		}
		couleur[x] = ROUGE;

	}
	for(i = 0; i < nbSommet; i++) {
		tNomSommet nom;
		grapheRecupNomSommet(graphe, i, nom);
		printf("%s | %d | %d\n", nom, d[i], (int)pred[i]);
	}
	fileSommetsLibere(file);


}


int main(int argc, char const *argv[])
{
	tGraphe graphe;
	tNumeroSommet s;

	graphe = grapheAlloue();
	grapheChargeFichier(graphe, argv[1]);
	s = grapheChercheSommetParNom(graphe, argv[2]);

	plusCourteChaine(graphe, s);
	grapheLibere(graphe);

	printf("\n");

	return 0;
}
