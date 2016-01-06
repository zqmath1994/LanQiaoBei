
#include <stdio.h>

int len(const char* s)
{
	if(*s==0) return 0;
	return 1 + len(s+1);
}

int main()
{
	int n = len("abcd");
	printf("%d\n", n);
	return 0;
}
