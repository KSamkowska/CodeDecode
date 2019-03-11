package application;

public class Rle extends Main {

	public static String encode(String plainText) {
		StringBuilder encodeText = new StringBuilder();

		// if ( plainText.charAt(plainText.length())=",") {
		for (int i = 0; i < plainText.length(); i++) {
			int count = 1;
			while (i + 1 < plainText.length() && plainText.charAt(i) == plainText.charAt(i + 1)) {
				count++;
				i++;
			}

			encodeText.append(plainText.charAt(i));
			encodeText.append(count);
			encodeText.append(",");
		}
		return encodeText.toString();
		// .substring(0, encodeText.length()-1);

	}

	public static String decode(String encodeText) {

		StringBuilder decodeText = new StringBuilder();
		int size = 0;
		int i = 0;
		int j = 0;
		int z = 0;
		for (i = 0; i < encodeText.length(); i += z) {
			if (Character.isDigit(encodeText.charAt(i + 2)) == false) {
				z = 3;
				int k = Character.getName(encodeText.charAt(i + 1));
				size += (k);
				for (j = size - (k); j < size; j++) {
					decodeText.insert(j, encodeText.charAt(i));
				}
			} else if (Character.isDigit(encodeText.charAt(i + 2)) == true) {
				z = 4;
				int k = Character.getNumericValue(encodeText.charAt(i + 1));
				int m = Character.getNumericValue(encodeText.charAt(i + 2));
				size += (k * 10 + m);
				for (j = size - (k * 10 + m); j < size; j++) {
					decodeText.insert(j, encodeText.charAt(i));
				}
			}
		}

		return decodeText.toString();
	}
}