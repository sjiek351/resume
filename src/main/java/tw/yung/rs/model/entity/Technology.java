package tw.yung.rs.model.entity;

/**
 * <pre>
 * [Technology Entity]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
public class Technology {
	private String skillName;
	private String projectId;

	// Getter & Setter
	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Technology [skillName=" + skillName + ", projectId=" + projectId + "]";
	}

}
