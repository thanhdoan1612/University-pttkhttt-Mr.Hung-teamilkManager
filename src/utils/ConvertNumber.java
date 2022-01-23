package utils;

public class ConvertNumber {
	public static String numberToPrice(int number) {
		StringBuilder price = new StringBuilder(String.valueOf(number));
		int l = price.length();
		int numberOfSplit = l % 3 != 0 ? l / 3 : l / 3 - 1;
		for (int i = numberOfSplit; i > 0; i--) {
			price.insert(price.length() - i * 3, ",");
		}
		return price.toString();
	}

	public static int priceToNumber(String price) {
		price = price.replace(",", "");
		int number = Integer.parseInt(price);
		return number;
	}

	public static String stringToSQLDate(String date) {
		String[] strArr = date.split("/");
		StringBuilder rs = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			rs.append(strArr[i]);
			if (i > 0)
				rs.append("-");
		}
		return rs.toString();
	}

	public static String sqlDateToString(String date) {
		String[] strArr = date.split("-");
		StringBuilder rs = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			rs.append(strArr[i]);
			if (i > 0)
				rs.append("/");
		}
		return rs.toString();
	}

	
}
