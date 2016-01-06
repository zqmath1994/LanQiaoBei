
#include <stdio.h>

int main()
{
	// 注意问题：
	// 1. 输入的数据需要处理掉回车符
	// 2. 回车符在不同的操作系统不同\r, \r\n, \n
	// 3. 测试数据的最后一行，可能没有回车符 
	
	// 先读入一个整数，再读入2个串 
	int a;
	char b1[100];
	char b2[100];
	
	scanf("%d", &a);
	fgets(b1, sizeof(b1), stdin);
	fgets(b2, sizeof(b2), stdin);
	
	printf("a = %d\n", a);
	printf("b1 = %s\n", b1);
	printf("b2 = %s\n", b2);
		
	return 0;
}
