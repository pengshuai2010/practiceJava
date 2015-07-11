package practiceJava;

import java.util.Collection;

public class GenericSort {

	public static void main(String[] args) {
		Integer[] a = {1, -1, 3, -2, 4, -9, 10};
		sort(a);
		printArray(a);

	}

	public static void sort(Comparable[] list){
		for(int i = 0; i < list.length - 1; i++){
			for(int j = 0; j < list.length - 1 - i; j++){
				if(list[j].compareTo(list[j+1]) > 0){
					Comparable tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
				}
			}
		}
	}
	
	public static void printArray(Object[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

}
