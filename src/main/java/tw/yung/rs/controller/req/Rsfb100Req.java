package tw.yung.rs.controller.req;

/**
 * <pre>
 * [Article修改技能 Req] Rsfb100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-11
 * @version 2021-08-11 崔永昀
 */
public class Rsfb100Req {
	private String skillName;
	private int type;
	private int rank;

	// Getter & Setter
	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
