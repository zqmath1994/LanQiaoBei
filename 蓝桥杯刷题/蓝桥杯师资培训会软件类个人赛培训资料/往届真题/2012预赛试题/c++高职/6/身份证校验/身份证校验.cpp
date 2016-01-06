// 身份证校验.cpp : Defines the entry point for the console application.
//

/*
  如果让你设计个程序，用什么变量保存身份证号码呢？长整数可以吗？不可以！
  因为有人的身份证最后一位是"X"
  实际上，除了最后一位的X，不会出现其它字母！

  身份证号码18位 = 17位 + 校验码

  校验码的计算过程：

  例如：身份证前17位 = ABCDEFGHIJKLMNOPQ
  
  A~Q 每位数字乘以权值求和 17位对应的权值分别是：

  7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2

  求和数字对11求模

  然后按下表映射：

  余数     0   1   2   3   4   5   6   7   8   9   10 
  校验码： 1   0   X   9   8   7   6   5   4   3   2 

*/


#include "stdafx.h"
#include "math.h"

char verifyCode(char* s)
{
	static int weight[] = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
	static char map[] = {'1','0','X','9','8','7','6','5','4','3','2'};

	int sum = 0;
	for(int i=0; i<17; i++)
	{
		sum += (s[i] - '0') * weight[i];  // 填空
	}

	//return map[sum % 11];  // 填空
	return map[fmod(sum,11)];
}

int main(int argc, char* argv[])
{
	printf("%c\n", verifyCode("32011119610215381"));
	printf("%c\n", verifyCode("42900819801018236"));
	return 0;
}

