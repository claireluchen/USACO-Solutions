//binary search
#include <bits/stdc++.h>
using namespace std;

const int maxn = 5e4 + 5;

int n, k;
int arr[maxn];

bool check(int r){
  int cnt = 1;
  int left = arr[0], right = left + 2 * r;
  for (int i = 1; i < n; i++){
    if (arr[i] > right){
      cnt++;
      left = arr[i];
      right = left + 2 * r;
    }
  }
  if (cnt <= k) return true;
  return false;
}

int binarySearch(int low, int high){
  if (low == high) return low;
  if (low + 1 == high){
    if (!check(low)) return high;
    else return low;
  }
  int mid = (low + high) / 2;
  cout << mid <<"\n";
  if (!check(mid)) return binarySearch(mid + 1, high);
  else return binarySearch(low, mid);  
}

int main() {  
  cin >> n >> k;
  for (int i = 0; i < n; i++){
    cin >> arr[i];
  }

  sort(arr, arr + n);
  int low = 0, high = arr[n - 1];
  cout << binarySearch(low, high) << endl;
  return 0;
}
