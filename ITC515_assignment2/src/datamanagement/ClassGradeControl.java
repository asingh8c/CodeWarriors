package datamanagement;

<<<<<<< HEAD
/**
 * Class used to store and set GUI states
 * 
 * @author jtulip
 */
public class ClassGradeControl {
	ClassGradeUi clsGrdUi;
	String currentUnitCode = null;
	Integer currentStudentID = null;
	boolean changed = false;

	/**
	 * Default constructor
	 */
	public ClassGradeControl() {
	}

	/**
	 * Method sets initial state of all GUI components Called by main function
	 * to create and display class Grade GUI.
	 */
	public void execute() {
		clsGrdUi = new ClassGradeUi(this);
		clsGrdUi.setState1(false);
		clsGrdUi.setState2(false);
		clsGrdUi.setState3(false);
		clsGrdUi.setState4(false);
		clsGrdUi.setState5(false);
		clsGrdUi.setState6(false);
		clsGrdUi.Refresh3();
		clsGrdUi.setVisible(true);
		clsGrdUi.setState1(true);

		ListUnitsControl listUnitCntrl = new ListUnitsControl();
		listUnitCntrl.listUnits(clsGrdUi);
	}

	/**
	 * This method sets the state
	 * 
	 * @param code
	 */
	public void unitSelected(String unitCode) {
		if (unitCode.equals("NONE")) {
			clsGrdUi.setState2(false);
		} else {
			ListStudentsControl lsCTL = new ListStudentsControl();
			lsCTL.listStudents(clsGrdUi, unitCode);
			currentUnitCode = unitCode;
			clsGrdUi.setState2(true);
		}
		clsGrdUi.setState3(false);
	}

	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			clsGrdUi.Refresh3();
			clsGrdUi.setState3(false);
			clsGrdUi.setState4(false);
			clsGrdUi.setState5(false);
			clsGrdUi.setState6(false);
		}

		else {
			IStudent s = StudentManager.getStudentManager().getStudent(id);
			IStudentUnitRecord r = s.getUnitRecord(currentUnitCode);

			clsGrdUi.setRecord(r);
			clsGrdUi.setState3(true);
			clsGrdUi.setState4(true);
			clsGrdUi.setState5(false);
			clsGrdUi.setState6(false);
			changed = false;
		}
	}

	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.getunitMngrInstance().getUnit(currentUnitCode);
		String s = u.getGrade(f, g, h);
		clsGrdUi.setState4(true);
		clsGrdUi.setState5(false);
		if (changed) {
			clsGrdUi.setState6(true);
		}
		return s;
	}

	public void enableChangeMarks() {
		clsGrdUi.setState4(false);
		clsGrdUi.setState6(false);
		clsGrdUi.setState5(true);
		changed = true;
	}

	public void saveGrade(float asg1, float asg2, float exam) {

		IUnit u = UnitManager.getunitMngrInstance().getUnit(currentUnitCode);
		IStudent s = StudentManager.getStudentManager().getStudent(currentStudentID);
		IStudentUnitRecord r = s.getUnitRecord(currentUnitCode);

		r.setAsg1Marks(asg1);
		r.setAsg2Marks(asg2);
		r.setExamMarks(exam);

		StudentUnitRecordManager.instance().saveRecord(r);

		clsGrdUi.setState4(true);
		clsGrdUi.setState5(false);
		clsGrdUi.setState6(false);
=======
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
>>>>>>> Prateek
	}
}
