
#include <stdio.h>
#include <string.h>

/*
  回车的处理方法
  1. 末尾可能有回车，可能没有
  2. 有回车，可能是不同的符号：
     windows  \r\n
	 iOS  \r
	 *nuix \n
     
*/

int main()
{
	// 先读入一个整数，再读入2个串 
	int a;
	char b1[100];
	char b2[100];
	
	scanf("%d\n", &a);
	fgets(b1, sizeof(b1), stdin);
	fgets(b2, sizeof(b2), stdin);
	
	printf("a = %d\n", a);
	printf("b1 = %s\n", b1);  //串中含有\n，可能需要去掉 
	printf("b2 = %s\n", b2);
		
		
	return 0;
}
