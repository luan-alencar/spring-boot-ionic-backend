package david.augusto.luan.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String msg) {
		super(msg);
	}

	public DataIntegrityViolationException(String msg, Throwable thr) {
		super(msg, thr);
	}
}
