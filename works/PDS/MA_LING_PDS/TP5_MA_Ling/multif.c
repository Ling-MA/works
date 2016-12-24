#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<unistd.h>
#include <sys/wait.h>

typedef int (*MUL)(int);
MUL fun[256];
int status;

int multif(int (*MUL)(int),int* args,int n){
	int i=0;

	fflush(stdout);

	for(i;i<n;i++){
		if((fork())==0){
			fun[i](args[i]);
			exit(EXIT_SUCCESS);
		}
		else{
		   
		}
	}
	for (i = 0; i < n ; i++){
		wait(&status)==-1;
		if(WIFEXITED(status)){
			printf("one processuse is finished!\n");
		}else{
			printf("Failure\n");
		}	
	}
	printf("All the processuses are finished!\n");
	return 0;
}

int f(int len){

	sleep(len);
	fprintf(stderr,"Fonction executee par le processus %d\n it has sleeped for %d sec\n",getpid(),len);

	return status;
}

int main(int argc,int* argv){
	int arrlen;
	int *str;
	int i;
	//printf("How many processus you want:");je ne sais pas comment rajouter arrlen comme on veut par les users dans shell... 
	//scanf("%d",&arrlen);
        arrlen=10;//si on va tester n processuss, on le suprime.
	str=(int*)malloc(arrlen*sizeof(int));
	for(i=0;i<arrlen;i++){
		str[i]=i+1;
		fun[i]=f;
	}

	
        //multif(fun[i],str,arrlen);//ca marche, mais on doit test 10 processue,donc on le met en commentaire
	multif(fun[i],str,10);
}


