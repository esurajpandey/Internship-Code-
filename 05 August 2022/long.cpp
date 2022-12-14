#include<bits/stdc++.h>
using namespace std;
int dp[201][201];
int dfs(vector<vector<int>> &mat, int i, int j, int pre) {
    if (i < 0 || j < 0 || i == mat.size() || j == mat[0].size() || pre >= mat[i][j])
        return 0;
        
    if (dp[i][j]) 
        return dp[i][j];
    
    
    int l = dfs(mat, i, j - 1, mat[i][j]);
    int r = dfs(mat, i, j + 1, mat[i][j]);
    int u = dfs(mat, i - 1, j, mat[i][j]);
    int d = dfs(mat, i + 1, j, mat[i][j]);
    
    int res = max({l, r, u, d}) + 1;
    return dp[i][j] = res;
}

int longestIncreasingPath(vector<vector<int>>& matrix) {
    int maxVal = 0;
    for (int i = 0; i < matrix.size(); i++)
        for (int j = 0; j < matrix[i].size(); j++)
            maxVal = max(maxVal, dfs(matrix, i, j, -1));
    return maxVal;
}
int main(){
    vector<int> res;
    
    vector<vector<int>> arr= {
                    { 1, 2, 3, 4 },
                    { 2, 2, 3, 4 },
                    { 3, 2, 3, 4 },
                    { 4, 5, 6, 7 },
                };
    cout<<longestIncreasingPath(arr);
}