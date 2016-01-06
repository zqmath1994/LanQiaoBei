
#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	char s[] = "ayyyxxff";
	next_permutation(s,s+8);
	cout << s << endl; 
	return 0;
}
