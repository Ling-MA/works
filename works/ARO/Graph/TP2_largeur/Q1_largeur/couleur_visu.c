#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<unistd.h>
#include"graphe.h"
#include"sys/wait.h"

typedef enum {ROUGE=0,BLEU=1,VERT=2} tCouleur;
typedef tCouleur tTabCouleur[MAX_SOMMETS];

static tTabCouleur Sommet_couleur;


void visuNonOriente(tGraphe graphe, FILE *fic) {
  int nbSommet, nbVoisin, i, j;
  tNomSommet origine, destination;
  int grapheMat[MAX_SOMMETS][MAX_SOMMETS] = {0};

  nbSommet = grapheNbSommets(graphe);

  fprintf(fic, "graph{\n");
for(i = 0; i < nbSommet; i++){
 char s;
 
 grapheRecupNomSommet(graphe,i,s);	
}
  
  for(i = 0; i < nbSommet; i++) {
    nbVoisin = grapheNbVoisinsSommet(graphe, i);
    grapheRecupNomSommet(graphe, i, origine);
    for(j = 0; j < nbVoisin; j++) {
      tNumeroSommet voiNum;
      voiNum = grapheVoisinSommetNumero(graphe, i, j);
      grapheRecupNomSommet(graphe, voiNum, destination);

      grapheMat[voiNum][i] = 1;

      if(grapheMat[i][voiNum] == 0) fprintf(fic, "%s -- %s\n", origine, destination);
    }
  }
  fprintf(fic, "}");
}

void graphe2visu(tGraphe graphe,char *outfile) {
  FILE *fic;
  char commande[80];
  char dotfile[80];
  int ret;

  strcpy(dotfile, outfile);
  strcat(dotfile, ".dot");
  fic = fopen(dotfile, "w");

  //if(fic == NULL)
    //halt("Ouverture du fichier %s en ecriture impossible\n", dotfile);

//  if(grapheEstOriente(graphe)) visuOriente(graphe, fic);
  visuNonOriente(graphe, fic);

  fclose(fic);

  sprintf(commande, "dot -Tps %s -o %s", dotfile, outfile);
  ret = system(commande);
  if(WEXITSTATUS(ret)) {
   // halt("La commande suivante a échoué\n%s\n", commande);
  }
}

int main(int argc, char *argv[]) {
  tGraphe graphe;

  if(argc <2) {
    halt("Usage : %s FichierGraphe");
  }

  graphe = grapheAlloue();
  grapheChargeFichier(graphe, argv[1]);
  graphe2visu(graphe, "visu_no");
  grapheLibere(graphe);

  return 0;
}






void parcour_largeur(tGraphe graphe,tNomSommet k){
  tNumeroSommet s;
  s=grapheChercheSommetParNom(graphe,k);
  int nbSommet,i,file_vide;
  tFileSommets file;
  nbSommet=grapheNbSommets(graphe);
    for (i = 0; i < nbSommet; i++) {
      Sommet_couleur[i]=BLEU;
    }
    Sommet_couleur[s]=VERT;
	//affichage
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
	//affichage
        fileSommetsEnfile(file,y);
      }
    }

    Sommet_couleur[x]=ROUGE;
//affichage
   for(i=0;i<nbSommet;i++){
          tNomSommet nom1;
          grapheRecupNomSommet(graphe,i,nom1);

        if(Sommet_couleur[i]==0){
            printf("%s [%s]\n",nom1,"ROUGE");}
            if(Sommet_couleur[i]==1){
              printf("%s [%s]\n",nom1,"BLEU");}
              if(Sommet_couleur[i]==2){
                printf("%s [%s]\n",nom1,"VERT");}
          //printf("%s [%u]\n",nom1,Sommet_couleur[i]);//methode affichier 2
    }
  }
  fileSommetsLibere(file);
  return;
}

void visu_largeur(tGraphe graphe,FILE* fic){
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

      fprintf(fic, "%s -> %s \n", origine, destination);
    }
  }
  fprintf(fic, "}");
}

void graphe2visu(tGraphe graphe,char* outfile){
  FILE *fic;
  char commande[80];
  char dotfile[80];

  strcpy(dotfile,outfile);
  strcat(dotfile,".dot");
  fic=fopen(dotfile,"w");//fic is .ps

   if(grapheEstOriente(graphe)){printf("%s\n","error" );}
    else{visu_largeur(graphe,fic);}
   fclose(fic);
   sprintf(commande,"dot -Tps %s -o %s",dotfile,outfile);
   system(commande);

}
int main(int argc, char* argv[]){
  tGraphe graphe;
  graphe=grapheAlloue();
  grapheChargeFichier(graphe,argv[1]);
  parcour_largeur(graphe,argv[2]);
  sleep(5000);
//  Sommet_couleur[1];
  //graphe2visu(graphe,"visu_largeur");
  grapheLibere(graphe);
}
