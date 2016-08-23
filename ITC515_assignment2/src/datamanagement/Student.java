package datamanagement;

public class Student implements IStudent {
    private Integer id;
    private String firstName;
    private String lastName;
    private StudentUnitRecordList su;

public Student( Integer id, String firstName, String ln, StudentUnitRecordList su ) { 
	this.id = id; //declare variable for student id
	this.firstName = firstName;//declare variable for first name
    this.lastName = lastName;//declare variable for last name
    this.su = 
        su == null ? new StudentUnitRecordList() : 
                su;
}
//Declaration of function to get student Id
    public Integer getID() {
    	return this.id; 
} 
//Declaration of function to get student first name
    public String getFirstName() { 
    	return firstName; 
    	}
//Declaration of function to set the student first name
    public void setFirstName( String firstName ) { 
    	this.firstName = firstName; 
}
//Declaration of function to get the student last name
    public String getLastName() { 
    	return lastName; 
    }
//Declaration of function to set the student last name
    public void setLastName( String lastName ) { 
    	this.lastName = lastName;
    	}

public void addUnitRecord( IStudentUnitRecord record ) { su.add(record); }
        public IStudentUnitRecord getUnitRecord( String unitCode ) {
        	for ( IStudentUnitRecord r : su ) 
            if ( r.getUnitCode().equals(unitCode)) 
            	return r; 

        	return null;
        
}

public StudentUnitRecordList getUnitRecords() { return su; }}
