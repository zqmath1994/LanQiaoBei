#include <cstdio>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>
#include <vector>
#include <string>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;
const int N=10005;

struct Road {
    int u,v;
}road[100005];
int n,m;
ll in[N];

int main()
{
    int i,j,t,cas=0;
    scanf("%d",&t);
    while(t--) {
        scanf("%d%d",&n,&m);

        memset(in,0,sizeof(in));
        for(i=1;i<=m;i++) {
            scanf("%d%d",&road[i].u,&road[i].v);
            in[road[i].u]++; in[road[i].v]++;
        }

        ll ret=0;
        for(i=1;i<=m;i++) {
            int u=road[i].u;
            int v=road[i].v;
            ret+=(in[u]-1)*(in[v]-1)*2;
        }

        printf("Case %d: %I64d\n",++cas,ret);
    }
    return 0;
}
