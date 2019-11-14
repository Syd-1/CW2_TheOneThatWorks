
public class VCACompetitor {
	
	private int CompNumber;
	private Name2 compName;
	private int [] scores;
	private static final int NUM_SCORES = 5;
	//private int level;
	private String nationality;
	
	public VCACompetitor(int CNum, Name2 CName, String nat, int lev, int [] SCORES) {
		CompNumber = CNum;
		compName = CName;
		level = lev;
		nationality = nat;
		scores = SCORES;
	}
	
	public int getCompNumber() {return CompNumber;}
	public Name2 getCompName() {
		return compName;}
	
	public int getLevel() {return level;}
	public String getNationality() {return nationality;}
	public void addScore(int value,  int ass ) {
		int index = ass-1;
	    scores[index] = value;
	}
	
	public int [] getScoreArray() {
	return scores;}
	
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
		
	
		public double getAverageScore() {
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
		
		public String getFullDetails() {
			String fullDetails = "";
			fullDetails += "Competitor number " + this.getCompNumber() + ", name " + this.getCompName().getFullName() + ", from " + this.getNationality() 
			+ ". \n " + this.getCompName().getFirstName() + " is in level "+ this.getLevel() + " and has an overall score of "  + String.format("%-4.1f",this.getAverageScore()) + "\n";
			return fullDetails;
		}
		public String getShortDetails() {
			String shortDetails = "";
			shortDetails += "CN " + this.getCompNumber() + "(" + this.getCompName().getInitials() + ")" + " has an overall score " + String.format("%-4.1f",this.getAverageScore()) + "." + "\n";
			return shortDetails;
		}
		
	
	public void setCompNumber(int CN) {
		CompNumber = CN;}
	public void setLevel(int lv){
		level = lv;}
	public void setNationality(String nt){
		nationality = nt;}
}
	
	
	
	
	
	
	


