#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstdlib>
#include <cstring>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <ctime>

using namespace std;

#define LL long long
#define p_b push_back
#define m_p make_pair
#define l_b lower_bound
#define w1 first
#define w2 second

typedef pair<int,int> PII;
typedef pair<int,PII> PIII;
typedef pair<double,double> PDD;
typedef pair<string,int> PSI;

const int maxlongint=2147483647;
const int biglongint=2139062143;
const int maxn=200500;

struct ljb
{
    int dest,flow;
    ljb *next,*other;
} *head[maxn],*tail[maxn],*vi[maxn],*back[maxn],*p;

int flow[maxn];
int M,N,S;
int vh[maxn],dist[maxn];
int a[205][205],b[205][205],c[205][205];

void mpush(int x,int y,int w)
{
    ljb *p,*q;
    p=new ljb;
    p->dest=y,p->flow=w;
    p->next=0;
    tail[x]->next=p,tail[x]=p;
    q=new ljb;
    q->dest=x,q->flow=0;
    q->next=0;
    tail[y]->next=q,tail[y]=q;
    p->other=q,q->other=p;
}

int getSAP(int S)
{
    memset(dist,0,sizeof(dist));
    for (int i=0;i<=S;i++) vi[i]=head[i]->next;
    memset(vh,0,sizeof(vh));
    memset(flow,0,sizeof(flow));

    int arg=maxlongint,ttflow=0;
    int e=0,uu,minc;
    bool flag;
    ljb *p,*mink;

    while (dist[0]<=S)
    {
        flow[e]=arg;
        flag=false;
        p=vi[e];
        while (p!=0)
        {
            if ((p->flow>0)&&(dist[p->dest]+1==dist[e]))
            {
                flag=true;
                back[p->dest]=p;
                arg=min(arg,p->flow);
                vi[e]=p;
                e=p->dest;
                if (e==S)
                {
                    ttflow+=arg;
                    uu=S;
                    while (uu!=0)
                    {
                        back[uu]->flow-=arg;
                        back[uu]->other->flow+=arg;
                        uu=back[uu]->other->dest;
                    }
                    e=0;
                    arg=1e9;
                }
                break;
            }
            p=p->next;
        }
        if (flag==false)
        {
            p=head[e]->next;
            minc=S,mink=0;
            while (p!=0)
            {
                if ((p->flow>0)&&(dist[p->dest]<minc)) minc=dist[p->dest],mink=p;
                p=p->next;
            }
            vi[e]=mink;
            --vh[dist[e]];
            if (vh[dist[e]]==0) break;
            dist[e]=minc+1;
            ++vh[dist[e]];
            if (e>0)
            {
                e=back[e]->other->dest;
                arg=flow[e];
            }
        }
    }
    return ttflow;
}

int biao(int x,int y)
{
    return (x-1)*N+y;
}

int main()
{
//    freopen("colony.in","r",stdin);
//    freopen("colony.out","w",stdout);

    scanf("%d %d",&M,&N);
    for (int i=1;i<=M;i++)
        for (int j=1;j<=N;j++)
            scanf("%d",&a[i][j]);
    for (int i=1;i<=M+1;i++)
        for (int j=1;j<=N;j++)
            scanf("%d",&b[i][j]);
    for (int i=1;i<=M;i++)
        for (int j=1;j<=N+1;j++)
            scanf("%d",&c[i][j]);

    S=M*N+(M-1)*N+M*(N-1)+1;
    int lsans=0,ct;
    for (int i=0;i<=S;i++)
    {
        p=new ljb;
        p->dest=0,p->flow=0;
        p->next=0,p->other=0;
        head[i]=p,tail[i]=p;
    }
    for (int i=1;i<=M;i++)
        for (int j=1;j<=N;j++)
        {
            ct=a[i][j]-(b[i][j]+b[i+1][j]+c[i][j]+c[i][j+1]);
            if (ct>0)
            {
                lsans+=ct;
                mpush(0,biao(i,j),ct);
            }
            else
                mpush(biao(i,j),S,-ct);
        }

    int o;
    o=M*N;
    for (int i=2;i<=M;i++)
        for (int j=1;j<=N;j++)
        {
            ++o;
            lsans+=b[i][j]*2;
            mpush(0,o,b[i][j]*2);
            mpush(o,biao(i-1,j),maxlongint);
            mpush(o,biao(i,j),maxlongint);
        }
    for (int i=1;i<=M;i++)
        for (int j=2;j<=N;j++)
        {
            ++o;
            lsans+=c[i][j]*2;
            mpush(0,o,c[i][j]*2);
            mpush(o,biao(i,j-1),maxlongint);
            mpush(o,biao(i,j),maxlongint);
        }
    lsans-=getSAP(S);
    printf("%d\n",lsans);

    return 0;
}
