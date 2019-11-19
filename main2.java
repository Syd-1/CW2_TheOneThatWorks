
public class main2 {
	
	public static void main(String[] args) {
	CompetitorList c = new CompetitorList();
	c.readFile("competitor.csv");
	System.out.println(c.getTableOfCompetitors());

	}			//	n2.writeToFile("CompetitorsOut.txt", report);

}
