import javax.swing.JOptionPane;
public class VCACompetitorManager {
	
	private VCACompetitorList allVCACompetitors;
	public VCACompetitorManager () {
		allVCACompetitors = new VCACompetitorList();
	}
	public void run() {
		allVCACompetitors.readFile("VCACompetitors.csv");
		System.out.println("XXIX INTERNATIONAL YOUNG GYMNASTICS COMPETITION. Male Competitors results \n");
		System.out.println();
		String report = allVCACompetitors.getTableOfVCACompetitors();
		allVCACompetitors.writeToFile("CompetitorsOut.txt", report);
		
		System.out.println();
		System.out.println(allVCACompetitors.getTableOfVCACompetitors());
		
		System.out.println();
		System.out.println();
		System.out.println("STATISTICAL");
		System.out.println(allVCACompetitors.getStatistical());
		System.out.println();
		System.out.println();
		System.out.println("There are " + allVCACompetitors.getCountOfVCACompetitorsAtLevel(2) + " people in level 2 or sub-18");
		System.out.println("There are " + allVCACompetitors.getCountOfVCACompetitorsAtLevel(3) + " people in level 3 or sub-16");
		System.out.println();
		System.out.println();
		System.out.println("WINNERS");
		System.out.println("The person with the highest score at level 2 is " + allVCACompetitors.getWinNameByLevel(2).getCompName().getFirstAndLastName());
		System.out.println();
		System.out.println(allVCACompetitors.getWinNameByLevel(2).getFullDetails());
		System.out.println();
		System.out.println();
		System.out.println("The person with the highest score at level 3 is " + allVCACompetitors.getWinNameByLevel(3).getCompName().getFirstAndLastName());
		System.out.println();
		System.out.println(allVCACompetitors.getWinNameByLevel(3).getFullDetails());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(allVCACompetitors.getFullInfo());
		System.out.println();
		System.out.println();
		System.out.println(allVCACompetitors.getShortInfo());
		
	    boolean ok = false;
		int count = 0;
		while(!ok && count <3) {
			try{
			String compNum = JOptionPane.showInputDialog("Enter CN");
			int CompNum = Integer.parseInt(compNum);
			VCACompetitor c = allVCACompetitors.findByCompNumber(CompNum); 
			count++;
			if (c!=null){
				String lastName = c.getCompName().getLastName();
				System.out.println(c.getShortDetails());
				ok = true;
			}
			else {
				System.out.println("Incorrect competitor number");
				if (count <= 3) {
					System.out.println("Try again");
				}
			}
		}
	
		catch (NumberFormatException nfe){
			String error = "Number converson error  -" + nfe.getMessage();
			System.out.println(error);
		}
			
		}
	}
}


