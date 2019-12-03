
	 /**
     * Subclass STCompetitor, Extends from the superclass "Competitor"
     * @param 	nationality The attribute	
     */   

public class STCompetitor extends Competitor {
   
	
	private String age;
	 /**
     * Set up the STCompetitor details
     * Inherits details from the superclass "Competitor"
     * @param 	age the additional attribute
     */
	//constructor
	public STCompetitor(int CompetitorNumber, String CompetitorName , String CompetitorLevel, int[] Scores, String attribute) {
		super(CompetitorNumber,CompetitorName, CompetitorLevel, Scores);
		age = attribute;

	}
	 /**
     * Abstract Method of getting STCompetitor's age
     */
	//Method to get Competitor's information
	public String getAttribute() { return age; }
	
	 /**
     * Abstract Method of getting the name of the attribute in STCompetitor "AGE"
     */
	public String getAttributeName() { return "AGE"; }

	 /**
     * Method of checking the level in STCompetitor
     * @return If level = Advanced / Expert return True
     * Return False if level = Beginner / Intermediate
     */
	//Method for checking level is needed
	public boolean checkLevel() {
		//see if Competitor has the level of Advanced / Expert
		//return True if advanced or expert
		String lev = super.getLevel();
		if (lev.contentEquals("Advanced")|lev.contentEquals("Expert")) {
			return true;}
		//return False for other case (Beginner / Intermediate)
		return false;
		
	}
	 /**
     * Abstract method for getting overall score
     * get the boolean result from checklevel()
     * Multiply by bonus for level advanced / expert
     * @return overall score
     */
	
	//Method to get the overall score
	//the overall score = (sum of all scores * mark of level / number of scores)
	//Level 1: Beginner (Total Score x 1); Level 2: Intermediate (Total Score x 1); 
	//Level 3: Advanced (Total Score x 1.2); Level 4: Expert (Total Score x 1.2)
	//assumes that all score entered, if not, 0 will be used for calculation.
	public double getOverallScore() {
		double total = 0;
		int[] sc = super.getScoreArray();
		for (int index = 0; index < sc.length; index ++) {
			total += sc[index];
		}
		// if Competitor has Advanced or Expert level, total score x 1.2
		if (this.checkLevel()) {
			total = total * 1.2;
		}
		//return overall score 
		return (double) total/sc.length;
	};
	
	
}
