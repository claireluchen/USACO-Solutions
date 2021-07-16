//binary search
#include <bits/stdc++.h>
using namespace std;

int n, m, c, high, low, wt;

int main() {  
  cin >> n >> m >> c;
  int arr[n];
  for (int i = 0; i < n; i++){
    cin >> arr[i];
    high = max(high, arr[i]);
  }
  sort(arr, arr + n);
  
  while (low < high){
    wt = (high + low - 1) / 2;
    int bus = 0;
    int index = 0;
    while (index < n){
      bool boo = true;
      for (int i = 0; i < c; i++){
        if (arr[index + i] - arr[index] > wt){
          boo = false;
          index += i;
          bus++;
          break;
        }
      }
      if (boo){
        index += c;
        bus++;
      }
    }
    if (bus <= m){
      high = wt;
    }else{
      low = wt + 1;
    }
  }

  cout << wt << "\n";
  return 0;
}
