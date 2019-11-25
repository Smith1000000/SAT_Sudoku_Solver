package zt.proj.sudoku.view;


import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import zt.proj.sudoku.Main;
import zt.proj.sudoku.model.Sudoku;

public class MainSceneController {
	@FXML
	private ArrayList<ArrayList<TextField>> tfList;
	@FXML
	private TextField t00;
	@FXML
	private TextField t01;
	@FXML
	private TextField t02;
	@FXML
	private TextField t03;
	@FXML
	private TextField t04;
	@FXML
	private TextField t05;
	@FXML
	private TextField t06;
	@FXML
	private TextField t07;
	@FXML
	private TextField t08;
	@FXML
	private TextField t10;
	@FXML
	private TextField t11;
	@FXML
	private TextField t12;
	@FXML
	private TextField t13;
	@FXML
	private TextField t14;
	@FXML
	private TextField t15;
	@FXML
	private TextField t16;
	@FXML
	private TextField t17;
	@FXML
	private TextField t18;
	@FXML
	private TextField t20;
	@FXML
	private TextField t21;
	@FXML
	private TextField t22;
	@FXML
	private TextField t23;
	@FXML
	private TextField t24;
	@FXML
	private TextField t25;
	@FXML
	private TextField t26;
	@FXML
	private TextField t27;
	@FXML
	private TextField t28;
	@FXML
	private TextField t30;
	@FXML
	private TextField t31;
	@FXML
	private TextField t32;
	@FXML
	private TextField t33;
	@FXML
	private TextField t34;
	@FXML
	private TextField t35;
	@FXML
	private TextField t36;
	@FXML
	private TextField t37;
	@FXML
	private TextField t38;
	@FXML
	private TextField t40;
	@FXML
	private TextField t41;
	@FXML
	private TextField t42;
	@FXML
	private TextField t43;
	@FXML
	private TextField t44;
	@FXML
	private TextField t45;
	@FXML
	private TextField t46;
	@FXML
	private TextField t47;
	@FXML
	private TextField t48;
	@FXML
	private TextField t50;
	@FXML
	private TextField t51;
	@FXML
	private TextField t52;
	@FXML
	private TextField t53;
	@FXML
	private TextField t54;
	@FXML
	private TextField t55;
	@FXML
	private TextField t56;
	@FXML
	private TextField t57;
	@FXML
	private TextField t58;
	@FXML
	private TextField t60;
	@FXML
	private TextField t61;
	@FXML
	private TextField t62;
	@FXML
	private TextField t63;
	@FXML
	private TextField t64;
	@FXML
	private TextField t65;
	@FXML
	private TextField t66;
	@FXML
	private TextField t67;
	@FXML
	private TextField t68;
	@FXML
	private TextField t70;
	@FXML
	private TextField t71;
	@FXML
	private TextField t72;
	@FXML
	private TextField t73;
	@FXML
	private TextField t74;
	@FXML
	private TextField t75;
	@FXML
	private TextField t76;
	@FXML
	private TextField t77;
	@FXML
	private TextField t78;
	@FXML
	private TextField t80;
	@FXML
	private TextField t81;
	@FXML
	private TextField t82;
	@FXML
	private TextField t83;
	@FXML
	private TextField t84;
	@FXML
	private TextField t85;
	@FXML
	private TextField t86;
	@FXML
	private TextField t87;
	@FXML
	private TextField t88;
	@FXML
	private TextArea txArea;
	
	private int[][] sudoku;
	private Sudoku s0;
	private Main mainClass;
	
