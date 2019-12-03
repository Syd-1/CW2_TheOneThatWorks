//Compares competitors on competitor name
import java.util.Comparator;


public class NameComparator implements Comparator<Competitor>
{
	public int compare(Competitor c1, Competitor c2) {
		return c1.getCompName().compareTo(c2.getCompName());
	}
}
