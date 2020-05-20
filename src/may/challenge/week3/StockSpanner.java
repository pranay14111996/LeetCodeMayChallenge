package may.challenge.week3;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

	int days = 0;/*
	List<Integer> sp = null;
	List<Integer> span = null;*/
	private int[] spArray = null;
	private int[] spanArray = null;
    public StockSpanner() {
        this.days = 0;
        //sp = new ArrayList<>();
        //span = new ArrayList<>();
        spArray = new int[10000];
        spanArray = new int[10000];
    }
    
    public int next(int price) {
    	//span.add(price);
    	spanArray[days] = price;
        //int counter = 1;
        int arrayCounter = 1;
        //while( days - counter >= 0 && span.get(days - counter) <= span.get(days)) {
        //	counter = counter + sp.get(days - counter);
        //}
        //sp.add(counter);
        while( days - arrayCounter >= 0 && spanArray[days-arrayCounter] <= spanArray[days] ) {
        	arrayCounter = arrayCounter + spArray[days-arrayCounter];
        }
        spArray[days] = arrayCounter;
        days++;
        return arrayCounter;
    }
    
    public int nextNew(int price) {
    	int count = 1;
    	while( 0 <= days)
    	days++;
    	spanArray[days] = count;
    	spArray[days] = price;
    	return count;
    }
    
	public static void main(String[] args) {
		StockSpanner obj = new StockSpanner();
		obj.next(100);
		obj.next(80);
		obj.next(60);
		obj.next(70);
		obj.next(60);
		obj.next(75);
		obj.next(85);
		//System.out.println(obj.sp.toString());
		for(int i : obj.spArray) {
			System.out.print(i + ", ");
		}
	}
}
