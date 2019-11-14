
public class STCompetitor extends Competitor {
	
	// instance variables Syd waz here ;)
	Private int age;
	private String gender;
	private String Nationality;
	
	//constructor
	public STCompetitor(int id, Name n, String l, int a, String g, String c, int[] sc) {
		super(id, n, l, sc);
		age = a;
		gender = g;
		country = c;
	}
	
	//Method to get Competitor's information
	//Level 1: Beginner; Level 2: Intermediate; Level 3: Advanced; Level 4: Expert
	public int getAge() { return age; }
	public String getGender() { return gender; }
	public String getNationality() { return Nationality; }
	

	
	//Method for checking level is needed
	public boolean checkLevel() {
		//see if Competitor has the level of Advanced / Expert
		//return True if advanced or expert
		String lev = this.getLevel();
		if (lev.contentEquals("Advanced")|lev.contentEquals("Expert")) {
			return true;}
		//return False for other case (Beginner / Intermediate)
		return false;
		
	}
	
	
	//Method to get the overall score
	//the overall score = (sum of all scores * mark of level / number of scores)
	//Level 1: Beginner (Total Score x 1); Level 2: Intermediate (Total Score x 1); 
	//Level 3: Advanced (Total Score x 1.2); Level 4: Expert (Total Score x 1.2)
	//assumes that all score entered, if not, 0 will be used for calculation.
	public double getOverallScore() {
		double total = 0;
		for (int scoreIndex = 0; scoreIndex < scores.length; scoreIndex ++) {
			total += scores[scoreIndex];
		}
		// if Competitor has Advanced or Expert level, total score x 1.2
		if (this.checkLevel()) {
			total = total * 1.2;
		}
		//return overall score 
		return (double) total/scores.length;
	};
	
	
	

	
	
}
