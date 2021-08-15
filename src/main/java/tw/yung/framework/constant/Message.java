package tw.yung.framework.constant;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * <pre>
 * Resp 訊息區
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-12
 * @version 2021-08-12 崔永昀
 */
public enum Message {
	// = Complete =
	C001("C001", "{0}成功!"), //
	C002("C002", "{0}完成!"), //
	// = Waring =
	W001("W001", "必填欄位不可為空白!"), //
	// = Error =
	E001("E001", "程式執行例外錯誤!"), //
	E002("E002", "{0}失敗!");
	// ===

	private String code;
	private String info;

	private Message(String code, String info) {
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public String getInfo(String... params) {
		Object[] arguments = Arrays.copyOf(params, params.length);
		return MessageFormat.format(info, arguments);
	}
}
