package datamanagement;

public class StudentProxy implements IStudent {
	private Integer id;
	private String firstName;
	private String lastName;
	private StudentManager studentList;

	public StudentProxy(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentList = StudentManager.getStudentManager();
	}

	public Integer getId() {
		return id;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {

		studentList.getStudent(id).setFirstName(firstName);
	}

	public void setLastName(String lastName) {

		studentList.getStudent(id).setLastName(lastName);
	}

	public void addUnitRecord(IStudentUnitRecord record) {
		studentList.getStudent(id).addUnitRecord(record);
	}

	public IStudentUnitRecord getUnitRecord(String unitCode) {

		return studentList.getStudent(id).getUnitRecord(unitCode);
	}

	public StudentUnitRecordList getUnitRecords() {
		return studentList.getStudent(id).getUnitRecords();
	}
}
