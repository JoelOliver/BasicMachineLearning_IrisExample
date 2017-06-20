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
		
		   System.out.println("Welcome , below there are the instructions for test bench:\n"
		   		   + "- Tape two(2) for generate Data Training and Test;\n"
		           + "- three(3) for show the result of Nearest Neighbor Algorithm;\n"
		           + "- one(1) for normalize the Data Training and Test;\n"
		           + "- or zero (0) for exit;\n");		
        int controlTest = 1;
        do {
        	try{
        	    System.out.println("Tape an instruction:");
                Scanner input = new Scanner(System.in);
        	    controlTest = input.nextInt();
        	    
        	    if(controlTest == 1){
        	    	System.out.println("This function is in development !");
        	    }
        	    
        	    if(controlTest == 2){
        	    	tb.generateDataTrainingAndTest();
        	    }
        	    if(controlTest == 3){
        	    	tb.nearestNeighborAnalyse();
        	    }
        	
        	}
        	
        	
        	catch(Exception e){
        	
        		System.out.println("Invalid Value , please try again ... \n");
        		controlTest=1;
        	}
        	
        }while(controlTest!=0);
		
		System.out.println("FIM!");
		
		
	}

}
