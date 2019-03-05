package andrade.dev.contas.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

public class RestResult {

	private Map<String, Object> result;
	private Message message;
	private boolean success;
	private Page<?> pagina;
	public RestResult() {
		
		this.result = new HashMap<String, Object>();
	}
	
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public void add(String key, Object value) {
		
		if(this.getResult() != null) {
			
			this.getResult().put(key, value);
		}
	}
	
	public void addPage(String key, Page<?> value) {
		
		if(this.getResult() != null) {
			
			if(value.hasContent()) {
				List<?> returnValue = value.getContent();
				this.getResult().put(key, returnValue);
			}
		}
	}
	
	public void handleException(Exception e) {
		
		if(e != null) {
			
			Message msg = Message.fail(e);
			this.setMessage(msg);
		}
	}
	
	
}
		