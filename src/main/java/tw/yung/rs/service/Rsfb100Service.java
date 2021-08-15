package tw.yung.rs.service;

import tw.yung.rs.controller.resp.Rsfb100Resp;
import tw.yung.rs.service.bo.Rsfb100Bo;

/**
 * <pre>
 * [Article修改技能 Service] Rsfb100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-11
 * @version 2021-08-11 崔永昀
 */
public interface Rsfb100Service {
	/**
	 * <pre>
	 * [變更 Skill] 
	 * 若PK存在則修改，不存在則新增
	 * </pre>
	 *
	 * @since 2021-08-11 崔永昀
	 */
	public Rsfb100Resp modifySkill(Rsfb100Bo rsfb100Bo);

	/**
	 * <pre>
	 * [刪除 Skill]
	 * </pre>
	 *
	 * @since 2021-08-11 崔永昀
	 */
	public Rsfb100Resp deleteSkill(Rsfb100Bo rsfb100Bo);
}
