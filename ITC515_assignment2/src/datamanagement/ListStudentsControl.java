package datamanagement;

public class ListStudentsControl {
	private StudentManager sm;
	
	public ListStudentsControl() {
		sm = StudentManager.getStudentManager();
	}

	public void listStudents(IStudentLister lister, String unitCode) {
		lister.clearStudents();
		StudentMap students = sm.getStudentsByUnit(unitCode);
		for (Integer id : students.keySet()){
			lister.addStudent(students.get(id));
		}
	}
}
