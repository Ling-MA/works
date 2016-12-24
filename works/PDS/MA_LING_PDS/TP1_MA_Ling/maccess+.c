#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <getopt.h> 

int main(int argc, char **argv)
{
    char* path = (char*)malloc(sizeof(char)*256);
    
    int opt;
    while((opt = getopt(argc, argv, "r:w:x:f:")) != -1){
        switch(opt){

            case'r':
                strcpy(path, optarg);
                if(access(path,R_OK)==0){
                    printf("File can be read.\n");
                }else{
                    printf("File can not be read.\n");
                }break; 

            case'w':
                strcpy(path, optarg);
                if(access(path,W_OK)==0){
                    printf("File can be written.\n");
                }else{
                    printf("File can not be writen.\n");
                }break; 

            case'x':
                strcpy(path, optarg);
                if(access(path,X_OK)==0){
                    printf("File can be executed.\n");
                }else{
                    printf("File can not be executed.\n");
                }break; 

            case'f':
                strcpy(path, optarg);
                if(access(path,F_OK)==0){
                    printf("This file is exist,enter another to test this fonction.\n");  
                }else{printf("ERROR:This file is not exist.\n");}
                break; 

            default: printf("No such an option.");
                return 0;}

    }

   
}
