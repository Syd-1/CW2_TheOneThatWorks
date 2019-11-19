
public class VCACompetitor extends Competitor{
		
	private String nationality;
	
	public VCACompetitor(int CompetitorNumber, String CompetitorName, String CompetitorLevel, int[] Scores, String attribute) {
		super(CompetitorNumber,CompetitorName,CompetitorLevel, Scores);
		nationality = attribute;
		
	
	}
	public String getAttribute() {
		return nationality;
	}
	
	public void addScore(int value,  int ass ) {
		int index = ass-1;
		int[] Scores = super.getScoreArray();
	    Scores[index] = value;
	}
	
	public int getMaxScore() {
		int max = scores[0];
		int[] Scores = super.getScoreArray();
		for (int index = 1; index <Scores.length; index++) 
		{
			if (Scores[index] > max) {
				max = Scores[index];
			}
		}
		return max;
	}
	
	public int getMinScore() {
		int min = scores[0];
		int[] Scores = super.getScoreArray();
		for (int index = 1; index < Scores.length; index++) {
			if (Scores[index] < min) {
				min = Scores[index];
			}
		}
		return min;
	}
	
		public double getOverallScore() {
		int total = 0;
		int[] Scores = super.getScoreArray();
		for (int index = 0; index < Scores.length; index++) {
			total += Scores[index]; 
		}
		    total = total - this.getMaxScore() - this.getMinScore();
		
		return (double) total/(Scores.length-2);
	}
	
		public double getTotals() {
			int total= 0;
			int[] Scores = super.getScoreArray();
			for (int index = 0; index < Scores.length; index++) {
				total += Scores[index];
		}
		return (double) total;
		}
	
			
}
	
	
	
	


