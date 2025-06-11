/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1


Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/


class Solution {
public:
    void dfs(int m, int n ,int i , int j , vector<vector<char>>& grid)
    {
        if(i<0 || j<0 || i>=m || j>= n || grid[i][j]=='0')
            return ;
        grid[i][j] = '0';
        dfs(m,n,i-1,j,grid);
        dfs(m,n,i+1,j,grid);
        dfs(m,n,i,j-1,grid);
        dfs(m,n,i,j+1,grid);
    }
    int numIslands(vector<vector<char>>& grid) {
        int r = 0;
        int m = grid.size();
        int n = grid[0].size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    r++;
                    dfs(m,n,i,j,grid);
                }
            }
        }
        return r;
    }
};