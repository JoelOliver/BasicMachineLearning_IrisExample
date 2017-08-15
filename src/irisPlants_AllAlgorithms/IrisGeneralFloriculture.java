/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Basic Machine Learning for Pattern Recognition/Data Mining 
 * All compiled algorithms :
      - Nearest Neighbor 
      - Nearest Centroid
      - Data Normalization
 */

package irisPlants_AllAlgorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class IrisGeneralFloriculture {
   
	private ArrayList <IrisPlant> plants_iris; // this array contains the FULL Data Base Origin
	private ArrayList <IrisPlant> plants_iris_training; // this array contains the random Data for training 
	private ArrayList <IrisPlant> plants_iris_test; // this array contains the random Data for test
	private ArrayList < Integer > comparatorIds;  // this array contains the Ids of Data Test for comparation in algorithm
	
	public IrisGeneralFloriculture (){
		
		plants_iris = new ArrayList<IrisPlant>();
		plants_iris_training = new ArrayList<IrisPlant>();
		plants_iris_test = new ArrayList<IrisPlant>();
		comparatorIds= new ArrayList<Integer>();

		
	    /* Below , its the routine to read the file of FULL Data Base Origin (-PlantsIris_DB.txt-) to allocate
         *in plants_iris array.		
		 */
		try{
			FileInputStream in = new FileInputStream("FullDataBase_IrisPlant.txt");
		    InputStreamReader inFormat = new InputStreamReader(in);
		    BufferedReader inString = new BufferedReader(inFormat);
	
		String l=null; 
		String data[];
		int count=1;
		while((l=inString.readLine()) != null){
			data=l.split(",");
			
			if(count<=48){
			plants_iris.add(new IrisPlant(Double.parseDouble(data[0]),Double.parseDouble(data[1]),
					Double.parseDouble(data[2]),Double.parseDouble(data[3]),"Setosa"));
			}
			if(count>48 && count <=96){
			plants_iris.add(new IrisPlant(Double.parseDouble(data[0]),Double.parseDouble(data[1]),
						Double.parseDouble(data[2]),Double.parseDouble(data[3]),"Versicolor"));
			}
			if(count>96){
			plants_iris.add(new IrisPlant(Double.parseDouble(data[0]),Double.parseDouble(data[1]),
							Double.parseDouble(data[2]),Double.parseDouble(data[3]),"Virginica"));
			}
			count++;
			            
		           }
		
		}catch(IOException e){
			e.getMessage();
			System.out.println("Erro na leitura do arquivo!");
		}
	}
	
	// The return of Full Data Base of Plant Iris allocated in plants_iris Array
    protected void listaPlantaIris() {
  	     for(int i=0;i<plants_iris.size();i++){
  		   System.out.println(plants_iris.get(i).getSp() + " "+
  				              plants_iris.get(i).getPlantType() + " "+
  				              plants_iris.get(i).getId());
  	   }
	}
    
    /* For test of Basic Machine learning , the DataTrainingAndTestGenerate() method separates 80% of the data for training and 20% 
       for test from the Full DataBase plants_iris array.
     * Concludes that the plants_iris_training will contain 117 samples and 
       plants_iris_test will contain 27 samples arranged equally for each type of iris plant 
     * However , for a better test bench , these are generate randomly using the Random class.
     */
    protected void generateDataTrainingAndTest(){
    	ArrayList <IrisPlant> plants_iris_temp =  plants_iris;
    	Random random = new Random();
    	int randomNum;
    	
    	/* The three for conditions to separate equal the 20% for data test in plants_iris_test*/
    	
    	// separating 20% only Setosas for test ...
    	int min1=0; int max1=47;      
    	    for(int i=0;i<9;i++){
    	       randomNum=random.nextInt((max1-min1) + 1) + min1;
    		   this.plants_iris_test.add(plants_iris_temp.get(randomNum));
    		   this.plants_iris_test.get(i).setPlantType("No-Identity");
    		   comparatorIds.add(plants_iris_temp.get(randomNum).getId());
    		   plants_iris_test.get(i).setIdTest(0);
    		   plants_iris_temp.remove(randomNum);
    		   max1=max1-1;
    	     }
    	// separating 20% only Versicolors for test ...   
    	int min2=max1+1; int max2=min2+47;
	    	for(int i=9;i<18;i++){
	 	       randomNum=random.nextInt((max2-min2) + 1) + min2;
	 		   this.plants_iris_test.add(plants_iris_temp.get(randomNum));
    		   this.plants_iris_test.get(i).setPlantType("No-Identity");
    		   comparatorIds.add(plants_iris_temp.get(randomNum).getId());
    		   plants_iris_test.get(i).setIdTest(0);
	 		   plants_iris_temp.remove(randomNum);
	 		   max2=max2-1;
	 	     }
	     // separating 20% only Virginicas for test ...
	     int min3=max2+1; int max3=min3+47;
	    	for(int i=18;i<27;i++){
	 	       randomNum=random.nextInt((max3-min3) + 1) + min3;
	 		   this.plants_iris_test.add(plants_iris_temp.get(randomNum));
    		   this.plants_iris_test.get(i).setPlantType("No-Identity");
    		   comparatorIds.add(plants_iris_temp.get(randomNum).getId());
    		   plants_iris_test.get(i).setIdTest(0);
	 		   plants_iris_temp.remove(randomNum);
	 		   max3=max3-1;
	 	     }
	    	
	    	
	    	// the 80% rest is allocated in plants_iris_training
	    	this.plants_iris_training = plants_iris_temp;
	    	
	    	System.out.println("**Data Training and Test generated **");
       } 
    
    protected void listTrainingAndTest(){
    	if (!plants_iris_training.isEmpty()){
    		System.out.println("Training data: \n");
    		for (int i=0;i<plants_iris_training.size();i++){
    			System.out.println(plants_iris_training.get(i).getSp()+" "+ 
	                               plants_iris_training.get(i).getPlantType()+" "+
	                               plants_iris_training.get(i).getId()+"\n");
    		}
    	}
    	
    	if(!plants_iris_test.isEmpty()){
    		System.out.println("Test data: \n");
    		for (int i=0;i<plants_iris_test.size();i++){
    			System.out.println(plants_iris_test.get(i).getSp()+" "+ 
                                   plants_iris_test.get(i).getPlantType()+" "+
                                   plants_iris_test.get(i).getId()+"\n");
    		}
    	}
    	if(plants_iris_test.isEmpty() || plants_iris_training.isEmpty()){
    		System.out.println("** There is no Data for test , please load it **");
    	}
    }
    
    //This method clean the arrays of training and test to use at test bench
    protected void cleanDataTrainingAndTest(){
    	plants_iris_test.clear();
    	plants_iris_training.clear();
    	comparatorIds.clear();
    	System.out.println("**The training and test Data was cleaned **\n");
    }

    protected String nearestNeighborAnalyse(){
    	double hits = 0;
		double percentage;
		String generalAnalyse = "";
		
		for(int i=0;i<plants_iris_test.size();i++){
			generalAnalyse+= "\n"+"Iris "+(i+1)+" : "
		                          +plants_iris_test.get(i).getSpString()
				            	  +" \n"+
					         "Nearest Neighbor : " 
					              +plants_iris_training.get(nearestNeighbor(plants_iris_test.get(i))).getSpString();
				
			if(plants_iris_test.get(i).getId() == comparatorIds.get(i)){
				    hits ++;
				    generalAnalyse+="  [CORRECT Comparison] \n";
			}
			else{
				generalAnalyse+="\n";
			}
					    
		}	
		generalAnalyse+="\nHits : "+(int)hits+"\n"+"Porcentagem: "+
			               String.format("%.2f", (hits/plants_iris_test.size())*100) +" % \n";
		
    return generalAnalyse;
    }
    
    private double distEuclidian(int index,IrisPlant new_iris){
		
		double distEuclidian=Math.sqrt(Math.pow(new_iris.getSp().get(0) - (plants_iris_training.get(index).getSp().get(0)), 2.0) 
                + Math.pow(new_iris.getSp().get(1) - (plants_iris_training.get(index).getSp().get(1)), 2.0)
                + Math.pow(new_iris.getSp().get(2) - (plants_iris_training.get(index).getSp().get(2)), 2.0)
                + Math.pow(new_iris.getSp().get(3) - (plants_iris_training.get(index).getSp().get(3)), 2.0)); 
		
		return distEuclidian;
	}

    private int nearestNeighbor(IrisPlant plant_iris_test){
	// Calculo da Distancia Euclidiana supondo a primeira fruta do catalogo como mais proxima da que deve ser reconhecida
	 double smaller_distance=distEuclidian(0,plant_iris_test);
     double distance;
     int index_smaller_distance=0;
     
     for (int i=1;i<plants_iris_training.size();i++){
	    	distance=distEuclidian(i,plant_iris_test);
	    	if(distance < smaller_distance){
	    		smaller_distance = distance ;
	    		index_smaller_distance = i;
	    		plant_iris_test.setPlantType(plants_iris_training.get(i).getPlantType());
	    		plant_iris_test.setId(plants_iris_training.get(i).getPlantType());

	    	    }
	         }
     
     return index_smaller_distance;

    
}
    
    
}
