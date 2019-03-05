package andrade.dev.contas.result;

public class Message {

	private String type;
	private String Message;
		
	public Message() {
		
		
	}	
	
	public Message(String type, String message) {
		super();
		this.type = type;
		Message = message;
	}


	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getMessage() {
		return Message;
	}
	
	public void setMessage(String message) {
		Message = message;
	}
	
	public static Message success(String message) {
		
		return new Message("success", message);
	}
	
	public static Message warning(String message) {
		
		return new Message("warning", message);
	}
	
	public static Message fail(String message) {
		
		return new Message("danger", message);
	}
	
	public static Message info(String message) {
		
		return new Message("success", message);
	}
	
	public static Message fail(Exception ex) {
		
		if(ex != null) {
			
			String msg = ex.getMessage();
			ex.printStackTrace();
			return fail(msg);
		}
		
		return null;
	}
	
}
