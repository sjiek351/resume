package tw.yung.rs.controller.resp;

import java.util.List;

import tw.yung.framework.controller.resp.GenericResp;
import tw.yung.rs.model.entity.Skill;

/**
 * <pre>
 * [Article技能 Resp] Rseb100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-07
 * @version 2021-08-07 崔永昀
 */
public class Rseb100Resp extends GenericResp {
	private List<Skill> skills;

	// Getter & Setter
	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}
