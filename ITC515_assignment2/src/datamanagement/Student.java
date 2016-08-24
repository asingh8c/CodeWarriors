package datamanagement;

public class Student implements IStudent {
	private Integer id;//declare variable for student id
	private String fn;//declare variable for first name
	private String ln;//declare variable for last name
	private StudentUnitRecordList su;

	public Student(Integer id, String fn, String ln, StudentUnitRecordList su) {
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.su = su == null ? new StudentUnitRecordList() : su;
	}
	//Declaration of function to get student Id
	public Integer getID() {
		return this.id;
	}
	//Declaration of function to get student first name
	public String getFirstName() {
		return fn;
	}
	//Declaration of function to set the student first name
	public void setFirstName(String firstName) {
		this.fn = firstName;
	}
	//Declaration of function to get the student last name
	public String getLastName() {
		return ln;
	}
	//Declaration of function to set the student last name
	public void setLastName(String lastName) {

		this.ln = lastName;
	}

	public void addUnitRecord(IStudentUnitRecord record) {
		su.add(record);
	}

	public IStudentUnitRecord getUnitRecord(String unitCode) {
		for (IStudentUnitRecord r : su)
			if (r.getUnitCode().equals(unitCode))
				return r;

		return null;

	}

	public StudentUnitRecordList getUnitRecords() {
		return su;
	}
}
