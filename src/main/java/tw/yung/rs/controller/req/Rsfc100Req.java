package tw.yung.rs.controller.req;

import java.util.Date;

/**
 * <pre>
 * [Article修改經歷 Req] Rsfc100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
public class Rsfc100Req {
	// common
	private String expId;
	private Date starttime;
	private Date endtime;
	private String jobTitle;
	private String jobDescribe;

	// Experience
	private String expName;

	// Project
	private String projectId;
	private String projectName;
	private String display;

	// Technology
	private String[] skillNames;

	// Getter & Setter
	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
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

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

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

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String[] getSkillNames() {
		return skillNames;
	}

	public void setSkillNames(String[] skillNames) {
		this.skillNames = skillNames;
	}

}
