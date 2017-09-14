package v2ch09.aes;



public class CodeException extends Exception {
	public CodeException(String msg) {
		super(msg);
	}

	public CodeException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
