package util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	
	private static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	/** 序列化 */
	public static String writeValueAsString(Object value) {
		String json = "";
		try {
			json = objectMapper.writeValueAsString(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}

}
