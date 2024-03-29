import java.util.Arrays;

abstract public class Competitor {
	
	// instant variables 
	private int compNumber;			// Competitor's Number 
	private String compNameStart; 	// Competitor's Name 
	private String level;			// Competitor's Level 
	private int[] scores;			// Competitor's scores 
	
	//Constructor 
	public  Competitor(int CompetitorNumber, String CompetitorName, String CompetitorLevel, int[] Scores)
	{
		this.compNumber = CompetitorNumber;
		compNameStart = CompetitorName;
		level = CompetitorLevel;
		scores = Scores;
		
	}
	
	//Return Values 
	public Name getCompName() {
		Name compName = new Name(compNameStart);
		return compName;
	} 
	public int getCompetitorNumber(){			
		return compNumber;
	}	
	public int[] getScoreArray(){			
		return scores;
	}	
	public String getLevel(){			
		return level;
	}
	public int[] setScore(int game, int score) {
		scores[game] = score;
		return scores;
	}
	
	//Unique methods
	public abstract double getOverallScore();
	public abstract String getAttribute();
	public abstract String getAttributeName();
	
	//Details report; will be expanded later
	public String getFullDetails() {
		return "Level "+ getLevel()
				+ " competitor "+ getCompName().getFullName()
				+ " (Number " + compNumber + ")."
				+ "\nThey recieved the scores - " + Arrays.toString(getScoreArray())
				+ "; which gives an overall score of " 
				+ String.valueOf(getOverallScore()) + ".";
	}
	public String getShortDetails() {
		String shortDetail = "";
		shortDetail += "CN " + Integer.toString(getCompetitorNumber()) + " (" + getCompName().getInitials() + ") ";
		shortDetail += "who has overall score " + String.format("%-4.2f",getOverallScore()) + ".";
		return shortDetail;
	}
	

}
