package datamanagement;
/*
 * Interface to declare abstract methods to be defined later to 
 * get Student Id and unit code
 * set and get assignment and exam marks
 * get total marks for student
 */
public interface IStudentUnitRecord {
	/*
	 * Getter method declared to return Integer value for Student Id
	 */
    public Integer getStudentId();	
	/*
	 * Getter method declared to return String value for Unit code
	 */
    public String getUnitCode();
	/*
	 * Setter method declared to set Assignment1 marks
	 */
    public void setAsg1Marks(float mark);
    /*
	 * Getter method declared to get Assignment1 marks
	 */
    public float getAsg1Marks();
    /*
	 * Setter method declared to set Assignmen2 marks
	 */
    public void setAsg2Marks(float mark);
    /*
	 * Getter method declared to get Assignment2 marks
	 */
    public float getAsg2Marks();
    /*
	 * Setter method declared to set Exam marks
	 */
    public void setExamMarks(float mark);
    /*
	 * Getter method declared to get Exam marks
	 */
    public float getExamMarks();
    /*
	 * Getter method declared to get Total marks
	 */
    public float getTotalMarks();
}
