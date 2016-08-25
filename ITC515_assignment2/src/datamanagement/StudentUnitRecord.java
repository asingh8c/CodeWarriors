package datamanagement;

/**
 * Class to store and retrieve Student Id, Unit code, Assignment marks and final
 * exam marks
 * 
 * @author jtulip
 */
public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer studentId; // Attribute variable to store Student Id
	private String unitCode; // Attribute variable to store Unit Code
	private float asg1Marks, asg2Marks, examMarks; // Attribute variable to
													// store assignment marks
													// and exam marks

	/*
	 * Class constructor to initialize class attributes with values passed as
	 * argument
	 * 
	 * @param id student id
	 * 
	 * @param code unit code
	 * 
	 * @param asg1 assignment 1 marks
	 * 
	 * @param asg2 assignment 2 marks
	 * 
	 * @param exam final exam marks
	 */
	public StudentUnitRecord(Integer id, String code, float asg1, float asg2, float exam) {
		this.studentId = id;
		this.unitCode = code;
		this.setAsg1Marks(asg1);
		this.setAsg2Marks(asg2);
		this.setExamMarks(exam);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getStudentId()
	 */
	public Integer getStudentId() {
		return studentId;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getUnitCode()
	 */

	public String getUnitCode() {
		return unitCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#setAsg1Marks(float)
	 */
	public void setAsg1Marks(float a1) {
		if (a1 < 0 || a1 > UnitManager.getunitMngrInstance().getUnit(unitCode).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.asg1Marks = a1;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getAsg1Marks()
	 */

	public float getAsg1Marks() {
		return asg1Marks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#setAsg2Marks(float)
	 */
	public void setAsg2Marks(float a2) {
		if (a2 < 0 || a2 > UnitManager.getunitMngrInstance().getUnit(unitCode).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.asg2Marks = a2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getAsg2Marks()
	 */
	public float getAsg2Marks() {
		return asg2Marks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#setExamMarks(float)
	 */
	public void setExamMarks(float ex) {
		if (ex < 0 || ex > UnitManager.getunitMngrInstance().getUnit(unitCode).getExamWeight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.examMarks = ex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getExamMarks()
	 */
	public float getExamMarks() {
		return examMarks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getTotalMarks()
	 */
	public float getTotalMarks() {
		return asg1Marks + asg2Marks + examMarks;

	}
}
