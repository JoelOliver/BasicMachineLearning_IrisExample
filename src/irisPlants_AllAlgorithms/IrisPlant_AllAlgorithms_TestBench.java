/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Basic Machine Learning for Pattern Recognition/Data Mining 
 * All compiled algorithms :
      - Nearest Neighbor 
      - Nearest Centroid
      - Data Normalization
 */

package irisPlants_AllAlgorithms;

import java.util.*;

public class IrisPlant_AllAlgorithms_TestBench {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initial Instance for Test Bench
		IrisGeneralFloriculture tb = new IrisGeneralFloriculture(); 
		
		
        int controlTest = 1;
        do {
        	try{
        	
        	    System.out.println("Tape zero for exit or any other number to proceed: ");
                Scanner input = new Scanner(System.in);
        	    controlTest = input.nextInt();
        	
        	}
        	
        	
        	catch(Exception e){
        	
        		System.out.println("Invalid Value , please try again ... \n");
        		controlTest=1;
        	}
        	
        }while(controlTest!=0);
		
		System.out.println("FIM!");
		
		
	}

}
