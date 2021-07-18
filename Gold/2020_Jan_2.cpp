//prefix sum array, frequency array
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 2e6 + 5;

int n, q;
int arr[5003], freq[maxn];
ll psa[5003][5003];

int main() {  
  cin >> n >> q;
  for (int i = 1; i <= n; i++){
    cin >> arr[i];
  }
  for (int i = 1; i <= n; i++){
    for (int j = i + 1; j <= n; j++){
      int num = 0 - arr[i] - arr[j] + 1e6;
      psa[i][j] += freq[num];
      freq[(int) (arr[j] + 1e6)]++;
    }
    for (int j = i + 1; j <= n; j++) freq[(int) (arr[j] + 1e6)]--;
  }
  
  for (int i = 1; i <= n; i++){
    for (int j = 1; j <= n; j++){
      psa[i][j] += psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
    }
  }
  
  while(q--){
    int a, b;
    cin >> a >> b;
    int ans = psa[b][b] - psa[b][a - 1] - psa[a - 1][b] + psa[a - 1][a - 1];
    cout << ans << "\n";
  }
  return 0;
}
