package datamanagement;

/*
 * Class to get and set Student marks based of their unit code and student id
 */
public class StudentUnitRecordProxy implements IStudentUnitRecord {
	private Integer studentId;
	private String unitCode;
	private StudentUnitRecordManager mngr;

	public StudentUnitRecordProxy(Integer id, String code) {
		this.studentId = id;
		this.unitCode = code;
		this.mngr = StudentUnitRecordManager.instance();
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

	public void setAsg1Marks(float mark) {
		mngr.getStudentUnitRecord(studentId, unitCode).setAsg1Marks(mark);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getAsg1Marks()
	 */
	public float getAsg1Marks() {
		return mngr.getStudentUnitRecord(studentId, unitCode).getAsg1Marks();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#setAsg2Marks(float)
	 */
	public void setAsg2Marks(float mark) {
		mngr.getStudentUnitRecord(studentId, unitCode).setAsg2Marks(mark);
	}

	public float getAsg2Marks() {
		return mngr.getStudentUnitRecord(studentId, unitCode).getAsg2Marks();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#setExamMarks(float)
	 */
	public void setExamMarks(float mark) {
		mngr.getStudentUnitRecord(studentId, unitCode).setExamMarks(mark);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getExamMarks()
	 */
	public float getExamMarks() {
		return mngr.getStudentUnitRecord(studentId, unitCode).getExamMarks();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see datamanagement.IStudentUnitRecord#getTotalMarks()
	 */
	public float getTotalMarks() {
		return mngr.getStudentUnitRecord(studentId, unitCode).getTotalMarks();
	}
}
