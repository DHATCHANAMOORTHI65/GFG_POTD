#First & Last Occurences of X

class Solution():
  def find(self,arr,n,x):
    # code here
    first_last = [-1,-1]
    for i in range(n):
      if arr[i] == x:
        if first_last[0] == -1:
          first_last = i
        first_last[1] = i
    return first_last

t = int(input())
for _ in range(0,t):
  l = list(map(int,input().split()))
  n = l[0]
  x = l[1]
  arr = list(map(int,input().split()))
  ob = Solution()
  ans = ob.find(arr,n,x)
  print(*ans)
