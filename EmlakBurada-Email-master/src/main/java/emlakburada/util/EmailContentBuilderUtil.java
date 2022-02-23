package emlakburada.util;

public class EmailContentBuilderUtil {
	
	private static String template = "<p>Hoş geldin ${user},</p>\n<p>Bu mesaj Ramazan Kagan Ince tarafından gonderilmistir.</p>\\n" ;
	
	private EmailContentBuilderUtil() {
		
	}
	
	public static String build(String userName) {
		return template.replaceAll("\\$\\{*user\\}", userName.split("@")[0]);
	}

}
