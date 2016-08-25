package datamanagement;

import org.jdom.*;
import java.util.List;

/**
 * This class defines getter, setter the student information when unit code,
 * student id are chosen in user interface. It also creates new student record
 * as element
 * 
 * @author jtulip
 */
public class StudentManager {
	private static StudentManager self = null;

	private StudentMap stuMap; // Store student key value map
	private java.util.HashMap<String, StudentMap> unitMap; // Store unit key
															// value map

	private StudentManager() { // constructor to initialize attributes
		stuMap = new StudentMap();
		unitMap = new java.util.HashMap<>();
	}

	public static StudentManager getStudentManager() { // getter method to get
														// active instance of
														// StudenManager class
		if (self == null) {
			self = new StudentManager();
		}
		return self;
	}

	public IStudent getStudent(Integer id) { // Returns the map key values of
												// student
		IStudent iStu = stuMap.get(id);
		return (iStu != null ? iStu : createStudent(id));
	}

	private Element getStudentElement(Integer id) { // Fetch the student data
													// from xml by id and return
													// the element
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable")
				.getChildren("student"))
			if (id.toString().equals(el.getAttributeValue("sid"))) {
				return el;
			}
		return null;
	}

	private IStudent createStudent(Integer id) { // Create student if it doesn't
													// exist in student map
													// collection
		IStudent iStu;
		Element e = getStudentElement(id);
		if (e != null) {
			StudentUnitRecordList rList = StudentUnitRecordManager.instance().getRecordsByStudent(id);
			iStu = new Student(new Integer(e.getAttributeValue("sid")), e.getAttributeValue("fname"),
					e.getAttributeValue("lname"), rList);

			stuMap.put(iStu.getId(), iStu);
			return iStu;
		}
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	private IStudent createStudentProxy(Integer id) {//
		Element el = getStudentElement(id);
		if (el != null) {
			return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
		}
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	public StudentMap getStudentsByUnit(String unitCode) { // return map
															// collections of
															// student for a
															// particular unit
		StudentMap sMap = unitMap.get(unitCode);
		if (sMap != null) {
			return sMap;
		}
		sMap = new StudentMap();
		IStudent iStudent;
		StudentUnitRecordList unitRecord = StudentUnitRecordManager.instance().getRecordsByUnit(unitCode);
		for (IStudentUnitRecord i : unitRecord) {
			iStudent = createStudentProxy(new Integer(i.getStudentId()));
			sMap.put(iStudent.getId(), iStudent);
		}
		unitMap.put(unitCode, sMap);
		return sMap;
	}
}
