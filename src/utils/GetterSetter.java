package utils;

public class GetterSetter {

	public static String sEmailId;
	public static String sFName;
	public static String sLName;
	public static String sPass;
	public static String sCartAmount;
	public static String sCartValue;

	public static String getsCartValue() {
		return sCartValue;
	}

	public static void setsCartValue(String sCartValue) {
		GetterSetter.sCartValue = sCartValue;
	}

	public static String getsFName() {
		return sFName;
	}

	public static void setsFName(String sFName) {
		GetterSetter.sFName = sFName;
	}

	public static String getsLName() {
		return sLName;
	}

	public static void setsLName(String sLName) {
		GetterSetter.sLName = sLName;
	}

	public static String getsCartAmount() {
		return sCartAmount;
	}

	public static void setsCartAmount(String sCartAmount) {
		GetterSetter.sCartAmount = sCartAmount;
	}

	public static void setsPass(String sPass) {
		GetterSetter.sPass = sPass;
	}

	public static String getsPass() {
		return sPass;
	}

	public static String getsEmailId() {
		return sEmailId;
	}

	public static void setsEmailId(String sEmailId) {
		GetterSetter.sEmailId = sEmailId;
	}

}
