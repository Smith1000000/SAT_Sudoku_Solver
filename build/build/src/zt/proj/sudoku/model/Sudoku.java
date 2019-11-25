package zt.proj.sudoku.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Sudoku {
	private int[][] sudoku;
	private ArrayList<ArrayList<Integer>> CNF_Format;
	private boolean[] set;
	private boolean global;
	private int transfer(int i, int j, int n) {
		return 81 * (i - 1) + 9 * (j - 1) + n;
	}
	
	public Sudoku() {
		set = new boolean[730];
		CNF_Format = new ArrayList<ArrayList<Integer>>();
		int pos = 0;
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				for(int n = 1; n <= 8; n++) {
					for(int k = n + 1; k <= 9; k++) {
						CNF_Format.add(new ArrayList<Integer>());
						CNF_Format.get(pos).add(-transfer(i, j, n));
						CNF_Format.get(pos).add(-transfer(i, j, k));
						CNF_Format.get(pos).add(0);
						pos+=1;
					}
				}
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			for(int n = 1; n <= 9; n++) {
				CNF_Format.add(new ArrayList<Integer>());
				for(int j = 1; j <= 9; j++) {
					CNF_Format.get(pos).add(transfer(i, j, n));
				}
				CNF_Format.get(pos).add(0);
				pos+=1;
			}
		}
		
		for(int j = 1; j <= 9; j++) {
			for(int n = 1; n <= 9; n++) {
				CNF_Format.add(new ArrayList<Integer>());
				for(int i = 1; i <= 9; i++) {
					CNF_Format.get(pos).add(transfer(i, j, n));
				}
				CNF_Format.get(pos).add(0);
				pos+=1;
			}
		}
		
		for(int r = 0; r <= 2; r++) {
			for(int s = 0; s <=2; s++) {
				for(int n = 1; n <= 9; n++) {
					CNF_Format.add(new ArrayList<Integer>());
					for(int i = 1; i <= 3; i++) {
						for(int j = 1; j <= 3; j++) {
							CNF_Format.get(pos).add(transfer(3 * r + i, 3 * s + j, n));
						}
					}
					CNF_Format.get(pos).add(0);
					pos+=1;
				}
			}
		}
	}

	public void initialize() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(sudoku[i][j] != 0) {
					Simplification(CNF_Format, transfer(i + 1, j + 1, sudoku[i][j]));
				}
			}
		}
	}
	
	public int[][] getSudoku() {
		return sudoku;
	}

	public void setSudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}

	public ArrayList<ArrayList<Integer>> getCNF_Format() {
		return CNF_Format;
	}

	public void setCNF_Format(ArrayList<ArrayList<Integer>> CNF_Format) {
		this.CNF_Format = CNF_Format;
	}
	
	public void BooleanConstrainPropagation(ArrayList<ArrayList<Integer>> l0, int target, boolean value) {
		for(int i = 0; i < l0.size(); i++) {
			if(value == true) {
				set[target] = true;
				if(l0.get(i).contains(-target)) {
					int index = l0.get(i).indexOf(-target);
					l0.get(i).remove(index);
					//if(l0.get(i).size() == 2) temp.add(i);
				}
				if(l0.get(i).contains(target)) {
					l0.remove(i);
					i-=1;
				}
			}
			if(value == false) {
				set[target] = false;
				if(l0.get(i).contains(target)) {
					int index = l0.get(i).indexOf(target);
					l0.get(i).remove(index);
					//if(l0.get(i).size() == 2) temp.add(i);
				}
				if(l0.get(i).contains(-target)) {
					l0.remove(i);
					i-=1;
				}
			}
		}
	}
	
	public void Simplification(ArrayList<ArrayList<Integer>> l0, int index) {
		BooleanConstrainPropagation(l0, index, true);
		if(ConflictDetection(l0)) return;
		int lower = (index - 1) / 9 * 9;
		int upper = lower + 10;
		for(int i = lower + 1; i < upper; i++) {
			if(i != index) BooleanConstrainPropagation(l0, i, false);
			if(ConflictDetection(l0)) return;
		}
		lower = (index - 1) / 81 * 81;
		upper = lower + 82;
		for(int i = lower + 1; i < upper; i++) {
			if(i - index == 9 || i - index == -9) BooleanConstrainPropagation(l0, i, false);
			if(ConflictDetection(l0)) return;
		}
		if(index > 81) lower = index - lower;
		for(int i = 0; i < 9; i++) {
			if(index < 82) {
				if(i > 0) BooleanConstrainPropagation(l0, index + i * 81, false);
			}
			else {
				if(lower + i * 81 != index) BooleanConstrainPropagation(l0, lower + i * 81, false);
			}
			if(ConflictDetection(l0)) return;
		}
		int i = (index - 1) / 81 + 1;
		int j = (index - (i - 1) * 81 - 1) / 9 + 1;
		int row = 0, column = 0;
		if(i > 3 && i < 7) {
			row = 1;
			i = i - 3;
		}
		if(i > 6 && i < 10) {
			row = 2;
			i = i - 6;
		}
		if(j > 3 && j < 7) {
			column = 1;
			j = j - 3;
		}
		if(j > 6 && j < 10) {
			column = 2;
			j = j - 6;
		}
		upper = 81 * (3 * row ) + 9 * (3 * column ) + 1;
		for(int k = upper; k < upper + 27; k++) {
			if(Math.abs(k - index) % 9 == 0 && k != index) BooleanConstrainPropagation(l0, k, false);
			if(ConflictDetection(l0)) return;
		}
		for(int k = upper + 81; k < upper + 81 + 27; k++) {
			if(Math.abs(k - index) % 9 == 0 && k != index) BooleanConstrainPropagation(l0, k, false);
			if(ConflictDetection(l0)) return;
		}
		for(int k = upper + 162; k < upper + 162 + 27; k++) {
			if(Math.abs(k - index) % 9 == 0 && k != index) BooleanConstrainPropagation(l0, k, false);
			if(ConflictDetection(l0)) return;
		}
 	}
	
	public boolean ConflictDetection(ArrayList<ArrayList<Integer>> l0) {
		for(int j = 0; j < l0.size(); j++) {
			if(l0.get(j).size() == 1) {
				//temp.clear();
				return true;
			}
		}
		return false;
	}
	
	public void BCP(ArrayList<ArrayList<Integer>> l0) {
		for(int i = 0; i < l0.size(); i++) {
			if(l0.get(i).size() == 2) {
				Simplification(l0, Math.abs(l0.get(i).get(0)));
			}
			if(ConflictDetection(l0)) {
				return;
			}
		}
	}
	
	public void DPLL(ArrayList<ArrayList<Integer>> l0) {
		BCP(l0);
		if(l0.size() == 0) {
			global = true;
			return;
		}
		if(ConflictDetection(l0)) return;
		else {
			ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>> ();
			for(int i = 0; i < l0.size(); i++) {
				l1.add(new ArrayList<Integer>());
				for(int j = 0; j < l0.get(i).size(); j++) {
					l1.get(i).add(l0.get(i).get(j));
				}
			}
			//set[Math.abs(l1.get(0).get(0))] = true;
			Simplification(l1, Math.abs(l1.get(0).get(0)));
			if(ConflictDetection(l0)) return;
			DPLL(l1);
			if(global != true) {
				set[Math.abs(l0.get(0).get(0))] = false;
				BooleanConstrainPropagation(l0, Math.abs(l0.get(0).get(0)), false);
				DPLL(l0);
			}
		}
	}
	
	public void AssignValue() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(sudoku[i][j] == 0) {
					for(int k = transfer(i + 1, j + 1, 1); k < transfer(i + 1, j + 1, 1) + 9; k++) {
						if(set[k] == true) {
							sudoku[i][j] = k - transfer(i + 1, j + 1, 1) + 1;
							break;
						}
					}
				}  
			}
		}
	}
	
	public boolean isValidSudoku(int[][] board) {
		HashMap<Integer, Integer> [] rows = new HashMap[9];
	    HashMap<Integer, Integer> [] columns = new HashMap[9];
	    HashMap<Integer, Integer> [] boxes = new HashMap[9];
	    for (int i = 0; i < 9; i++) {
	      rows[i] = new HashMap<Integer, Integer>();
	      columns[i] = new HashMap<Integer, Integer>();
	      boxes[i] = new HashMap<Integer, Integer>();
	    }

	    for (int i = 0; i < 9; i++) {
	      for (int j = 0; j < 9; j++) {
	        int num = board[i][j];
	        if (num != 0) {
	          int n = num;
	          int box_index = (i / 3 ) * 3 + j / 3;

	          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
	          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
	          boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

	          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
	            return false;
	        }
	      }
	    }

	    return true;
	  }
	

}
