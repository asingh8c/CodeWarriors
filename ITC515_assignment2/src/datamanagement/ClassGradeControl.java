package datamanagement;

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
	}
}
