package datamanagement;

/**
 * Interface to define methods used to add unit or clear units from interface
 * combo box for unit.
 * 
 * @author jtulip
 */
public interface IUnitLister {

	public void clearUnits(); // Clear the contents

	public void addUnit(IUnit unit); // Add new unit

}
