#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<vector<string>> res;
	
	bool isValid(int row, int col, vector<string> &board, int n) {
		// Check current column
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 'Q') return false;
		}
		
		// Check diag (init_row = row - 1; downward)
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') return false;
		}
		
		// Check counter-diag (init_row = row - 1; upward)
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == 'Q') return false;
		}
		
		return true;
	}
	
	void dfs(vector<string> &board, int n, int row) {
		if (row == n) {
			res.push_back(board);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isValid(row, i, board, n)) {
				board[row][i] = 'Q';
				dfs(board, n, row + 1);
				board[row][i] = '.';
			}
		}
	}
	
	vector<vector<string>> solveNQueens(int n) {
		vector<string> board(n, string(n, '.'));
		dfs(board, n, 0);
		return res;
	}
};