	@FXML
	private void initialize() {
		tfList = new ArrayList<ArrayList<TextField>>();
		tfList.add(new ArrayList<TextField>());
		tfList.get(0).add(t00);
		tfList.get(0).add(t01);
		tfList.get(0).add(t02);
		tfList.get(0).add(t03);
		tfList.get(0).add(t04);
		tfList.get(0).add(t05);
		tfList.get(0).add(t06);
		tfList.get(0).add(t07);
		tfList.get(0).add(t08);
		tfList.add(new ArrayList<TextField>());
		tfList.get(1).add(t10);
		tfList.get(1).add(t11);
		tfList.get(1).add(t12);
		tfList.get(1).add(t13);
		tfList.get(1).add(t14);
		tfList.get(1).add(t15);
		tfList.get(1).add(t16);
		tfList.get(1).add(t17);
		tfList.get(1).add(t18);
		tfList.add(new ArrayList<TextField>());
		tfList.get(2).add(t20);
		tfList.get(2).add(t21);
		tfList.get(2).add(t22);
		tfList.get(2).add(t23);
		tfList.get(2).add(t24);
		tfList.get(2).add(t25);
		tfList.get(2).add(t26);
		tfList.get(2).add(t27);
		tfList.get(2).add(t28);
		tfList.add(new ArrayList<TextField>());
		tfList.get(3).add(t30);
		tfList.get(3).add(t31);
		tfList.get(3).add(t32);
		tfList.get(3).add(t33);
		tfList.get(3).add(t34);
		tfList.get(3).add(t35);
		tfList.get(3).add(t36);
		tfList.get(3).add(t37);
		tfList.get(3).add(t38);
		tfList.add(new ArrayList<TextField>());
		tfList.get(4).add(t40);
		tfList.get(4).add(t41);
		tfList.get(4).add(t42);
		tfList.get(4).add(t43);
		tfList.get(4).add(t44);
		tfList.get(4).add(t45);
		tfList.get(4).add(t46);
		tfList.get(4).add(t47);
		tfList.get(4).add(t48);
		tfList.add(new ArrayList<TextField>());
		tfList.get(5).add(t50);
		tfList.get(5).add(t51);
		tfList.get(5).add(t52);
		tfList.get(5).add(t53);
		tfList.get(5).add(t54);
		tfList.get(5).add(t55);
		tfList.get(5).add(t56);
		tfList.get(5).add(t57);
		tfList.get(5).add(t58);
		tfList.add(new ArrayList<TextField>());
		tfList.get(6).add(t60);
		tfList.get(6).add(t61);
		tfList.get(6).add(t62);
		tfList.get(6).add(t63);
		tfList.get(6).add(t64);
		tfList.get(6).add(t65);
		tfList.get(6).add(t66);
		tfList.get(6).add(t67);
		tfList.get(6).add(t68);
		tfList.add(new ArrayList<TextField>());
		tfList.get(7).add(t70);
		tfList.get(7).add(t71);
		tfList.get(7).add(t72);
		tfList.get(7).add(t73);
		tfList.get(7).add(t74);
		tfList.get(7).add(t75);
		tfList.get(7).add(t76);
		tfList.get(7).add(t77);
		tfList.get(7).add(t78);
		tfList.add(new ArrayList<TextField>());
		tfList.get(8).add(t80);
		tfList.get(8).add(t81);
		tfList.get(8).add(t82);
		tfList.get(8).add(t83);
		tfList.get(8).add(t84);
		tfList.get(8).add(t85);
		tfList.get(8).add(t86);
		tfList.get(8).add(t87);
		tfList.get(8).add(t88);
		
		for(int i = 0; i < tfList.size(); i++) {
			for(int j = 0; j < tfList.get(i).size(); j++) {
				tfList.get(i).get(j).setText("");
				TextField temp = tfList.get(i).get(j);
				temp.textProperty().addListener(new ChangeListener<String>() {
		            @Override
		            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		                if (!newValue.matches("\\d{0,1}?")) {
		                    temp.setText(oldValue);
		                }
		            }
		        });
			}
		}
		sudoku = new int[9][9];
		s0 = new Sudoku();
	}
	
	@FXML
	private void ClearAll() {
		txArea.clear();
		for(int i = 0; i < tfList.size(); i++) {
			for(int j = 0; j < tfList.get(i).size(); j++) {
				tfList.get(i).get(j).clear();
				tfList.get(i).get(j).setEditable(true);
			}
		}
	}
	
	public void setMainClass(Main mainClass) {
        this.mainClass = mainClass;
    }
	
	@FXML
	private void Solve() {
		String str = "";
		sudoku = new int[9][9];
		int counter = 0;
		for(int i = 0; i < tfList.size(); i++) {
			for(int j = 0; j < tfList.get(i).size(); j++) {
				if(!tfList.get(i).get(j).getText().toString().equals("") && tfList.get(i).get(j).getText() != null) {
					sudoku[i][j] = Integer.valueOf(tfList.get(i).get(j).getText().toString());
					counter += 1;
				}
			}
		}
		if(counter <= 16) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainClass.getPrimaryStage());
            alert.setTitle("Initial Values Deficiency");
            alert.setHeaderText("At least 17 grids should be assigned values initially");
            alert.setContentText("Please check your input and enter again");
            alert.showAndWait();
		}
		else {
			s0 = new Sudoku();
			if(!s0.isValidSudoku(sudoku)) {
				Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainClass.getPrimaryStage());
	            alert.setTitle("Invalid Sudoku Input");
	            alert.setHeaderText("Rules Violation");
	            alert.setContentText("Each row, column, and nonet can contains each number (1 to 9) exactly once.");
	            alert.showAndWait();
			}
			else {
				s0.setSudoku(sudoku);
				s0.initialize();
				for(int i = 0; i < s0.getCNF_Format().size(); i++) {
					for(int j = 0; j < s0.getCNF_Format().get(i).size(); j++) {
						str += s0.getCNF_Format().get(i).get(j) + " ";
					}
					str += "\n";
				}
				txArea.setText(str);
				s0.DPLL(s0.getCNF_Format());
				s0.AssignValue();
				for(int i = 0; i < tfList.size(); i++) {
					for(int j = 0; j < tfList.get(i).size(); j++) {
						tfList.get(i).get(j).setText(Integer.toString(s0.getSudoku()[i][j]));
						tfList.get(i).get(j).setEditable(false);
					}
				}
			}
		}
	}
	
}
