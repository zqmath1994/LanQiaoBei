#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
#define N 2010
#define M 999999

struct Edge{
	int u,v,next;
	Edge(){}
	Edge(int _u,int _v,int n):
		u(_u),v(_v),next(n){}
}E[M];
int head[N],size;
int dfn[N],low[N],bcc,step;
int stk[M],top;
bool vis[M],blg[N][N];
int cut[N],cid;
int cvr[N],scc[N];

void Init(){
	memset(head,-1,sizeof(head));
	memset(vis,false,sizeof(vis));
	size=step=0; top=-1;
}

void Insert(int u,int v){
	E[size]=Edge(u,v,head[u]);
	head[u]=size++;
	E[size]=Edge(v,u,head[v]);
	head[v]=size++;
}

int root;
void Tarjan(int u){
	bool isc=false;
	int cnt=0;
	scc[u]=root;
	dfn[u]=low[u]=step++;
	for(int i=head[u];i!=-1;i=E[i].next){
		if(vis[i]||vis[i^1]) continue;
		vis[i]=true;
		stk[++top]=i;
		int v=E[i].v;
		if(dfn[v]==-1){
			cnt++;
			Tarjan(v);
			low[u]=min(low[u],low[v]);
			if(dfn[u]<=low[v]){
				if(u) isc=true;
				for(int e=-1;e!=i;top--){
					e=stk[top];
					blg[bcc][E[e].u]=true;
					blg[bcc][E[e].v]=true;
				}
				bcc++;
			}
		}else{
			low[u]=min(low[u],dfn[v]);
		}
	}
	if(u==0&&cnt>1) isc=true;
	if(isc) cut[u]=cid++;
}

int dep[N<<1],eul[N<<1],id;
int pos[N],dis[N];
void dfs(int u,int d){
	vis[u]=true;
	++id;
	eul[id]=u;
	dep[id]=d;
	if(pos[u]==-1) pos[u]=id;
	if(dis[u]==-1) dis[u]=d;
	for(int i=head[u];i!=-1;i=E[i].next){
		int v=E[i].v;
		if(vis[v]) continue;
		dfs(v,d+1);
		++id;
		eul[id]=u;
		dep[id]=d;
	}
}


int tlog[N<<1];
int st[20][N<<1];
inline int MIN(int a,int b){
	return dep[a]<dep[b]?a:b;
}

void ST(int n){
	for(int i=0;i<=n;i++) st[0][i]=i;
	for(int j=1;j<=tlog[n];j++){
		for(int i=0;j<=tlog[n-i+1];i++){
			st[j][i]=MIN(st[j-1][i],st[j-1][i+(1<<j>>1)]);
		}
	}
}

int RMQ(int l,int r){
	l=pos[l];
	r=pos[r];
	if(r<l) swap(l,r);
	int tmp=tlog[r-l+1];
	int res=MIN(st[tmp][l],st[tmp][r-(1<<tmp)+1]);
	return eul[res];
}

int main(){
	freopen("data.in","r",stdin);
	freopen("data.out","w",stdout);
	
	tlog[0]=-1;
	for(int i=1;i<(N<<1);i++){
		tlog[i]=tlog[i-1]+((i&(i-1))?0:1);
    }

	int t,cas=0;
	scanf("%d",&t);
	
	while(t--){
		int n,m,q;
		scanf("%d%d%d",&n,&m,&q);
		Init();
		for(int i=0;i<m;i++){
			int x,y;
			scanf("%d%d",&x,&y);
			x--; y--;
			Insert(x,y);
		}
		
		memset(dfn,-1,sizeof(dfn));
		memset(blg,false,sizeof(blg));
		memset(cut,-1,sizeof(cut));
		bcc=cid=0;
		
		for(int i=0;i<n;i++){
			if(dfn[i]==-1){
				root=i;
				Tarjan(i);
			}
		}
		
		Init();
		memcpy(cvr,cut,sizeof(cvr));
		for(int i=0;i<bcc;i++){
			for(int j=0;j<n;j++){
				if(blg[i][j]&&(~cvr[j])){
					Insert(i+cid,cvr[j]);
				}else if(blg[i][j]){
					cvr[j]=i+cid;
				}
			}
		}
		
		memset(dis,-1,sizeof(dis));
		memset(pos,-1,sizeof(pos));
		id=0;
		
		for(int i=0;i<bcc+cid;i++){
			if(pos[i]==-1) dfs(i,0);
		}
		ST((bcc+cid)*2-1);
		
//		printf("= %d %d\n",cid,bcc);
//		for(int i=0;i<bcc;i++){
//			for(int j=0;j<n;j++){
//				printf("%c",blg[i][j]?(j+'0'):'-');
//			}puts("");
//		}
//		for(int i=0;i<n;i++){
//			printf("- %d %d\n",i,cvr[i]);
//		}
		
		printf("Case %d:\n",++cas);
		for(int i=0;i<q;i++){
			int u,v;
			scanf("%d%d",&u,&v);
			u--; v--;
			if(scc[u]^scc[v]){
				puts("-1");
			}else{
				int r=RMQ(cvr[u],cvr[v]);
				int len=dis[cvr[u]]+dis[cvr[v]]-2*dis[r];
				len-=bool(~cut[u]);
				len-=bool(~cut[v]);
				printf("%d\n",len>>1);
			}
		}
	}
}
