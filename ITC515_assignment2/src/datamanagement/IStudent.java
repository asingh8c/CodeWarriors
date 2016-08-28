//get and set a person's ID, First name, Last name to the data management apllication
package datamanagement;

public interface IStudent {

	public Integer getId(); //variable declaration for getid

	public String getFirstName();//variable declaration for get first name

	public void setFirstName(String firstName); //

	public String getLastName();//variable declaration for get last name

	public void setLastName(String lastName); //set Last name

	public void addUnitRecord(IStudentUnitRecord record);

	public IStudentUnitRecord getUnitRecord(String unitCode);

	public StudentUnitRecordList getUnitRecords();

}