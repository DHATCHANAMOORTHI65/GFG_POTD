class Solution{
    public int largestIsland(int N,int[][] grid) 
    {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean[][] vis = new boolean[N][N];
        int name=2;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == 1 && vis[i][j]==false){
                    int count = dfs(i, j, grid, vis, name, N);
                    map.put(name,count);
                    name++;
                }
            }
        }
        
        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == 0){
                    int d = (i+1<N)?grid[i+1][j]:0;
                    int u = (i-1>=0)?grid[i-1][j]:0;
                    int r = (j+1<N)?grid[i][j+1]:0;
                    int l = (j-1>=0)?grid[i][j-1]:0;
                    
                    HashSet<Integer> set = new HashSet<>();
                    set.add(d);set.add(u);set.add(l);set.add(r);
                    int res = 1;
                    for(int val : set){
                        res = res+map.getOrDefault(val,0);
                    }
                    ans = Math.max(ans,res);
                }
            }
        }
        if(ans == 0){
            return N*N;
        }
        return ans;
    }
    
    static int dfs(int i, int j, int[][] grid, boolean[][] vis, int name, int N){
        //base cases
        if(i<0 || j<0 || i>=N || j>=N || grid[i][j] == 0 || vis[i][j]) return 0;
        
        vis[i][j] = true;
        grid[i][j] = name;
        int count = 1+dfs(i-1, j, grid, vis, name, N)+dfs(i+1, j, grid, vis, name, N)+dfs(i, j-1, grid, vis, name, N)+dfs(i, j+1, grid, vis, name, N);
        return count;
    }
}
