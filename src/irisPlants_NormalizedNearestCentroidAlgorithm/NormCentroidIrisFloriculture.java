/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Basic Machine Learning for Pattern Recognition/Data Mining 
 * Nearest Neighbor Algorithm for Normalized Dates
 */

package irisPlants_NormalizedNearestCentroidAlgorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NormCentroidIrisFloriculture {

	private ArrayList <IrisPlantNormalized> plantas_iris;
	private ArrayList <IrisPlantNormalized> plantas_iris_teste;

	
	public NormCentroidIrisFloriculture (){
       
		plantas_iris=new ArrayList<IrisPlantNormalized>();
		plantas_iris_teste=new ArrayList<IrisPlantNormalized>();
		
		try{
			FileInputStream in = new FileInputStream("iris_training.txt");
		    InputStreamReader inFormat = new InputStreamReader(in);
		    BufferedReader inString = new BufferedReader(inFormat);
	
		String l=null; 
		String dates[];
		int control=1;
		while((l=inString.readLine()) != null){
			dates=l.split(",");
			
			if(control<=40){
			plantas_iris.add(new IrisPlantNormalized(Double.parseDouble(dates[0]),Double.parseDouble(dates[1]),
					Double.parseDouble(dates[2]),Double.parseDouble(dates[3]),"Setosa"));
			}
			if(control>40 && control <=80){
			plantas_iris.add(new IrisPlantNormalized(Double.parseDouble(dates[0]),Double.parseDouble(dates[1]),
						Double.parseDouble(dates[2]),Double.parseDouble(dates[3]),"Versicolor"));
			}
			if(control>80 && control <=120){
				plantas_iris.add(new IrisPlantNormalized(Double.parseDouble(dates[0]),Double.parseDouble(dates[1]),
							Double.parseDouble(dates[2]),Double.parseDouble(dates[3]),"Virginica"));
			}
			control++;
			            
		               }
		
		}catch(IOException e){
			e.getMessage();
		}
					
	}
	
	public void addPlantaTeste(String arquivoTxt){
		try{
			FileInputStream in = new FileInputStream(arquivoTxt);
		    InputStreamReader inFormat = new InputStreamReader(in);
		    BufferedReader inString = new BufferedReader(inFormat);
	
		String l=null; 
		String dates[];
		while((l=inString.readLine()) != null){
			dates=l.split(",");
			
			plantas_iris_teste.add(new IrisPlantNormalized(Double.parseDouble(dates[0]),Double.parseDouble(dates[1]),
					Double.parseDouble(dates[2]),Double.parseDouble(dates[3]),"No-Identity"));
			            
		               }
		
		}catch(IOException e){
			e.getMessage();
		}
	}
	
    private IrisPlantNormalized centroideSetosa(){
		ArrayList <IrisPlantNormalized> setosas = new ArrayList <IrisPlantNormalized> ();
		IrisPlantNormalized centroideSetosa ;
		
		double sl_centroide = 0.0;
		double sw_centroide = 0.0;
		double pl_centroide = 0.0;
		double pw_centroide = 0.0;
		
		for (int i=0;i<plantas_iris.size();i++){
			if(plantas_iris.get(i).getName() == "Setosa"){
				setosas.add(plantas_iris.get(i));
			}
			
		}
		
		//System.out.println(setosas.size());

		
		for (int i=0;i<setosas.size();i++){
			
		//somando todas as coordenadas
			sl_centroide += setosas.get(i).getSl();
			sw_centroide += setosas.get(i).getSw();
			pl_centroide += setosas.get(i).getPl();
			pw_centroide += setosas.get(i).getPw();
		}
		
		// calculando a media de fato
		sl_centroide = sl_centroide/setosas.size() ;  sw_centroide = sw_centroide/setosas.size() ;
		pl_centroide = pl_centroide/setosas.size() ;  pw_centroide = pw_centroide/setosas.size() ;
		
		
		centroideSetosa=new IrisPlantNormalized(sl_centroide,sw_centroide,pl_centroide,pw_centroide,"Setosa");
		
		
	return centroideSetosa;}
	
	private IrisPlantNormalized centroideVersicolor(){
		ArrayList <IrisPlantNormalized> versicolors = new ArrayList <IrisPlantNormalized> ();
		IrisPlantNormalized centroideVersicolor ;
		
		double sl_centroide = 0.0;
		double sw_centroide = 0.0;
		double pl_centroide = 0.0;
		double pw_centroide = 0.0;
		
		for (int i=0;i<plantas_iris.size();i++){
			if(plantas_iris.get(i).getName() == "Versicolor"){
				versicolors.add(plantas_iris.get(i));

			}
			
		}
		

		
		for (int i=0;i<versicolors.size();i++){
			
		//somando todas as coordenadas
			sl_centroide += versicolors.get(i).getSl();
			sw_centroide += versicolors.get(i).getSw();
			pl_centroide += versicolors.get(i).getPl();
			pw_centroide += versicolors.get(i).getPw();
		}
		
		// calculando a media de fato
		sl_centroide = sl_centroide/versicolors.size() ;  sw_centroide = sw_centroide/versicolors.size() ;
		pl_centroide = pl_centroide/versicolors.size() ;  pw_centroide = pw_centroide/versicolors.size() ;
		
		
		centroideVersicolor=new IrisPlantNormalized(sl_centroide,sw_centroide,pl_centroide,pw_centroide,"Versicolor");
		
	return centroideVersicolor;}
	
	private IrisPlantNormalized centroideVirginica(){
		ArrayList <IrisPlantNormalized> virginicas = new ArrayList <IrisPlantNormalized> ();
		IrisPlantNormalized centroideVirginica ;
		
		double sl_centroide = 0.0;
		double sw_centroide = 0.0;
		double pl_centroide = 0.0;
		double pw_centroide = 0.0;
		
		for (int i=0;i<plantas_iris.size();i++){
			
			if(plantas_iris.get(i).getName() == "Virginica"){
				virginicas.add(plantas_iris.get(i));
			}
			
		}
		
		
		
		for (int i=0;i<virginicas.size();i++){
			
		//somando todas as coordenadas
			sl_centroide += virginicas.get(i).getSl();
			sw_centroide += virginicas.get(i).getSw();
			pl_centroide += virginicas.get(i).getPl();
			pw_centroide += virginicas.get(i).getPw();
		}
		
		// calculando a media de fato
		sl_centroide = sl_centroide/virginicas.size() ;  sw_centroide = sw_centroide/virginicas.size() ;
		pl_centroide = pl_centroide/virginicas.size() ;  pw_centroide = pw_centroide/virginicas.size() ;
		
		
		centroideVirginica=new IrisPlantNormalized(sl_centroide,sw_centroide,pl_centroide,pw_centroide,"Virginica");
		
	return centroideVirginica;}
	
	
    private double distEuclidiana(IrisPlantNormalized centroide,double new_sl,double new_sw,double new_pl,double new_pw){
		
		double distEuclidiana=Math.sqrt(Math.pow(new_sl - (centroide.getSl()), 2.0) 
                + Math.pow(new_sw - (centroide.getSw()), 2.0)
                + Math.pow(new_pl - (centroide.getPl()), 2.0)
                + Math.pow(new_pw - (centroide.getPw()), 2.0)); 
		
		return distEuclidiana;
	}
	
    
    public String centroideMaisProximo(IrisPlantNormalized planta_iris_teste){
    	// Considerando que ja poderia ser uma Setosa
    	String possivel_planta = "Setosa";
    	double menor_dist=distEuclidiana(centroideSetosa(),planta_iris_teste.getSl(),
    			                                           planta_iris_teste.getSw(),
    			                                           planta_iris_teste.getPl(),
    			                                           planta_iris_teste.getPw());
    	
    	if(menor_dist > distEuclidiana(centroideVersicolor(),planta_iris_teste.getSl(),
											                planta_iris_teste.getSw(),
											                planta_iris_teste.getPl(),
											                planta_iris_teste.getPw()) 
    			  || menor_dist > distEuclidiana(centroideVirginica(),planta_iris_teste.getSl(),
											                          planta_iris_teste.getSw(),
											                          planta_iris_teste.getPl(),
											                          planta_iris_teste.getPw()) ){
    		
    		
    		if (distEuclidiana(centroideVersicolor(),planta_iris_teste.getSl(),
									                    planta_iris_teste.getSw(),
									                    planta_iris_teste.getPl(),
									                    planta_iris_teste.getPw()) <
    		       distEuclidiana(centroideVirginica(),planta_iris_teste.getSl(),
							                           planta_iris_teste.getSw(),
							                           planta_iris_teste.getPl(),
							                           planta_iris_teste.getPw())   )
    			possivel_planta = "Versicolor";	 
    		else
    			possivel_planta = "Virginica";	       
    		
    	}
    	planta_iris_teste.setName(possivel_planta); 
    	planta_iris_teste.setId(possivel_planta);
        return possivel_planta;
     }

    public String analisarTesteCentroideMaisProximo(String nameFlori,int[] comp){
    	double hits= 0;
        String generalAnalysis = ">>>>>>                   Welcome to Floriculture: "+nameFlori + 
        		                 "                  <<<<<< \n\n";
		
		for(int i=0;i<plantas_iris_teste.size();i++){
			generalAnalysis+= "\n"+"Iris "+(i+1)+" Normalized : "+" "+
					    String.format("%.4f",(plantas_iris_teste.get(i).getSl())) +" "+
					    String.format("%.4f",(plantas_iris_teste.get(i).getSw())) +" "+
					    String.format("%.4f",(plantas_iris_teste.get(i).getPl())) +" "+
					    String.format("%.4f",(plantas_iris_teste.get(i).getPw())) 
					    +" \n"+
					    "Nearest Centroid : " + 
					    centroideMaisProximo(plantas_iris_teste.get(i));
					    
			
			if(plantas_iris_teste.get(i).getId() == comp[i]){
				hits ++;
				    generalAnalysis+="  [CORRECT Comparison] \n";
			}
			else{
				generalAnalysis+="\n";
			}
					    
		}	
		generalAnalysis+="\nHits : "+(int)hits+"\n"+"Percentage: "+
			               String.format("%.2f", (hits/plantas_iris_teste.size())*100) +" % \n";
		
    return generalAnalysis;
    }
}
