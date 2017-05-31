/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Basic Machine Learning for Pattern Recognition/Data Mining 
 * Nearest Neighbor Algorithm for Normalized Dates
 */

package irisPlants_NormalizedNearestCentroidAlgorithm;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IrisPlant_NormalizedCentroid_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		NormCentroidIrisFloriculture iaFlower = new NormCentroidIrisFloriculture();
		
        iaFlower.addPlantaTeste("iris_teste.txt");
		
		int[] comp= {1,1,2,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,1,1,1,1,1,3,3,2,2,2,2};
		
		JTextArea textArea = new JTextArea(iaFlower.analisarTesteCentroideMaisProximo("Intelligent Floriculture" ,comp));
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 900, 600 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "------ IA-Floriculture ------",  
		                                       JOptionPane.DEFAULT_OPTION);

	}

}
