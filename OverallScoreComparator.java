import java.util.Comparator;

public class OverallScoreComparator implements Comparator<Competitor>
	{
		public int compare(Competitor c1, Competitor c2) {
			return (int) (c1.getOverallScore()*10 - c2.getOverallScore()*10);
		}
	}


