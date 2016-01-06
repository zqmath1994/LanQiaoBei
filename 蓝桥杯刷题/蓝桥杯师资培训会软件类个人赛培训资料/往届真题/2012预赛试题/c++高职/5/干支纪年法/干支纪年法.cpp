// 干支纪年法.cpp : Defines the entry point for the console application.
//


/*
  十天干，十二地支
  60年一个大循环


*/


#include "stdafx.h"

void f(int year)
{
	char* x[] = {"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
	char* y[] = {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
	
	int n = year - 1984;
	while(n<0) n += 60;
	printf("%s%s\n", x[n%10], y[n%12]);  // 填空1，2
}

int main(int argc, char* argv[])
{
	f(1911);
	f(1970);
	f(2012);
	return 0;
}

