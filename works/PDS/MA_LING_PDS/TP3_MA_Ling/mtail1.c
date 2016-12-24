#include<stdio.h>
#include<unistd.h>
#include<string.h>
int getLine(char *path, int total){
    FILE *fp;  
    char buffer[1024];  
   // int bLength;  I once used it to fix length,but I failed and fogget to delete it.  
   
    if((fp=fopen(path, "r")) == NULL){
       // perror(path);//perror(fopen)
        return -1;
    }
    while(fgets(buffer, 1024, fp) != NULL){
     //   bLength = strlen(buffer); 
        total++;  
    }
    return total;
}



int main(){
	char path[30];
	int total;
	//printf("Input file name: "); 
	//scanf("%s", path);
        //je suprimer les lignes parce-que je ne sais pas comment on peut rajouter le nom du fichier par input dans /le //shells.....
	FILE *fp=fopen("toto.txt","r");
	int a=getLine(path,total);
	char str[1024];
	for(int i=0;i<(a-25);i++){
		fgets(str,sizeof(str),fp);
	}
	for(int i=a-25;i<=a;i++){
		if(!feof(fp)){
			fgets(str,sizeof(str),fp);
			printf("%s",str);
		}else{}
	}
	fclose(fp);
	return 0;

}

