#include <cstdio>
#include <iostream>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <set>
#include <algorithm>
#include <map>
#include <bitset>
#include <vector>
#include <queue>
#include <stack>
#include <utility>
#include <functional>
#include <sstream>
#include <list>
#include <complex>
#include <ctime>

#define maxlongint 2147483647
#define biglongint 2139062143
#define LL long long
#define ULL unsigned long long
#define p_b push_back
#define m_p make_pair
#define l_b lower_bound
#define w1 first
#define w2 second

using namespace std;

typedef pair<int,int> PII;
typedef pair<pair<int,int>,int> PIII;
typedef pair<pair<int,int>,pair<int,int> > PIIII;
typedef pair<double,double> PDD;
typedef pair<double,int> PDI;
typedef pair<string,int> PSI;
typedef pair<pair<double,double>,double> PDDD;
typedef pair<pair<double,double>,pair<double,double> > PDDDD;

const int maxn=400005;

int N,M,K,xc,yc,o,ux,uy,ll,rr,uj;
map<PII,int> cc;
map<PII,int>::iterator cls,clk;
vector<int> f[maxn],g[maxn];
LL sm[maxn],sum,ans;
int x[maxn],y[maxn],flag[maxn],lc[maxn],rc[maxn],ld[maxn],rd[maxn],a[maxn],st[maxn],jmd[maxn];

void dfs1(int s)
{
    if ((lc[s]==0)&&(rc[s]==0))
    {
        lc[s]=maxlongint;
        for (int i=0;i<f[s].size();i++)
        {
            dfs1(f[s][i]);
            lc[s]=min(lc[s],lc[f[s][i]]);
            rc[s]=max(rc[s],rc[f[s][i]]);
        }
    }
}

void dfs2(int s)
{
    if ((ld[s]==0)&&(rd[s]==0))
    {
        ld[s]=maxlongint;
        for (int i=0;i<g[s].size();i++)
        {
            dfs2(g[s][i]);
            ld[s]=min(ld[s],ld[g[s][i]]);
            rd[s]=max(rd[s],rd[g[s][i]]);
        }
    }
}

void calcit(int l,int r,int ss)
{
    int ll=l,rr=r,mm;
    while (ll<=rr)
    {
        mm=(ll+rr)/2;
        if (a[mm]>=ss) rr=mm-1; else ll=mm+1;
    }
    //cout<<rr<<" "<<ss<<" "<<a[rr]<<endl;
    ans=max(ans,sum+(LL)ss*(rr-l+1)-sm[rr]+sm[l-1]);
    //if (ans==41) cout<<xc-1<<" "<<yc<<" "<<ss<<endl;
}

int main()
{
//    freopen("aqueduct.in","r",stdin);
//    freopen("aqueduct.out","w",stdout);

    scanf("%d %d %d",&N,&M,&K);
    for (int i=1;i<=M;i++)
    {
        scanf("%d %d %d",&x[i],&y[i],&flag[i]);
        xc=x[i],yc=y[i];
        cc.insert(m_p(m_p(xc,yc),0));
        xc=x[i],yc=y[i];
        if (flag[i]==0) --xc; else ++xc;
        cc.insert(m_p(m_p(xc,yc),0));
    }
    for (int i=1;i<=N;i++)
    {
        cc.insert(m_p(m_p(i,0),0));
        cc.insert(m_p(m_p(i,K),0));
    }
    cls=cc.begin();
    o=0;
    while (cls!=cc.end())
    {
        ++o;
        cls->w2=o;
        ++cls;
    }
    for (int i=1;i<=M;i++)
    {
        cls=cc.l_b(m_p(x[i],y[i]));
        ux=cls->w2;
        xc=x[i],yc=y[i];
        if (flag[i]==0) --xc; else ++xc;
        cls=cc.l_b(m_p(xc,yc));
        uy=cls->w2;
        f[ux].p_b(uy);
        g[uy].p_b(ux);
    }
    cls=cc.begin();
    while (cls!=cc.end())
    {
        clk=cls;
        ++clk;
        if (clk->w1.w1==cls->w1.w1)
        {
            ux=cls->w2,uy=clk->w2;
            f[ux].p_b(uy);
            g[uy].p_b(ux);
        }
        ++cls;
    }
    memset(lc,0,sizeof(lc));
    memset(rc,0,sizeof(rc));
    memset(ld,0,sizeof(ld));
    memset(rd,0,sizeof(rd));
    for (int i=1;i<=N;i++)
    {
        cls=cc.l_b(m_p(i,0));
        ld[cls->w2]=rd[cls->w2]=i;
        st[i]=cls->w2;
        cls=cc.l_b(m_p(i,K));
        lc[cls->w2]=rc[cls->w2]=i;
        jmd[i]=cls->w2;
    }
    for (int i=1;i<=o;i++) dfs1(i);
    for (int i=1;i<=o;i++) dfs2(i);
    sum=0,ans=0;
    for (int i=1;i<=N;i++) sum+=(LL)(rc[st[i]]-lc[st[i]]+1);
    for (int i=1;i<=N;i++) a[i]=rc[st[i]];
    sm[0]=0;
    for (int i=1;i<=N;i++) sm[i]=sm[i-1]+a[i];
    cls=cc.begin();
    while (cls!=cc.end())
    {
        xc=cls->w1.w1,
        yc=cls->w1.w2;
        if (xc<N)
        {
            clk=cc.l_b(m_p(xc,yc));
            ll=ld[clk->w2];
            rr=rd[clk->w2];
            ++xc;
            clk=cc.l_b(m_p(xc,yc));
            uj=rc[clk->w2];
            //cout<<xc-1<<" "<<yc<<" "<<ll<<" "<<rr<<" "<<uj<<endl;
            calcit(ll,rr,uj);
        }
        ++cls;
    }
    cout<<ans<<endl;
    //for (int i=1;i<=N;i++) cout<<lc[st[i]]<<" "<<rc[st[i]]<<endl;

    return 0;
}

