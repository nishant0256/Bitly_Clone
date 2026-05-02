package util;

public class Base62Encoder {
	
	 private static final String CHAR_SET =
	            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	    public static String encode(long id) {
	        StringBuilder shortCode = new StringBuilder();

	        while (id > 0) {
	            shortCode.append(CHAR_SET.charAt((int) (id % 62)));
	            id /= 62;
	        }

	        return shortCode.reverse().toString();
	    }

}
