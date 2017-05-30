/* @autor : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Basic Machine Learning for Pattern Recognition/Data Mining 
 */

package basicMachineLearning_IrisPlants_NearestNeighborAlgorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IrisFloriculture {

	private ArrayList <IrisPlant> plants_iris;
	private ArrayList <IrisPlant> plants_iris_test;
	
	public IrisFloriculture (){
		plants_iris=new ArrayList<IrisPlant>();
		plants_iris_test=new ArrayList<IrisPlant>();
		
		try{
			FileInputStream in = new FileInputStream("iris.txt");
		    InputStreamReader inFormat = new InputStreamReader(in);
		    BufferedReader inString = new BufferedReader(inFormat);
	
		String l=null; 
		String dates[];
		int count=1;
		while((l=inString.readLine()) != null){
			dates=l.split(",");
			
			if(count<=40){
			plants_iris.add(new IrisPlant(Double.parseDouble(dates[0]),Double.parseDouble(dates[1]),
					Double.parseDouble(dates[2]),Double.parseDouble(dates[3]),"Setosa"));
			}
			if(count>40 && count <=80){
			plants_iris.add(new IrisPlant(Double.parseDouble(dates[0]),Double.parseDouble(dates[1]),
						Double.parseDouble(dates[2]),Double.parseDouble(dates[3]),"Versicolor"));
			}
			if(count>80 && count <=120){
				plants_iris.add(new IrisPlant(Double.parseDouble(dates[0]),Double.parseDouble(dates[1]),
							Double.parseDouble(dates[2]),Double.parseDouble(dates[3]),"Virginica"));
			}
			count++;
			            
		               }
		
		}catch(IOException e){
			e.getMessage();
		}
	}
	
		
	public ArrayList <IrisPlant> listOfPlantsTest(){
		return plants_iris_test;
	}
	
	public void addPlantaTeste(String arquivoTxt){
		try{
			FileInputStream entrada = new FileInputStream(arquivoTxt);
		    InputStreamReader entradaFormatada = new InputStreamReader(entrada);
		    BufferedReader entradaString = new BufferedReader(entradaFormatada);
	
		String l=null; 
		String dados[];
		while((l=entradaString.readLine()) != null){
			dados=l.split(",");
			
			plants_iris_test.add(new IrisPlant(Double.parseDouble(dados[0]),Double.parseDouble(dados[1]),
					Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),"No-Identity"));
			            
		               }
		
		}catch(IOException e){
			e.getMessage();
		}
	}
	
    private double distEuclidian(int index,double new_sl,double new_sw,double new_pl,double new_pw){
		
		double distEuclidian=Math.sqrt(Math.pow(new_sl - (plants_iris.get(index).getSl()), 2.0) 
                + Math.pow(new_sw - (plants_iris.get(index).getSw()), 2.0)
                + Math.pow(new_pl - (plants_iris.get(index).getPl()), 2.0)
                + Math.pow(new_pw - (plants_iris.get(index).getPw()), 2.0)); 
		
		return distEuclidian;
	}

    private int vizinhoMaisProximo(IrisPlant plant_iris_test){
	// Calculo da Distancia Euclidiana supondo a primeira fruta do catalogo como mais proxima da que deve ser reconhecida
	 double smaller_distance=distEuclidian(0,plant_iris_test.getSl(),plant_iris_test.getSw() ,plant_iris_test.getPl(), 
			 plant_iris_test.getPw());
     double distance;
     int index_smaller_distance=0;
     
     for (int i=1;i<plants_iris.size();i++){
	    	distance=distEuclidian(i,plant_iris_test.getSl(),plant_iris_test.getSw() ,plant_iris_test.getPl(), 
	    			plant_iris_test.getPw());
	    	if(distance < smaller_distance){
	    		smaller_distance = distance ;
	    		index_smaller_distance = i;
	    		plant_iris_test.setName(plants_iris.get(i).getName());
	    		plant_iris_test.setId(plants_iris.get(i).getName());

	    	    }
	         }
     
     return index_smaller_distance;
     
}
  
    public String analisarTesteVizinhoMaisProximo(String nameFlori,int[] comp){
    	double hits = 0;
		double percentage;
		String generalAnalyse = ">>>>>>                   Welcome to Floriculture: "+nameFlori + "                  <<<<<< \n\n";
		
		for(int i=0;i<plants_iris_test.size();i++){
			generalAnalyse+= "\n"+"Iris "+(i+1)+" : "+" "+
					plants_iris_test.get(i).getSl() +" "+
					plants_iris_test.get(i).getSw() +" "+
					plants_iris_test.get(i).getPl() +" "+
					plants_iris_test.get(i).getPw() 
					    
					+" \n"+
					
					"Nearest Neighbor : " +
					 plants_iris.get(vizinhoMaisProximo(plants_iris_test.get(i))).getSl() +" "+
				     plants_iris.get(vizinhoMaisProximo(plants_iris_test.get(i))).getSw() +" "+
				     plants_iris.get(vizinhoMaisProximo(plants_iris_test.get(i))).getPl() +" "+
					 plants_iris.get(vizinhoMaisProximo(plants_iris_test.get(i))).getPw() +" "+
				     plants_iris.get(vizinhoMaisProximo(plants_iris_test.get(i))).getName() ;
				
			if(plants_iris_test.get(i).getId() == comp[i]){
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
}
