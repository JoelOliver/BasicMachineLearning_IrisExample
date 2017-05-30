/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Basic Machine Learning for Pattern Recognition/Data Mining 
 * Nearest Centroid Algorithm
 */

package basicMachineLearning_IrisPlants_NearestCentroidAlgorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CentroidIrisFloriculture {
	private ArrayList <IrisPlant> plantas_iris;
	private ArrayList <IrisPlant> plantas_iris_teste;

	
	// Instancia contendo a memoria (DATA BASE)
	public CentroidIrisFloriculture (){
       
		plantas_iris=new ArrayList<IrisPlant>();
		plantas_iris_teste=new ArrayList<IrisPlant>();
		
		try{
			FileInputStream entrada = new FileInputStream("iris.txt");
		    InputStreamReader entradaFormatada = new InputStreamReader(entrada);
		    BufferedReader entradaString = new BufferedReader(entradaFormatada);
	
		String l=null; 
		String dados[];
		int controle=1;
		while((l=entradaString.readLine()) != null){
			dados=l.split(",");
			
			if(controle<=40){
			plantas_iris.add(new IrisPlant(Double.parseDouble(dados[0]),Double.parseDouble(dados[1]),
					Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),"Setosa"));
			}
			if(controle>40 && controle <=80){
			plantas_iris.add(new IrisPlant(Double.parseDouble(dados[0]),Double.parseDouble(dados[1]),
						Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),"Versicolor"));
			}
			if(controle>80 && controle <=120){
				plantas_iris.add(new IrisPlant(Double.parseDouble(dados[0]),Double.parseDouble(dados[1]),
							Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),"Virginica"));
			}
			controle++;
			            
		               }
		
		}catch(IOException e){
			e.getMessage();
		}
					
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
			
			plantas_iris_teste.add(new IrisPlant(Double.parseDouble(dados[0]),Double.parseDouble(dados[1]),
					Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),"Nao-Identificavel"));
			            
		               }
		
		}catch(IOException e){
			e.getMessage();
		}
	}
	
    private IrisPlant centroideSetosa(){
		ArrayList <IrisPlant> setosas = new ArrayList <IrisPlant> ();
		IrisPlant centroideSetosa ;
		
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
		
		
		centroideSetosa=new IrisPlant(sl_centroide,sw_centroide,pl_centroide,pw_centroide,"Setosa");
		
		
	return centroideSetosa;}
	
	private IrisPlant centroideVersicolor(){
		ArrayList <IrisPlant> versicolors = new ArrayList <IrisPlant> ();
		IrisPlant centroideVersicolor ;
		
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
		
		
		centroideVersicolor=new IrisPlant(sl_centroide,sw_centroide,pl_centroide,pw_centroide,"Versicolor");
		
	return centroideVersicolor;}
	
	private IrisPlant centroideVirginica(){
		ArrayList <IrisPlant> virginicas = new ArrayList <IrisPlant> ();
		IrisPlant centroideVirginica ;
		
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
		
		
		centroideVirginica=new IrisPlant(sl_centroide,sw_centroide,pl_centroide,pw_centroide,"Virginica");
		
	return centroideVirginica;}
	
	
    private double distEuclidiana(IrisPlant centroide,double new_sl,double new_sw,double new_pl,double new_pw){
		
		double distEuclidiana=Math.sqrt(Math.pow(new_sl - (centroide.getSl()), 2.0) 
                + Math.pow(new_sw - (centroide.getSw()), 2.0)
                + Math.pow(new_pl - (centroide.getPl()), 2.0)
                + Math.pow(new_pw - (centroide.getPw()), 2.0)); 
		
		return distEuclidiana;
	}
	
    
    public String centroideMaisProximo(IrisPlant planta_iris_teste){
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

    	String generalAnalysis = ">>>>>>                   Welcome to Floriculture: "+nameFlori + "                  <<<<<< \n\n";
		
		for(int i=0;i<plantas_iris_teste.size();i++){
			generalAnalysis+= "\n"+"Iris "+(i+1)+" : "+" "+
		                plantas_iris_teste.get(i).getSl() +" "+
					    plantas_iris_teste.get(i).getSw() +" "+
		                plantas_iris_teste.get(i).getPl() +" "+
					    plantas_iris_teste.get(i).getPw() 
					    +" \n"+
					    "Centroide mais Proximo : " + 
					    centroideMaisProximo(plantas_iris_teste.get(i));
					    
			
			if(plantas_iris_teste.get(i).getId() == comp[i]){
				hits ++;
				    generalAnalysis+="  [Comparação CORRETA] \n";
			}
			else{
				generalAnalysis+="\n";
			}
					    
		}	
		generalAnalysis+="\nAcertos : "+(int)hits+"\n"+"Porcentagem: "+
			               String.format("%.2f", (hits/plantas_iris_teste.size())*100) +" % \n";
		
    return generalAnalysis;
    }

}
