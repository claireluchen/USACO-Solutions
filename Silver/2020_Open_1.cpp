//binary search
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 1e5 + 5;

int n, m;
pair<int, int> arr[maxn];

bool check(int d){
  int prev = -0x3f3f3f3f, cnt = 0;
  for (int i = 0; i < m; i++){
    while (max(prev + d, arr[i].first) <= arr[i].second){
      cnt++;
      prev = max(prev + d, arr[i].first);
    }
    if (cnt >= n) break;
  }
  return cnt >= n;
}

int main() {  
  cin >> n >> m;
  int low = 1, high = 0;
  for (int i = 0; i < m; i++){
    int a, b;
    cin >> a >> b;
    high = max(high, b);
    arr[i] = {a, b};
  }  
  sort(arr, arr + m);
  int ans = 0;
  while (low <= high){
    int mid = (low + high) / 2;
    if (check(mid)){
      ans = mid;
      low = mid + 1;
    }else{
      high = mid - 1;
    }
  }
  cout << ans << "\n";
  return 0;
}
