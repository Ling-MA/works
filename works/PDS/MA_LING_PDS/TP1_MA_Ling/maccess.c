#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc,char **argv){
    int i=argc;
while(i-->0){
	if(argv[i][0]=='-'){
            switch(argv[i][1]){
                case'r':
                
                    if(access(argv[0],R_OK)==0){
                        printf("READ OK.\n");
                    }else{
                        printf("CAN NOT READ.\n");
                    }break; 

                case'w':
                
                    if(access(argv[0],W_OK)==0){
                        printf("WRITE OK.\n");
                    }else{
                        printf("CAN NOT WRITE.\n");
                    }break; 

                case'x':
                
                    if(access(argv[0],X_OK)==0){
                        printf("EXECUTE OK.\n");
                    }else{
                        printf("CAN NOT EXECUTE.\n");
                    }break; 

                case'f':
                
                    if(access(argv[0],F_OK)==0){
                        printf("EXIST.\n");  
                    }else{printf("NOT EXIST.\n");}
                    break;
                default: printf("No such an option.\n");
          }
    }
}
return 0;
}

