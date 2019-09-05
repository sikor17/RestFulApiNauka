package pl.helion;

public class ErrorMessage {

	private String errorMessages;
	private int errorCode;
	private String documentation;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String errorMessages, int errorCode, String documentation) {
		super();
		this.errorMessages = errorMessages;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

}
