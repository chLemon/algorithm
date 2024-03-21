package util;

import com.fasterxml.jackson.core.type.TypeReference;
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

	/**
	 * 反序列化
	 */
	public static <T> T readValue(String content, Class<T> valueType) {
		T res = null;
		try {
			if (content != null && !content.isEmpty()) {
				res = objectMapper.readValue(content, valueType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * 字符串反序列化成自定义对象
	 */
	public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
		T res = null;
		try {
			if (content != null && !content.equals("")) {
				res = objectMapper.readValue(content, valueTypeRef);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

}
