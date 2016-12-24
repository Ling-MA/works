#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include"graphe.h"
/* Couleurs */
typedef enum {ROUGE=0, BLEU=1, VERT=2} tCouleur;
typedef tCouleur tTabCouleurs[MAX_SOMMETS];

static tTabCouleurs Sommet_couleur;

void parcour_largeur(tGraphe graphe,tNomSommet k){

  tNumeroSommet s;
  s=grapheChercheSommetParNom(graphe,k);

  int nbSommet,i;
  tFileSommets file;
  nbSommet=grapheNbSommets(graphe);
    for (i = 0; i < nbSommet; i++) {
      Sommet_couleur[i]=BLEU;
    }
    Sommet_couleur[s]=VERT;

  file=fileSommetsAlloue();
  fileSommetsEnfile(file,s);

  while(!fileSommetsEstVide(file)){
    tNumeroSommet x;
    tNomSommet nom;
    int nbVoisin;
    x=fileSommetsDefile(file);
    grapheRecupNomSommet(graphe,x,nom);
    printf("%s\n",nom);
    nbVoisin=grapheNbVoisinsSommet(graphe,x);
    for (i = 0; i < nbVoisin; i++) {//i est numero de voisin
      tNumeroSommet y;
      y=grapheVoisinSommetNumero(graphe,x,i);//x est le sommet nous le focus on
      if(Sommet_couleur[y]==BLEU){
        Sommet_couleur[y]=VERT;
        fileSommetsEnfile(file,y);
      }
    }

    Sommet_couleur[x]=ROUGE;
  }
  fileSommetsLibere(file);
}



int main(int argc, char* argv[]){
  tGraphe graphe;
  if(argc<3){
    halt("Usage : %s FichierGraphe");
  }
  graphe=grapheAlloue();
  grapheChargeFichier(graphe,argv[1]);
  parcour_largeur(graphe,argv[2]);
  grapheLibere(graphe);
}
