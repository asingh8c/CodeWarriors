//It is a java programme for data management including several variables

package datamanagement;

public interface IStudent {

	public Integer getId(); 

	public String getFirstName();

	public void setFirstName(String firstName); //static method example 1

	public String getLastName();

	public void setLastName(String lastName);//static method example2

	public void addUnitRecord(IStudentUnitRecord record);//static method example3

	public IStudentUnitRecord getUnitRecord(String unitCode);

	public StudentUnitRecordList getUnitRecords();

}
