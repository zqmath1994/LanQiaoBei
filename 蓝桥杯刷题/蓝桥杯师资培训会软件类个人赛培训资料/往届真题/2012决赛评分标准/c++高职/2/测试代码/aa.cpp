
#include "stdio.h"


void sel_sort(int* x, int n)
{
	int k, i, m, t;
	for(k=0; k<n-1; k++)  // ¶àÌËÅÅÐò
	{
		m = k;                         // Ìî¿Õ1
		for(i=k+1; i<n; i++)
		{
			if(x[i] < x[m])  m = i;    // Ìî¿Õ2
		}

		t = x[k];
		x[k] = x[m];
		x[m] = t;
	}
}

void display(int* x, int n)
{
	for(int i=0; i<n; i++)  printf("%d ", x[i]);
	printf("\n");
}

void main()
{
	int N = 20;
	int a[] = {1, 10, 2, 11, 3, 12, 4, 18, 19, 13, 5, 20, 14, 6, 15, 7, 16, 8, 17, 9};
	display(a, N);
	sel_sort(a, N);
	display(a, N);
}