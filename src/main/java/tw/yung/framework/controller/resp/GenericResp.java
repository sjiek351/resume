package tw.yung.framework.controller.resp;

import java.util.HashMap;
import java.util.Map;

import tw.yung.framework.constant.Message;

public class GenericResp {
	public static final String MSG_CODE = "msgCode";
	public static final String MSG_INFO = "msgInfo";

	private Map<String, Object> message = new HashMap<>();

	public Map<String, Object> getMessage() {
		return message;
	}

	public void setMessage(Message message, String... params) {
		this.message.put(MSG_CODE, message.getCode());
		this.message.put(MSG_INFO, message.getInfo(params));
	}

}
