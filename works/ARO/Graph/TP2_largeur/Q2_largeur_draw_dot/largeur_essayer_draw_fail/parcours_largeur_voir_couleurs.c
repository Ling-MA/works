#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include"graphe.h"
/* Couleurs */
typedef enum {ROUGE=0, BLEU=1, VERT=2} tCouleur;
typedef tCouleur tTabCouleurs[MAX_SOMMETS];

static tTabCouleurs Sommet_couleur;

void parcour_largeur(tGraphe graphe,tNomSommet k){
  //printf("nom de sommmet is %s\n",k);
  tNumeroSommet s;
  s=grapheChercheSommetParNom(graphe,k);
//  printf(" numero sommet is %u\n",s);
  int nbSommet,i,file_vide;
  tFileSommets file;
  nbSommet=grapheNbSommets(graphe);
    for (i = 0; i < nbSommet; i++) {
      Sommet_couleur[i]=BLEU;
    }
    Sommet_couleur[s]=VERT;
  /*  for (i = 0; i < nbSommet; i++) {
      tNomSommet nom1;
        grapheRecupNomSommet(graphe,i,nom1);
        printf("%u %s [%u]\n",i,nom1,Sommet_couleur[i]);
    }*/
  file=fileSommetsAlloue();
  fileSommetsEnfile(file,s);
  file_vide=fileSommetsEstVide(file);//1 is vide
  /*printf("%d\n",file_vide );
  tNumeroSommet b;
  b=fileSommetsDefile(file);
  printf("%u\n hahhahahah",b);*/

  while(file_vide!=1){
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
    /*for(i=0;i<nbSommet;i++){
      tNomSommet nom1;
      grapheRecupNomSommet(graphe,i,nom1);

    if(Sommet_couleur[i]==0){
        printf("%s [%s]\n",nom1,"ROUGE");}
        if(Sommet_couleur[i]==1){
          printf("%s [%s]\n",nom1,"BLEU");}
          if(Sommet_couleur[i]==2){
            printf("%s [%s]\n",nom1,"VERT");}}*/  //voir leurs couleur
      //printf("%s [%u]\n",nom1,Sommet_couleur[i]);//voir leurs vouleurs 2
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
