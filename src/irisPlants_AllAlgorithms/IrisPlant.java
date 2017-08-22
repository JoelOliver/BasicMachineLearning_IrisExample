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
import java.lang.*;

public class IrisPlant {

	private ArrayList<Double> sp ; // s-> sepal and p-> petal 
	                              /*  sp[0] -> Lenght of Sepal (sl)
	                                  sp[1] -> Weight of Sepal (sw)
	                                  sp[2] -> Lenght of Petal (pl)
	                                  sp[3] -> Weight of Petal (pw)
	                               */
	private String plantType; // type of plant -> (Setosa, Versicolor,Virginica, No-Identity)
	private int id; // Identification of plant -> (  1    ,    2      ,   3    ,     0      )
	
	// Initializing the instance
	public IrisPlant(double sl, double sw, double pl, double pw, String plantType){
		sp = new ArrayList<Double>();
		
		this.sp.add(sl);
		this.sp.add(sw);
		this.sp.add(pl);
		this.sp.add(pw);
		this.plantType=plantType;
		setId(plantType);
	}

	// Getters and Setters
	protected ArrayList<Double> getSp(){
		return this.sp;
	}
	
	protected String getSpString() {
		return "["+sp.get(0).toString()+" "+sp.get(1).toString()+" "+
	               sp.get(2).toString()+" "+sp.get(3).toString()+"]";
	}

	protected void setSp(double sl,double sw,double pl,double pw) {
        sp.set(0, sl);
        sp.set(1, sw);
        sp.set(2, pl);
        sp.set(3, pw);

	}

	protected String getPlantType() {
		return plantType;
	}

	protected void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	protected int getId() {
		return id;
	}

	protected void setId(String name) {
        
		if(name == "Setosa")
        	this.id=1;
        else if(name == "Versicolor")
        	this.id=2;
        else if(name == "Virginica")
        	this.id=3;
        else{
        	this.id=0;
        }
        
	}
	protected void setIdTest(int id){
		this.id=id;
	}
	
	
}
