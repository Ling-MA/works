#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<unistd.h>
int main(int argc,char **argv){

float nbr=atoi(argv[3]);
//int taille=atoi(getenv("MCAT_BUFSIZ"));
//char *tampon=(char*)malloc(taille*sizeof(char));
float div=1/nbr;
fprintf(STDOUT_FILENO,%f,div);
//write(STDOUT_FILENO,tampon,div);
//free(tampon);
return 0;
}
