package tw.yung.rs.model.entity;

/**
 * <pre>
 * [Skill Entity]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-07
 * @version 2021-08-07 崔永昀
 */

public class Skill {
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

	@Override
	public String toString() {
		return "Skill [skillName=" + skillName + ", type=" + type + ", rank=" + rank + "]";
	}

}
