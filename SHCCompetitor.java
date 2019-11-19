import java.util.Arrays;

/** Software Engineering Foundations
* Based of scripts provided by Heriot-Watt University
* Assignment one
* @author Syd Colvin
*/
public class SHCCompetitor {
	
	// instant variables 
	private int compNumber;			// Competitor's Number 
	private String compNameStart; 	// Competitor's Name 
	private int level;				// Competitor's Level of
	private int noWins; 			// Competitor's Number of Previous Wins
	private int[] scores;			// Competitor's scores
	int[] levels = {1, 2, 3, 4}; 	// Possible Levels
	
	//Constructor 
	public SHCCompetitor(int CompetitorNumber, String CompetitorName, int CompetitorLevel, int NoOfPrevWins, int[] Scores)
	{
		this.compNumber = CompetitorNumber;
		compNameStart = CompetitorName;
		level = CompetitorLevel;
		noWins = NoOfPrevWins;	
		scores = Scores;
		
		try {
			if (this.level > 4)
				throw new Exception();
		}
		catch (Exception e){
			String error = e + " Level is set too high.";
			System.out.println(error);
		}
	}
		
	//Return Values 
	public Name getCompName() {
		Name compName = new Name(compNameStart);
		return compName;
	} 	
	public String getCN(){
		return Integer.toString(compNumber);
	}	
	public String getLevel(){
		return Integer.toString(level);
	}	
	public int getNumberOfWins(){
		return noWins;
	}
	
	//Calculate score array
	public int[] scoreArray() {
		int[] sA = new int[scores.length];
		for (int i = 0; i < scores.length; i++) {
			sA[i] = Character.getNumericValue(scores[i]);
			}
		return sA;		
	}
	//Score array in report format
	public String getScoreArray() {
	return Arrays.toString(scoreArray()).replaceFirst("]", "").replace("[", "");}
	
	//Calculates overall score with penalty for higher levels
	public double getOverallScore() {
		int[] sA = new int[scores.length];
		for (int i = 0; i < scores.length; i++) {
			sA[i] = Character.getNumericValue(scores[i]);
			}
		int sumScore = 0;		
		for (int index = 0; index < scores.length; index++) {
			sumScore += sA[index];}				
		return (double) Math.round(sumScore*(11-level)*5/20)/10; 		
	}

	//writes details
	public String getFullDetails() {
		return "Level "+ level 
				+ " competitor "+ getCompName().getFullName()
				+ " (Number " + compNumber + "),"
				+ " with " + noWins + " previous victories. "
				+ "\nThey recieved the scores - " + getScoreArray()
				+ "; which gives an overall score of " 
				+ getOverallScore() + ".";
	}
	public String getShortDetails() {
		return "CN " + compNumber + " (" 
				+ getCompName().getInitials() + ") who has overall score " 
				+ getOverallScore() + ".";
	}
		
}
