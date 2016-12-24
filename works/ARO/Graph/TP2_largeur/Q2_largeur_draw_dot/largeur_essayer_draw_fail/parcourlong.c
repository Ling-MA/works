#include<stdlib.h>
#include<stdio.h>
#include<string.h>

#include"graphe.h"
#include"sys/wait.h"

typedef enum {ROUGE=0,BLEU=1,VERT=2} tCouleur;
typedef tCouleur tTabCouleur[MAX_SOMMETS];

static tTabCouleur Sommet_couleur;

tTabCouleur parcour_largeur(tGraphe graphe,tNomSommet k){
  printf("nom de sommmet is %s\n",k);
  tNumeroSommet s;
  s=grapheChercheSommetParNom(graphe,k);
  printf(" numero sommet is %u\n",s);
  int nbSommet,i,file_vide;
  tFileSommets file;
  nbSommet=grapheNbSommets(graphe);
    for (i = 0; i < nbSommet; i++) {
      Sommet_couleur[i]=BLEU;
    }
    Sommet_couleur[s]=VERT;
    for (i = 0; i < nbSommet; i++) {
      tNomSommet nom1;
        grapheRecupNomSommet(graphe,i,nom1);
        printf("%u %s [%u]\n",i,nom1,Sommet_couleur[i]);
    }
  file=fileSommetsAlloue();
  fileSommetsEnfile(file,s);
  file_vide=fileSommetsEstVide(file);//1 is vide
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

  }
  return Sommet_couleur;
  fileSommetsLibere(file);
}

void visu_largeur(tGraphe graphe,FILE* fic,tTabCouleur Sommet_couleur){
  int nbSuccesseur, nbSommet, i, j;
  tNomSommet origine, destination;
  nbSommet = grapheNbSommets(graphe);
  fprintf(fic, "digraph{\n");

  for(i=0;i<nbSommet;i++){
    tNomSommet nom1;
    grapheRecupNomSommet(graphe,i,nom1);
    fprintf(fic,"%s [%u]\n",nom1,Sommet_couleur[i]);
     /*if(Sommet_couleur[i]==0){
      printf("%s [%s]\n",nom1,"ROUGE");}
      if(Sommet_couleur[i]==1){
        printf("%s [%s]\n",nom1,"BLEU");}
        if(Sommet_couleur[i]==2){
          printf("%s [%s]\n",nom1,"VERT");}*/
  }
  for(i = 0; i < nbSommet; i++) {
    nbSuccesseur = grapheNbSuccesseursSommet(graphe, i);
    grapheRecupNomSommet(graphe, i, origine);
    for(j = 0; j < nbSuccesseur; j++) {
      tNumeroSommet sucNum;
      sucNum = grapheSuccesseurSommetNumero(graphe, i, j);
      grapheRecupNomSommet(graphe, sucNum, destination);

      fprintf(fic, "%s -> %s [%u}\n", origine, destination);
    }
  }
  fprintf(fic, "}");
}

void graphe2visu(tGraphe graphe,char* outfile,tTabCouleur Sommet_couleur){
  FILE *fic;
  char commande[80];
  char dotfile[80];
  int ret;

  strcpy(dotfile,outfile);
  strcat(dotfile,".dot");
  fic=fopen(dotfile,"w");//fic is .ps

   if(grapheEstOriente(graphe)){printf("%s\n","error" );}
    else{visu_largeur(graphe,fic,Sommet_couleur);}
   fclose(fic);
   sprintf(commande,"dot -Tps %s -o %s",dotfile,fic);
   ret=system(commande);

}
int main(int argc, char* argv[]){
  tGraphe graphe;
  graphe=grapheAlloue();
  graphe=grapheChargeFicher(graphe,argv[1]);
  Sommet_couleur=parcour_largeur(graphe,argv[2]);
  graphe2visu(tGraphe graphe,"visu_largeur",Sommet_couleur);
  grapheLibere(graphe);
}
