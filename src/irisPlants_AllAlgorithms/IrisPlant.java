/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Basic Machine Learning for Pattern Recognition/Data Mining 
 * All compiled algorithms :
      - Nearest Neighbor 
      - Nearest Centroid
      - Data Normalization
 */

package irisPlants_AllAlgorithms;

public class IrisPlant {

	private double sp []; // s-> sepal and p-> petal 
	                    /*sp[0] -> Lenght of Sepal (sl)
	                      sp[1] -> Weight of Sepal (sw)
	                      sp[2] -> Lenght of Petal (pl)
	                      sp[3] -> Weight of Petal (pw)
	                     */
	private String plantType; // type of plant -> (setosa, versicolor,virginica)
	private int id; // Identification of plant -> (  1    ,    2      ,   3    )
	
	// Initializing the instance
	public IrisPlant(double sl, double sw, double pl, double pw, String plantType){
		this.sp[0]=sl;
		this.sp[1]=sw;
		this.sp[2]=pl;
		this.sp[3]=pw;
		this.plantType=plantType;
	}

	// Getters and Setters
	
	protected double[] getSp() {
		return sp;
	}

	protected void setSp(double[] sp) {
		this.sp = sp;
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

	protected void setId(int id) {
		this.id = id;
	}
	
	
}
