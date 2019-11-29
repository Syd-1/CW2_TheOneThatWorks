import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;  

public class CompetitorList {
	
	private ArrayList<Competitor> CompetitorList;
			
	public CompetitorList() {
		CompetitorList = new ArrayList<Competitor> (); }
	
	public void add(Competitor c) {CompetitorList.add(c); }
	/**
	 * Adds vcacompetitor to the list, if there is not already one there
	 * with the same ID
	 * @param c the Competitor to be added
	 * @return true if vcaCompetitor was added to the list,
	 	* false if already there 
	 */
	public boolean addOneCompetitor(Competitor c) {
				
		int CN = c.getCompetitorNumber();
		Competitor inList = this.findByCompNumber(CN);
		if (inList == null) {
			CompetitorList.add(c);
			return true;
			}
		return false;
	  }
	
	/**
	 * Returns report with one line per competitor
	 * Demonstrates traversing the array, getting one element at a time
	 * @return report 
	 */
	
	public String getTableOfCompetitors() {
		String report = ""; int i = 0;
				for (Competitor c  : CompetitorList) {
					if (i == 0){
						report += String.format("%-4s", "CN");
						report += String.format("%-30s", "Name");
						report += String.format("%-15s", "Level");
						report += String.format("%-20s", "Scores");
						report += String.format("%-10s", c.getAttributeName()+" \n");
					}	
					report += String.format("");
					report += String.format("%-4s", c.getCompetitorNumber());
					report += String.format("%-30s",c.getCompName().getFullName());
					report += String.format("%-15s", c.getLevel());
					report += String.format("%-20s", Arrays.toString(c.getScoreArray()));
					report += String.format("%-10s", c.getAttribute());
					report += "\n"; i++;
				}
				return report;	
			}
	
	public String getCompetitorReport(){
		String report = "";
		double maxScore = 0;
		String winner = "";
		for (Competitor c  : CompetitorList) {
			report += c.getShortDetails() + "\n";
			if (c.getOverallScore() > maxScore){
				maxScore = c.getOverallScore();
				winner = c.getShortDetails();
			}
		}
		report += "\n And the Winner is " + winner;
		return report;		
	}return report;		
	}
	  
	     /**Returns report with one line per competitor
	     * Demonstrates traversing the array, getting one element at a time
	     * @return report
	     */ 
	  /*public String getStatistical(){
	    	 
	    String report = "";
		//Title of table
			report += String.format("%-4s", "CN");
			report += String.format("%-30s", "Name");
			report += String.format("%-8s", "Level");
			report += String.format("%-20s", "Scores");
			report += "\n";
	     for (Competitor c : competitorList) {
	    		report += String.format("%-4s", c.getCompNumber());
			report += String.format("%-12s", c.getCompName().getInitials());
	    		report += String.format("%-8.1s", c.getMaxScore());
			report += String.format("%-8.1s", c.getMinScore());
			report += String.format("%-8.2f", c.getOverallScore());
			report += String.format("%-8.2f", c.getTotals());
			report += "\n";
	    	 }
	     return report;
	    }
	  */
	     /**
	      * return the higher average in the competition
	      * @return maximum score 
	      */
	  public double getWinnerAvg() {
		double maxScore = 0;
		  for (Competitor c : CompetitorList) {
			 if ( maxScore <= c.getOverallScore()) {
				  maxScore = c.getOverallScore();
			 }
		  }
		return maxScore;
	   }
	  
			/**
			 * return the competitor with the highest average
			 * @return competitor if is in the list,
			 	* return false if is not 
			 */
	  public Competitor getWinName() {
		  for (Competitor c : CompetitorList) {
			  if (c.getOverallScore() == this.getWinnerAvg()) {
			 return c;
			 }	
			}
		 return null;
		}
	  
			/**
			 * returns the competitor who result the winner in his level
			 * @param level
			 * @return competitor  if competitor is in  the list,
			 	* return null if is not
			 */
	  /**public Competitor getWinNameByLevel(int level) {
				
		  for (Competitor c : competitorList) {
			   if (c.getLevel() == level){
			   if (c.getOverallScore() == this.getWinnerAvg()) {
			  return c;
			  }
			}
		  }
		  return null;
		}
	  */
			/**
			 * returns the number of elements in the list			
			 * @return size
			 */
	  public int getSize() {
		  return CompetitorList.size();
		}
			/**
			 * returns the competitor object at specified index position
			 * @param index
			 * @return vcaCompetitor  at Index
			 */
			
	  public Competitor getAtIndex(int index) {
		  return CompetitorList.get(index);
		}
			
			/**
			 * Returns the Competitor object with a specific competitor number
			 * demonstrates searching through the array and stopping by returning when a match is found
			 * @param CN
			 * @return competitor by CompNumber
			 */
			
	  public Competitor findByCompNumber(int CN){
		  for (Competitor c : CompetitorList) {
			 if (c.getCompetitorNumber() == (CN)){ 
			 return c; }
			}
		  return null;
		}
			
			/**
			 * counts the number of competitors in a specified level
			 * @param level
			 * @return count of Competitors at requested level
			 */
