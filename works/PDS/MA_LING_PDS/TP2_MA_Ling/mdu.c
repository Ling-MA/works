#include <stdio.h> 
#include <string.h>
#include <stdlib.h> 
#include <dirent.h> 
#include <sys/stat.h> 
#include <unistd.h> 
#include <sys/types.h>
#include <limits.h>

int du_file(char *path) 
{ 
    DIR *pDir ; 
    struct dirent *ent  ; 
    
    int taille=0;
    struct stat st;
    
    pDir=opendir(path); 

    char* childpath=(char*)malloc(sizeof(char*)*(PATH_MAX)); 
    int status=lstat(path,&st);
    taille+=st.st_size;//ajout de la taille de l'entete du dossier courant que je vais parcourir
    printf(" %s size:%ld \n",path,st.st_size);
    while((ent=readdir(pDir))!=NULL) 
    { 
	
        if(ent->d_type & DT_DIR) 
        { 

            if(strcmp(ent->d_name,".")==0 || strcmp(ent->d_name,"..")==0) 
                    continue; 

            sprintf(childpath,"%s/%s",path,ent->d_name);

            taille+=du_file(childpath); //ajout de la taille du sous dossier
          
        } 
            else if(ent->d_type&DT_REG)
	   {

			sprintf(childpath,"%s/%s",path,ent->d_name);
                    int status=lstat(childpath,&st);//afin de récupérer la taille
                    taille+=st.st_size;//ajout de la taille du fichier
			printf(" %s size:%d \n",path,taille);
                    
	   }
        else if (ent->d_type&DT_LNK){
            sprintf(childpath,"%s/%s",path,ent->d_name);
            int status=lstat(childpath,&st);
            
            taille+=st.st_size;//ajout de la taille du lien
            //printf(" %s siz:%ld \n",childpath,st.st_size);
                    
	   }
           
    } 
    return taille;
 
} 

 
int main(int argc,char **argv) 
{   
     
    int size;  
    int opt;
    while((opt = getopt(argc, argv, "b:B:")) != -1){
        switch(opt){

            case'b':size=du_file("taille");
                    printf("taille final : %d\n",size); 
		    break;
            
            default: printf("No such an option.");
                return 0;
}}
          
            
         

 
} 
