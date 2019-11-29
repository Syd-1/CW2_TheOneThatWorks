/** Software Engineering Foundations
* Based of scripts provided by Heriot-Watt University
* Assignment one
* @author Syd Colvin
*/
public class SHCCompetitor extends Competitor{
	
	// instant variables 
	private int noWins; 			// Competitor's Number of Previous Wins
	int[] levels = {1, 2, 3, 4}; 	// Possible Levels
	private int[] scores;			// Competitor's scores
	private int level;				// Competitor's Level of
	
	//Constructor 
	public  SHCCompetitor(int CompetitorNumber, String CompetitorName, String CompetitorLevel, int[] Scores, String attribute)
	{
		super(CompetitorNumber, CompetitorName, CompetitorLevel, Scores);
		this.noWins = Integer.parseInt(attribute);	
		this.scores = Scores;
	}
		
	//Return Values 	
	public int getNumberOfWins(){
		return noWins;
	}
	
	public String getAttribute(){
		return String.valueOf(getNumberOfWins());
	}
	
	public String getAttributeName(){
		return "NoWins";
	}
	
	//Calculates overall score with penalty for higher levels
	public double getOverallScore() {
		int sumScore = 0; 		
		for (int i = 0; i < scores.length-1; i++) {
			sumScore += scores[i];}				
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
