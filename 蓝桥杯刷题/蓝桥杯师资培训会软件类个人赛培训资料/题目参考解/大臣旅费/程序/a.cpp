#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <cstring>

using namespace std;

const int MAXN = 100010;

class Edge {
public:
	int to;
	int len;
	Edge *next;
};

int n;
Edge* first[MAXN];
Edge edges[MAXN * 2];
int mlen;
bool reached[MAXN];
int q[MAXN];
int len[MAXN];

int getF(int x)
{
	memset(reached, 0, sizeof(reached));
	int open = 0, close = 0;
	len[x] = 0;
	reached[q[open++]=x] = true;
	mlen = 0;
	int ret = x;
	while (close < open)
	{
		int p = q[close++];
		for (Edge *e = first[p]; e; e = e->next)
		{
			if (!reached[e->to])
			{
				int t = len[e->to] = len[p] + e->len;
				if (t > mlen)
				{
					mlen = t;
					ret = e->to;
				}
				reached[q[open++]=e->to] = true;
			}
		}
	}
	return ret;
}

int main()
{
	memset(first, 0, sizeof(first));
	scanf("%d", &n);
	Edge *cur = edges;
	for (int i = 1; i < n; ++i)
	{
		int p, q, d;
		scanf("%d%d%d", &p, &q, &d);
		cur->to = q;
		cur->len = d;
		cur->next = first[p];
		first[p] = cur;
		++cur;
		cur->to = p;
		cur->len = d;
		cur->next = first[q];
		first[q] = cur;
		++cur;
	}
	int a = getF(1);
	int b = getF(a);
	int ans = mlen;
	double tu = ans;
	double ta = tu * 10.0 + tu * (tu+1) / 2.0;
	printf("%.0lf\n", ta);
	return 0;
}
