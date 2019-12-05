/**
     * Subclass VCACompetitor, Extends from the superclass "Competitor"
     * @param 	nationality The attribute	
     */ 
public class VCACompetitor extends Competitor{
		
	private String nationality;
	
	 /**
     * Set up the VCACompetitor details
     * Inherits details from the superclass "Competitor"
     * @param 	nationality The attribute	
     */    
	public VCACompetitor(int CompetitorNumber, String CompetitorName, String CompetitorLevel, int[] Scores, String attribute) {
		super(CompetitorNumber,CompetitorName,CompetitorLevel, Scores);
		nationality = attribute;
		}
	
	/**
     * Set up return methods	
     */    
	public String getAttribute() {
		return nationality;
	}
	public String getAttributeName() {
		return "Nationality";
	}
	
	/**
     * Add scores to the ScoreArray inherited from the superclass	
     */    
	public void addScore(int value,  int ass ) {
		int index = ass-1;
		int[] Scores = super.getScoreArray();
	    Scores[index] = value;
	}
	/**
     * Returns the maximum score
     * assumes first mark is the maximum for each mark
     */   
	public int getMaxScore() {
		int max = 0;
		int[] Scores = super.getScoreArray();
		for (int index = 1; index <Scores.length; index++) 
		{
			if (Scores[index] > max) {
				max = Scores[index];
			}
		}
		return max;
	}
	/**
     * Return the minimum score
     * assumes first mark is 0 in the beginning	
     */   
	public int getMinScore() {
		int min = 0;
		int[] Scores = super.getScoreArray();
		for (int index = 1; index < Scores.length; index++) {
			if (Scores[index] < min) {
				min = Scores[index];
			}
		}
		return min;
	}
	
	/**
     * Return the average mark
     * remove the maximum and minimum marks, then divide by number of marks minus two.
     * demonstrate forcing double division	
     */   
		public double getOverallScore() {
		int total = 0;
		int[] Scores = super.getScoreArray();
		for (int index = 0; index < Scores.length; index++) {
			total += Scores[index]; 
		}
		    total = total - this.getMaxScore() - this.getMinScore();
		
		return (double) total/(Scores.length-2);
	}
	
		/**
	     * Return the total score
	     * sum all the scores	
	     */   
		public double getTotals() {
			int total= 0;
			int[] Scores = super.getScoreArray();
			for (int index = 0; index < Scores.length; index++) {
				total += Scores[index];
		}
		return (double) total;
		}
	
			
}
	
	
	


