package tw.yung.rs.service;

import tw.yung.rs.controller.resp.Rsda100Resp;
import tw.yung.rs.service.bo.Rsda100Bo;
/**
 * <pre>
 * [Article關於我 Service] Rsda100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-06
 * @version 2021-08-06 崔永昀
 */
public interface Rsda100Service {
	
	/**
	 * <pre>
	 * [查詢 Personal]
	 * </pre>
	 *
	 * @since 2021-08-06 崔永昀
	 */
	public Rsda100Resp findPersonal(Rsda100Bo rsda100Bo);
}
