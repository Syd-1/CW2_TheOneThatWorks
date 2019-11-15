import java.util.Arrays;
/** Software Engineering Foundations
* Based of scripts provided by Heriot-Watt University
* Assignment one
* @author Syd Colvin
*/
public class SHCCompetitor extends Competitor{
	
	// instant variables 
	private int compNumber;			// Competitor's Number 
	private String compNameStart; 	// Competitor's Name 
	private String level;			// Competitor's Level 
	private int[] scores;			// Competitor's scores 
	private int noWins; 			// Competitor's Number of Previous Wins
	int[] levels = {1, 2, 3, 4}; 	// Possible Levels
	
	//Constructor 
	public  SHCCompetitor(int CompetitorNumber, String CompetitorName, String CompetitorLevel, int[] Scores, int NoOfPrevWins)
	{
		super(CompetitorNumber, CompetitorName, CompetitorLevel, Scores);
		this.noWins = NoOfPrevWins;	
	}
		
	//Return Values 	
	public int getNumberOfWins(){
		return noWins;
	}
	
	public String getAttribute(){
		return String.valueOf(getNumberOfWins());
	}
	
	//Calculates overall score with penalty for higher levels
	public double getOverallScore() {
		int[] sA = new int[scores.length()];
		for (int i = 0; i < scores.length(); i++) {
			sA[i] = Character.getNumericValue(scores.charAt(i));
			}
		int sumScore = 0;		
		for (int index = 0; index < scores.length(); index++) {
			sumScore += sA[index];}				
		return (double) Math.round(sumScore*(11-level)*5/20)/10; 		
	}
	
	//Calculate score array
//	public int[] scoreArray() {
//		int[] sA = new int[scores.length()];
//		for (int i = 0; i < scores.length(); i++) {
//			sA[i] = Character.getNumericValue(scores.charAt(i));
//			}
//		return sA;		
//	}
//	//Score array in report format
//	public String getScoreArray() {
//	return Arrays.toString(scoreArray()).replaceFirst("]", "").replace("[", "");}
	


	
}