//	  public int getCountOfCompetitorsAtLevel(int level) {
//		  int count = 0;
//			  for (Competitor c:CompetitorList) {
//			     if (c.getLevel()==level) {
//					 count++;}
//				}
//			 return count;
//			}
			
			/**
			 * writes supplied text to file	
			 * @param filename the name of the file to be written to 
			 * @param report the text to be written to the file
			 */
	  public void writeToFile(String filename, String report) {
		  FileWriter fw;
		  try {
			  fw = new FileWriter(filename);
			  fw.write("The report\n");
			  fw.write(report);
			  fw.close();
			  }
		  catch (FileNotFoundException fnf) {
			  System.out.println(filename + " not found ");
			  System.exit(0);
			  }
		  catch (IOException ioe) {
			  ioe.printStackTrace();
			  System.exit(1);
		  }
		}
				 /**
				  * reads file with given name, extracting competitor data, creating competitor objects 
				  * and adding them to the list of student
				  * Blank lines are skipped
				  * Validation for integer level,missing items
				  * @param filename the name of the input file
				  */
		  public void readFile (String filename) {
			  try {
				  File f = new File(filename);
				  Scanner scanner = new Scanner(f);
				  while (scanner.hasNextLine()) {
					  String inputLine = scanner.nextLine();
					  if (inputLine.length() != 0) { 
						  processLine(inputLine);
					  }					 
				  }
				  scanner.close();
			 }
					/**
					 * if the file is not found, stop with system exit
					 */					

			   catch (FileNotFoundException fnf){
						System.out.println( filename + " not found ");
						System.exit(0);
			  }
		  }
		  
	
				
				/**
				 * Processes line, extracts data, creates VCACompetitor object and adds to list
				 * Checks for non-numeric competitor number or level and missing items
				 * Will crash if name entered without a space
				 * @param line to be processed
				 * @return 
				 */
			private void processLine(String line) {
				try {
					String parts [] = line.split(",");
					int CompetitorNumber = Integer.parseInt(parts[0]);
					String CompetitorName = parts[1];
					String CompetitorLevel = parts[2];
					 int scoresLength = 5; //parts.length - 5;
					  int scores [] = new int [scoresLength]; 
					  for (int index = 0; index < scoresLength; index++) {
						  int i = index + 3;
						 scores[index] = Integer.parseInt(parts[i]);}
					String attribute = parts[8];//[parts.length-1];
						  
					//create Competitor object and add to the list
					//Competitor c = new Competitor(CompetitorNumber, CompetitorName, CompetitorLevel, scores);
					SHCCompetitor c = new SHCCompetitor(CompetitorNumber, CompetitorName, CompetitorLevel, scores, attribute);
					//STCompetitor c2 = new STCompetitor(CompetitorNumber, CompetitorName, CompetitorLevel, scores, attribute);
					this.add(c);
					//this.add(c2);	  
					//VCACompetitor c3 = new VCACompetitor(CompetitorNumber, CompetitorName, CompetitorLevel, scores, attribute);  
					//this.add(c3);

				}
				catch (ArrayIndexOutOfBoundsException air) {
					String error = "Not enough items in  : '" + line
					                        + "' index position : " + air.getMessage();
					System.out.println(error);
				}
				catch (NumberFormatException nfe) {
					String error = "Number conversion error in '" + line + "'  - " 
					                  + nfe.getMessage();
					System.out.println(error);
				}
			}
			
}



