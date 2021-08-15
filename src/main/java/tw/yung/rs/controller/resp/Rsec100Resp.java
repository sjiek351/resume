package tw.yung.rs.controller.resp;

import java.util.List;
import java.util.Map;

import tw.yung.framework.controller.resp.GenericResp;

/**
 * <pre>
 * [Article經歷 Resp] Rsec100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-14
 * @version 2021-08-14 崔永昀
 */
public class Rsec100Resp extends GenericResp {
	private List<Map<String, Object>> exps;

	// Getter & Setter
	public List<Map<String, Object>> getExps() {
		return exps;
	}

	public void setExps(List<Map<String, Object>> exps) {
		this.exps = exps;
	}

}
