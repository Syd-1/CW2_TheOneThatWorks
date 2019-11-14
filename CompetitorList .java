
import java.util.ArrayList;
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
		competitorList = new ArrayList<VCACompetitor> (); }
	
	public void add(Competitor c) {competitorList.add(c); }
	/**
	 * Adds vcacompetitor to the list, if there is not already one there
	 * with the same ID
	 * @param c the VCACompetitor to be added
	 * @return true if vcaCompetitor was added to the list,
	 	* false if already there 
	 */
	public boolean addOneCompetitor(Competitor c) {
				
		int CN = c.getCompNumber();
		Competitor inList = this.findByCompNumber(CN);
		if (inList == null) {
			competitorList.add(c);
			return true;
			}
		return false;
	  }
	
	/**
	 * Returns report with one line per vcaCompetitor
	 * Demonstrates traversing the array, getting one element at a time
	 * @return report 
	 */
	
	public String getTableOfCompetitors() {
				String report = "CN    NAME                        NATIONALITY        LEVEL        SCORES       \n";
				
				for (Competitor c  : competitorList) {
					report += String.format("");
					report += String.format("%-4s", c.getCompNumber());
					report += String.format("%-30s", c.getCompName().getFullName());
					report += String.format("%-20s", c.getNationality());
					report += String.format("%-8d", c.getLevel());
					report += String.format("%-20s", Arrays.toString(c.getScoreArray()));
					report += "\n";
				}
				return report;	
			}
	
		    /**
		     * Returns report with one line per vcaCompetitor
		     * Demonstrates traversing the array, getting one element at a time
		     * @return report
		     */
	 public String getFullInfo(){
	   String report = "FULL DETAILS OF THE COMPETITORS \n";
	   for (Competitor c : competitorList) {
	     report += String.format("%-100s", c.getFullDetails());
	     report += "\n";
	    }
	    return report;
	   }
	 
	       /**Returns report with one line per person
		     * Demonstrates traversing the array, getting one element at a time
		     * @return report
		     */
	  public String getShortInfo(){
	    String report = "SHORT DETAILS OF THE COMPETITORS \n";
	    for (Competitor c : competitorList) {
	     report += String.format("%-50s", c.getShortDetails());
	     report += "\n";
	    }
	    return report;
	   }
	  
	     /**Returns report with one line per vcaCompetitor
	     * Demonstrates traversing the array, getting one element at a time
	     * @return report
	     */ 
	  public String getStatistical(){
	    	 
	    String report = "CN   INIT      MAX     MIN       AVG     TOTAL    \n";
	    	 
	     for (Competitor c : competitorList) {
	    		 report += String.format("");
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
	  
	     /**
	      * return the higher average in the competition
	      * @return maximum score 
	      */
	  public double getWinnerAvg() {
		double maxScore = 0;
		  for (VCACompetitor c : competitorList) {
			 if ( maxScore <= c.getOverallScore()) {
				  maxScore = c.getOverallScore();
			 }
		  }
		return maxScore;
	   }
	  
			/**
			 * return the competitor with the highest average
			 * @return vcaCompetitor if is in the list,
			 	* return false if is not 
			 */
	  public Competitor getWinName() {
		  for (Competitor c : competitorList) {
			  if (c.getOverallScore() == this.getWinnerAvg()) {
			 return c;
			 }	
			}
		 return null;
		}
	  
			/**
			 * returns the competitor who result the winner in his level
			 * @param level
			 * @return vcaCompetitor  if vcaCompetitor is in  the list,
			 	* return null if is not
			 */
	  public Competitor getWinNameByLevel(int level) {
				
		  for (Competitor c : competitorList) {
			   if (c.getLevel() == level){
			   if (c.getOverallScore() == this.getWinnerAvg()) {
			  return c;
			  }
			}
		  }
		  return null;
		}
	  
			/**
			 * returns the number of elements in the list			
			 * @return size
			 */
	  public int getSize() {
		  return competitorList.size();
		}
			/**
			 * returns the VCACompetitor object at specified index position
			 * @param index
			 * @return vcaCompetitor  at Index
			 */
			
	  public Competitor getAtIndex(int index) {
		  return competitorList.get(index);
		}
			
			/**
			 * Returns the VCACompetitor object with a specific competitor number
			 * demonstrates searching through the array and stopping by returning when a match is found
			 * @param CN
			 * @return vcaCompetitor by CompNumber
			 */
			
	  public Competitor findByCompNumber(int CN){
		  for (Competitor c : competitorList) {
			 if (c.getCompNumber() == (CN)){ 
			 return c; }
			}
		  return null;
		}
			
			/**
			 * counts the number of vcaCompetitors in a specified level
			 * @param level
			 * @return count of VCAcompetitors at requested level
			 */
	  public int getCountOfCompetitorsAtLevel(int level) {
		  int count = 0;
			  for (Competitor c:competitorList) {
			     if (c.getLevel()==level) {
					 count++;}
				}
			 return count;
			}
			
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
				 */
		  private void processLine(String line) {
			  String levelNum = "";
			  String compNum = "";
				  try {
				  String parts [] = line.split(",");
				  compNum = parts[0];
				  compNum = compNum.trim();
			      int CN = Integer.parseInt(compNum);
				  Name name = new Name(parts[1]);
				  String nationality = parts[2];
				  levelNum = parts[3];
				  levelNum = levelNum.trim();
				  int level = Integer.parseInt(levelNum);
				  int scoresLength = parts.length - 4;
				  String SCORES [] = new String[scoresLength];
				  System.arraycopy(parts, 4, SCORES, 0, scoresLength);
				  int scores [] = new int [scoresLength]; 
				  for (int index = 0; index < scoresLength; index++) {
					  scores[index] = Integer.parseInt(SCORES[index].trim());
				  }
						
				  Competitor c = new Competitor(CN, name, nationality,level, scores);
				  this.add(c);
			  }
				  
					/**
					 * this catches trying to convert a String to an integer
					 */
			  catch (NumberFormatException nfe) {
				  String error = "Number conversion error in '" + line + "' -" + nfe.getMessage();
				  System.out.println(error);
			  }
				  
					/**
					 * This catches missing items if only one or two items
					 * other omissions will result in other errors
					 */
			  catch (ArrayIndexOutOfBoundsException air) {
				  String error = "Not enough items in  : '" + line + "' index position : " 
						 + air.getMessage();
				  System.out.println(error);
			  }
		  }				
}

