package datamanagement;

/*
 * The class set different states/values for the Application/User Interface. 
 * It also calls different function from different classes in the project to 
 * evaluate some values.
 * 
 * @author Prateek
 */
public class ClassGradeControl {
	ClassGradeUserInterface classUserInterface; // Creating object for
												// ClassGradeUserInterface
	String classUserCode = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public ClassGradeControl() {
	}

	// Creating a function execute() to set "false" values/states to Interface
	// which will be changed later in the program while validating the data
	public void execute() {
		classUserInterface = new ClassGradeUserInterface(this);
		classUserInterface.setState1(false);
		classUserInterface.setState2(false);
		classUserInterface.setState3(false);
		classUserInterface.setState4(false);
		classUserInterface.setState5(false);
		classUserInterface.setState6(false);
		classUserInterface.Refresh3();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(classUserInterface);
		classUserInterface.setVisible(true);
		classUserInterface.setState1(true);
	}

	// Validating the code entered and displaying it if it is correct and not
	// equal to "NONE"
	public void unitSelected(String code) {

		if (code.equals("NONE"))
			classUserInterface.setState2(false); // If the code is "NONE" then
													// keep the state to false
		else {
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(classUserInterface, code);
			classUserCode = code;
			classUserInterface.setState2(true); // Else change the state to true
		}
		classUserInterface.setState3(false);
	}

	// Validating the code entered and displaying it if it is correct by setting
	// the state to true
	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			classUserInterface.Refresh3();
			classUserInterface.setState3(false);
			classUserInterface.setState4(false);
			classUserInterface.setState5(false);
			classUserInterface.setState6(false);
		}

		else {
			IStudent student = StudentManager.get().getStudent(id);

			IStudentUnitRecord record = student.getUnitRecord(classUserCode);

			classUserInterface.setRecord(record);
			classUserInterface.setState3(true);
			classUserInterface.setState4(true);
			classUserInterface.setState5(false);
			classUserInterface.setState6(false);
			changed = false;

		}
	}

	// Validating the code entered and displaying it if it is correct by setting
	// the state to true
	public String checkGrade(float marksAssignment1, float marksAssignment2, float marksExam) {
		IUnit unit = UnitManager.UM().getUnit(classUserCode);
		String grade = unit.getGrade(marksAssignment1, marksAssignment2, marksExam);
		classUserInterface.setState4(true);
		classUserInterface.setState5(false);
		if (changed) {
			classUserInterface.setState6(true);
		}
		return grade;
	}

	public void enableChangeMarks() {
		classUserInterface.setState4(false);
		classUserInterface.setState6(false);
		classUserInterface.setState5(true);
		changed = true;
	}

	// Validating the code entered and displaying it if it is correct by setting
	// the state to true
	public void saveGrade(float asg1, float asg2, float exam) {

		// IUnit unit = UnitManager.UM().getUnit(classUserCode);
		IStudent student = StudentManager.get().getStudent(currentStudentID);

		IStudentUnitRecord record = student.getUnitRecord(classUserCode);
		record.setAsg1Marks(asg1);
		record.setAsg2Marks(asg2);
		record.setExamMarks(exam);
		StudentUnitRecordManager.instance().saveRecord(record);
		classUserInterface.setState4(true);
		classUserInterface.setState5(false);
		classUserInterface.setState6(false);
	}
}
