import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
	}
	     /**Returns report with one line per competitor
	     * Demonstrates traversing the array, getting one element at a time
	     * @return report
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
			
//Show Level & ID for GUI	  
		public String showLevel(){
			String list = ""; int i = 0;
			for (Competitor c  : CompetitorList) {
			if (i == 0){
				list += String.format("%-4s", "CN");
				list += String.format("%-15s", "Level");
				list += "\n";
			}	
			list += String.format("%-4s", c.getCompetitorNumber());
			list += String.format("%-15s", c.getLevel());
			list += "\n"; i++;
			}
			list += "\n";
			return list;
		}	
		
		//Show OverallScore & ID for GUI	
		public String showOverallScore(){
			String list = ""; int i = 0;
			for (Competitor c  : CompetitorList) {
				if (i == 0){
					list += String.format("%-4s", "CN");
					list += String.format("%-10s", "Overall Score");
					list += "\n";
				}	
				list += String.format("%-4s", c.getCompetitorNumber());
				list += String.format("%-10.2f", c.getOverallScore());
				list += "\n"; i++;
			}
			return list;	
		}
		
	    public String listDetails()
	    {
	    	String allEntries = "CN  Surname   Forename   Middlename";
	        for(Competitor c : CompetitorList) {
	        	allEntries += "\n";
	        	allEntries += String.format("%-4s", c.getCompetitorNumber());
	        	allEntries += String.format("%-10s",c.getCompName().getLastName());
	        	allEntries += String.format("%-10s", c.getCompName().getFirstName()) + String.format("%-10s", c.getCompName().getMiddleName());
	        }
	        return allEntries;
	    }
		

	    public String listByName()
	    {
	    	Collections.sort(CompetitorList, new NameComparator());
	    	return this.listDetails();
	    }

	    public String CNList() { 
			  String list ="CN  NAME";
			  List<Double> CNList = new ArrayList();
			  int NoComps = CompetitorList.size();
			  for (Competitor c  : CompetitorList) {
				 double n = c.getCompetitorNumber();
				 CNList.add(n);			
				}
			  Collections.sort(CNList);
			  for (int i = 0; i < NoComps; i++){
				  double CNdouble = CNList.get(i);
				  int CNint = (int) Math.round(CNdouble);
				  for (Competitor n : CompetitorList) {
						 if (n.getCompetitorNumber() == (CNint)){ 
							 list += "\n";
							 list += String.format("%-4s", n.getCompetitorNumber());
							 list += String.format("%-20s",n.getCompName().getFullName());							 
							}
						}
				  }  
			  return list;
	} 
	  //Method return the competitor details in VCACompetitor 
	    //By Sheron
	  public String showvcalist(){
		    String vlist = ""; 
     		int i = 0;
		  for (Competitor c : CompetitorList){
			  if (c instanceof VCACompetitor){
				  if (i == 0){
						vlist += String.format("%-4s", "CN");
						vlist += String.format("%-30s", "Name");
						vlist += String.format("%-15s", "Level");
						vlist += String.format("%-20s", "Scores");
						vlist += String.format("%-10s", c.getAttributeName());
						vlist += "\n";
						i++;
				  		}
						vlist += String.format("%-4s", c.getCompetitorNumber());
						vlist += String.format("%-30s",c.getCompName().getFullName());
						vlist += String.format("%-15s", c.getLevel());
						vlist += String.format("%-20s", Arrays.toString(c.getScoreArray()));
						vlist += String.format("%-10s", c.getAttribute());
						vlist += "\n";
					}
			 }
		  return vlist;	
		  }
	  //Method return the competitor details in SHCCompetitor 
	    //By Sheron
	  public String showshclist(){
		    String sclist = ""; 
   		int i = 0;
		  for (Competitor c : CompetitorList){
			  if (c instanceof SHCCompetitor){
				  if (i == 0){
						sclist += String.format("%-4s", "CN");
						sclist += String.format("%-30s", "Name");
						sclist += String.format("%-15s", "Level");
						sclist += String.format("%-20s", "Scores");
						sclist += String.format("%-10s", c.getAttributeName());
						sclist += "\n";
						i++;
				  		}
						sclist += String.format("%-4s", c.getCompetitorNumber());
						sclist += String.format("%-30s",c.getCompName().getFullName());
						sclist += String.format("%-15s", c.getLevel());
						sclist += String.format("%-20s", Arrays.toString(c.getScoreArray()));
						sclist += String.format("%-10s", c.getAttribute());
						sclist += "\n";
					}
			 }
		  return sclist;	
		  }
	  //Method return the competitor details in STCompetitor
	    //By Sheron
	  public String showstlist(){
		    String slist = ""; 
   		int i = 0;
		  for (Competitor c : CompetitorList){
			  if (c instanceof STCompetitor){
				  if (i == 0){
						slist += String.format("%-4s", "CN");
						slist += String.format("%-30s", "Name");
						slist += String.format("%-15s", "Level");
						slist += String.format("%-20s", "Scores");
						slist += String.format("%-10s", c.getAttributeName());
						slist += "\n";
						i++;
				  		}
						slist += String.format("%-4s", c.getCompetitorNumber());
						slist += String.format("%-30s",c.getCompName().getFullName());
						slist += String.format("%-15s", c.getLevel());
						slist += String.format("%-20s", Arrays.toString(c.getScoreArray()));
						slist += String.format("%-10s", c.getAttribute());
						slist += "\n";
					}
			 }
		  return slist;	
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
			  char compType = filename.charAt(0);
			  File f = new File(filename);
			  Scanner scanner = new Scanner(f);
			  while (scanner.hasNextLine()) {
				  String inputLine = scanner.nextLine();
				  if (inputLine.length() != 0) { 
					  processLine(inputLine, String.valueOf(compType));
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
		private void processLine(String line, String type) {
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
					if (type.equals("C")){
					SHCCompetitor c = new SHCCompetitor(CompetitorNumber, CompetitorName, CompetitorLevel, scores, attribute);
					this.add(c);}
					else if (type.equals("A")){
					VCACompetitor c = new VCACompetitor(CompetitorNumber, CompetitorName, CompetitorLevel, scores, attribute);
					this.add(c);}
					else if (type.equals("T")){
					STCompetitor c = new STCompetitor(CompetitorNumber, CompetitorName, CompetitorLevel, scores, attribute);
					this.add(c);}	
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



