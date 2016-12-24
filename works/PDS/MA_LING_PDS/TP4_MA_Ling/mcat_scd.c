#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<unistd.h>
int main(int argc,char **argv){

int nbr;
int taille=atoi(getenv("MCAT_BUFSIZ"));
char *tampon=(char*)malloc(taille*sizeof(char));
int fd=open(argv[1],O_RDONLY); 
while((nbr=read(fd,tampon,taille)) > 0){ 
	write(STDOUT_FILENO,tampon,nbr);
}
free(tampon);
close(fd);
return 0;}
