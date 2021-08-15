package tw.yung.rs.service;

import tw.yung.rs.controller.resp.Rsfc100Resp;
import tw.yung.rs.service.bo.Rsfc100Bo;

/**
 * <pre>
 * [Article修改技能 Service] Rsfc100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
public interface Rsfc100Service {
	/**
	 * <pre>
	 * [變更 Experience] 
	 * 若PK存在則修改，不存在則新增
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public Rsfc100Resp modifyExperience(Rsfc100Bo rsfc100Bo);

	/**
	 * <pre>
	 * [刪除 Experience]
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public Rsfc100Resp deleteExperience(Rsfc100Bo rsfc100Bo);

	/**
	 * <pre>
	 * [變更 Project]
	 * 若PK存在則修改，不存在則新增
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public Rsfc100Resp modifyProject(Rsfc100Bo rsfc100Bo);

	/**
	 * <pre>
	 * [刪除 Project]
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public Rsfc100Resp deleteProject(Rsfc100Bo rsfc100Bo);
}
