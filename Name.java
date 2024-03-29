/** Software Engineering Foundations
* Script adapted from F21SF_Arrays1 tutorial, Heriot-Watt University 
* Last edited by: Syd Colvin
*/
public class Name {
  private String firstName;
  private String middleName;
  private String lastName;
  
  public Name(String fName, String lName) {
		firstName = fName;
		middleName = "";
		lastName = lName;
  }
  
  public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
}
  
  //Adapted to include names with only one name
  public Name (String fullName) {
	  int spacePos1 = fullName.indexOf(' ');
	  if (spacePos1 > 0){
		  firstName = fullName.substring(0, spacePos1);
		  int spacePos2 = fullName.lastIndexOf(' ');
		  if (spacePos1 == spacePos2){ 
			  middleName = "";
			  lastName = fullName.substring(spacePos1 + 1);}
		  else {
			  middleName = fullName.substring(spacePos1+1, spacePos2);
			  lastName = fullName.substring(spacePos2 + 1);}
	  }
	  else {
		  firstName = fullName; middleName = ""; lastName = "";
		}
  }
  
 //returns the first name, middle name and last name
  public String getFirstName() { return firstName; }
  public String getMiddleName() { return middleName; }
  public String getLastName() { return lastName; }
	
 //change the first name, middle name and last name to the value provided in the parameter 
  public void setFirstName(String fn) {
	  firstName = fn;
  }
  public void setMiddleName(String mn) {
	   middleName = mn;
  }
  public void setLastName(String ln) {
	  lastName = ln;
  }
  
  //returns the first name then a space then the last name
  public String getFirstAndLastName() {
		return firstName + " " + lastName;
  }
  //returns the last name followed by a comma then a space then the first name
  public String getLastCommaFirst() {
		return lastName + ", "+ firstName;
  }
  
 //returns the full name
  public String getFullName() {
	  String result = firstName + " ";
	  if (!middleName.equals("")) {
		  result += middleName + " ";
	  }
	  result += lastName;
	  return result;	  
  }
  
  //Added to find initials 
  public String getInitials() {
	 char i1 = firstName.charAt(0);
	 String inital3 ="";
	 if (!lastName.equals("")){
		 char i3 = lastName.charAt(0);
		 inital3 = Character.toString(i3);
	 }
	 String result = "";
	 String inital1 = Character.toString(i1);
	  if (middleName.equals("")) {
		  result = inital1 + inital3;}
	  else{
		  char i2 = middleName.charAt(0);
		  String inital2 = Character.toString(i2);
		  result = inital1 + inital2 + inital3;} 
	 return result;
  }
 //Added to compare to other name
     public int compareTo(Name other){
	  String thisName = lastName + " " + firstName + " " + middleName;
	  String othername = other.lastName + " " + other.firstName + " " + other.middleName;
	  
	  return thisName.compareTo(othername);
  }
 
}

