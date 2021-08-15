package tw.yung.rs.service;

import tw.yung.rs.controller.resp.Rsfa100Resp;
import tw.yung.rs.service.bo.Rsfa100Bo;

/**
 * <pre>
 * [Article關於我 Service] Rsea100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-06
 * @version 2021-08-06 崔永昀
 */
public interface Rsfa100Service {
	/**
	 * <pre>
	 * [查詢 Personal]
	 * </pre>
	 *
	 * @since 2021-08-06 崔永昀
	 */
	public Rsfa100Resp findPersonal(Rsfa100Bo rsfa100Bo);

	/**
	 * <pre>
	 * [變更 Personal] 
	 * 若PK存在則修改，不存在則新增
	 * </pre>
	 *
	 * @since 2021-08-06 崔永昀
	 */
	public Rsfa100Resp modifyPersonal(Rsfa100Bo rsfa100Bo);
}
