package datamanagement;

public class ListUnitsControl {
	private UnitManager unitMngr;

	/**
	 * Constructor setting unitMngr attribute to unit manager instance
	 */
	public ListUnitsControl() {
		unitMngr = UnitManager.getunitMngrInstance();
	}

	/**
	 * This method returns list of units available
	 * 
	 * @param unitLister
	 *            List holding unit codes
	 * 
	 */
	public void listUnits(IUnitLister unitLister) {
		unitLister.clearUnits();
		UnitMap units = unitMngr.getUnits();
		for (String s : units.keySet()) {
			unitLister.addUnit(units.get(s));
		}
	}
}
