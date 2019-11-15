
public class VCACompetitor extedns Competitor {
	
	//private int CompNumber;
	//private Name compName;
	//private int [] scores;
	private static final int NUM_SCORES = 5;
	//private int level;
	private String nationality;
	
	public VCACompetitor( int CNum, Name CName, String nat, String lev, int [] SCORES) {
		//CompNumber = CNum;
		//compName = CName;
		//level = lev;
		super(CNum, CName, lev, SCORES)
		nationality = nat;
		//scores = SCORES;
	}
	
	//public int getCompNumber() {return CompNumber;}
	//public Name getCompName() {
	//	return compName;}
	
	//public String getLevel() {return level;}
	public String getNationality() {return nationality;}
	public void addScore(int value,  int ass ) {
		int index = ass-1;
	    scores[index] = value;
	}
	
	//public int [] getScoreArray() {
	//return scores;}
	
	public int getMaxScore() {
		int max = scores[0];
		for (int scoresIndex = 1; scoresIndex <scores.length; scoresIndex++) {
			if (scores[scoresIndex] > max) {
				max = scores[scoresIndex];
			}
		}
		return max;
	}
	
	public int getMinScore() {
		int min = scores[0];
		for (int scoresIndex = 1; scoresIndex <scores.length; scoresIndex++) {
			if (scores[scoresIndex] < min) {
				min = scores[scoresIndex];
			}
		}
		return min;
	}
		
	
		public double getOverallScore() {
		int total = 0;
		for (int scoresIndex = 0; scoresIndex < scores.length; scoresIndex++) {
			total += scores[scoresIndex]; 
		}
		    total = total - this.getMaxScore() - this.getMinScore();
		
		return (double) total/(scores.length-2);
	}
		public double getTotals() {
			int total= 0;
			for (int scoresIndex = 0; scoresIndex < scores.length; scoresIndex++) {
				total += scores[scoresIndex];
		}
		return (double) total;
		}
	
	//public void setCompNumber(int CN) {
		//CompNumber = CN;}
	//public void setLevel(int lv){
		//level = lv;}
	//public void setNationality(String nt){
		//nationality = nt;}
}
	
	
	
	
	
	
	


