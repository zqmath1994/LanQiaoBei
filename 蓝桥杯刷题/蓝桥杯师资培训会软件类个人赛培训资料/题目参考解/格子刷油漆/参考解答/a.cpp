// All Mythin
// Create At 15:42 12-05 2012

#include <cmath>
#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <bitset>
#include <queue>
#include <map>
#include <set>

using namespace std;

#define sz(x) ((int)((x).size()))
#define out(x) printf(#x" %d\n", x)
#define all(x) (x).begin(), (x).end()
#define rep(i,n) for (int i = 0; i < (n); ++i)
#define repf(i,a,b) for (int i = (a); i <= (b); ++i)
#define repd(i,a,b) for (int i = (a); i >= (b); --i)
#define repcase int t; for (scanf ("%d", &t); t; --t)
#define repeach(i,x) for (__typeof((x).begin()) i = (x).begin(); i != (x).end(); ++i)

const int mod = 1000000007;
const int maxn = 1000 + 10;

long long a[maxn], b[maxn], dp[maxn];

/*
   a  -> start from one rightmost grid
   b  -> start from one rightmost grid & end at the other one
   dp -> The Answer:
         1) start from one left & right: 4 * a[i]
         2) start from middle: 4 * b[k] * a[i - k] * 2
*/

int main() {
    //freopen ("flipped.out", "w", stdout);
    
    b[1] = 1;
    repf (i, 2, maxn - 1) {
        b[i] = (b[i - 1] * 2) % mod;
    }
    a[1] = 1; a[2] = 6;
    repf (i, 3, maxn - 1) {
        a[i] = (2 * a[i - 1] + 4 * a[i - 2]) % mod;
        a[i] = (a[i] + b[i]) % mod;
    }
    dp[1] = 2;
    repf (i, 2, maxn - 1) {
        dp[i] = 4 * a[i] % mod;
        repf (j, 2, i - 1) {
            dp[i] = (dp[i] + 2 * 4 * b[j] * a[i - j] % mod) % mod;
        }
    }
    
    int Case = 1;
    repcase {
        int n;
        scanf ("%d", &n);
        printf ("Case %d: %d\n", Case++, (int)dp[n]);
    }
    return 0;
}


