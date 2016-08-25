package datamanagement;

import java.util.List;
import org.jdom.*;

/**
 * 
 * @author assumed This class creates and manages unit records
 *
 */
public class UnitManager {

	private static UnitManager self = null;
	private UnitMap unitHashMaps;

	/**
	 * 
	 * @return self Single instance of UnitManager Class
	 */
	public static UnitManager getunitMngrInstance() {
		if (self == null) {
			self = new UnitManager();
		}
		return self;
	}

	/*
	 * A private Constructor prevents any other class from instantiating.
	 */
	private UnitManager() {
		unitHashMaps = new UnitMap();
	}

	/**
	 * 
	 * @param unitCode
	 *            Variable passed to
	 * @return
	 */
	public IUnit getUnit(String unitCode) {
		IUnit iu = unitHashMaps.get(unitCode);
		return iu != null ? iu : createUnit(unitCode);
	}

	private IUnit createUnit(String unitCode) {
		IUnit iu;
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit"))
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList stuList;
				stuList = null;
				iu = new Unit(el.getAttributeValue("uid"), el.getAttributeValue("name"),
						Float.valueOf(el.getAttributeValue("ps")).floatValue(),
						Float.valueOf(el.getAttributeValue("cr")).floatValue(),
						Float.valueOf(el.getAttributeValue("di")).floatValue(),
						Float.valueOf(el.getAttributeValue("hd")).floatValue(),
						Float.valueOf(el.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(el.getAttributeValue("asg1wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("examwgt")).intValue(),
						StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));
				unitHashMaps.put(iu.getUnitCode(), iu);
				return iu;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	}

	/**
	 * 
	 * @return unitMaps Hashmap of selected unit id and
	 */
	public UnitMap getUnits() {
		UnitMap unitMaps;
		IUnit iu;
		unitMaps = new UnitMap();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit")) {
			iu = new UnitProxy(el.getAttributeValue("uid"), el.getAttributeValue("name"));
			unitMaps.put(iu.getUnitCode(), iu);
		} // unit maps are filled with PROXY units
		return unitMaps;
	}

}
