#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {


	pid_t pid[3];
	int flag=0;
	int wstatus;
	int fd[2];

	int retn=pipe(fd);

	if(retn<0) {
		printf("Pipe creation failed.");
		return -2;
	}
	for(int i=0;i<3;i++) {
		pid[i]=fork();
		if(pid[i]<0) {
			printf("Process creation failed");
		}
		if(pid[i]>0) {
			flag=1;
			break;
		}
		if(pid[i]==0) {
			 printf("this is child\n");
                        printf("child pid =  %d and pid of parent ppid = %d\n", getpid(), getppid());
			if(i==0) {
				 char  str1[100];
               			 close(fd[0]);

               			 printf("Enter your First Name\n");
               			 scanf("%s", str1);

               			 write(fd[1], str1, strlen(str1)+1);
              			  close(fd[1]);
				}
			if(i==1) {
				 char str2[100];
		                close(fd[0]);

                		printf("Enter your Last Name\n");
               			 scanf("%s", str2);

               			 write(fd[1], str2, strlen(str2)+1);
               			 close(fd[1]);
				}
			if(i==2) {
				char str3[100];
				  close(fd[1]);
                		read(fd[0], str3, sizeof(str3));
                		printf("Child : %s\n", str3);
               			 close(fd[0]);
				}

				 flag=0;
                        sleep(1);

			}
		}
		  if(flag==1){
                printf("this is parent\n");
                sleep(4);
        }
               waitpid(-1,&wstatus,0);
                if (wstatus==WEXITED){
                        printf("Wait for children that have terminated\n");
                }
                if(WIFEXITED(wstatus)){
                        printf("Child exited normally\n");
                }

        return 0;




}
