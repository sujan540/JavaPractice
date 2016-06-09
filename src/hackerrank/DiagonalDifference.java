package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		
		Map<String,Employee> map = new HashMap<>();
		map.put("one", new Employee("Sujan",10));
		map.put("two", new Manager("Sujan Maharjan",100));
		
		
		for(Map.Entry<String, Employee> entry: map.entrySet()){
			String key = entry.getKey();
			Employee value = entry.getValue();
			
			if(value instanceof Manager){
				value = (Manager)value;
			}
			
			System.out.println(key);
			System.out.println(value.getSalary());
			System.out.println(value.getUpdateSalary());
		}
		
		
		
		
		
				
		/*

		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for(int j=0;j<n;j++){
				matrix[i][j]= scan.nextInt();
				if(i==j)
					diagonalSum1+=matrix[i][j];
				if(j==n-(i+1))
					diagonalSum2+=matrix[i][j];
			}
		}
		
		System.out.println(Math.abs(diagonalSum1-diagonalSum2));
	}*/
	}
	
	
	static boolean a(int i, int j){
		return (i==1||j==1)?true:(i+j)==1;
	}

}
