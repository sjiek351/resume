package tw.yung.rs.model.po;

import java.util.Date;

/**
 * <pre>
 * [Article經歷 Po] Rsec100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-14
 * @version 2021-08-14 崔永昀
 */
public class Rsec100Po {
	// common
	private String projectId;

	// Project
	private String projectName;
	private int expId;
	private Date starttime;
	private Date endtime;
	private String jobTitle;
	private String jobDescribe;

	// Technology
	private String[] skillNames;

	// Getter & Setter
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getExpId() {
		return expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescribe() {
		return jobDescribe;
	}

	public void setJobDescribe(String jobDescribe) {
		this.jobDescribe = jobDescribe;
	}

	public String[] getSkillNames() {
		return skillNames;
	}

	public void setSkillNames(String[] skillNames) {
		this.skillNames = skillNames;
	}

}
