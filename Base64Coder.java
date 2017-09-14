package v2ch09.aes;


import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;

public class Base64Coder {
	public static final String ENCODING = "UTF-8";

	public static String encode2String(String data) throws CodeException {
		try {
			byte[] b = baseEncode(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new CodeException("不支持的系统编码", e);
		} catch (Exception e) {
			throw new CodeException("Base64编码出现错误", e);
		}
	}

	public static String encode(byte[] data) throws CodeException {
		try {
			byte[] b = baseEncode(data);
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new CodeException("不支持的系统编码", e);
		} catch (Exception e) {
			throw new CodeException("Base64编码出现错误", e);
		}
	}

	public static byte[] encode(String data) throws CodeException {
		try {
			return baseEncode(data.getBytes(ENCODING));
		} catch (UnsupportedEncodingException e) {
			throw new CodeException("不支持的系统编码", e);
		}
	}

	public static byte[] baseEncode(byte[] data) {
		return Base64.encodeBase64(data);
	}

	public static String decode2String(String data) throws CodeException {
		try {
			byte[] b = baseDecode(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new CodeException("不支持的系统编码", e);
		} catch (Exception e) {
			throw new CodeException("Base64解码出现错误", e);
		}
	}

	public static boolean isEncodeWithBase64(String data) throws CodeException {
		try {
			return Base64.isArrayByteBase64(data.getBytes(ENCODING));
		} catch (UnsupportedEncodingException e) {
			throw new CodeException("不支持的系统编码", e);
		}
	}

	public static byte[] baseDecode(byte[] data) {
		return Base64.decodeBase64(data);
	}

	public static String decode(byte[] data) throws CodeException {
		try {
			byte[] b = baseDecode(data);
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new CodeException("不支持的系统编码", e);
		} catch (Exception e) {
			throw new CodeException("Base64解码出现错误", e);
		}
	}

	public static byte[] decode(String data) throws CodeException {
		try {
			return baseDecode(data.getBytes(ENCODING));
		} catch (UnsupportedEncodingException e) {
			throw new CodeException("不支持的系统编码", e);
		}
	}

	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	public static String getBASE64_byte(byte[] s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s);
	}

	public static byte[] getByteArrFromBase64(String s) throws Exception {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Decoder()).decodeBuffer(s);
	}
}
