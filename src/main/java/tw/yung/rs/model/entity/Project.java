package tw.yung.rs.model.entity;

import java.util.Date;

/**
 * <pre>
 * [Project Entity]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
public class Project {
	private String projectId;
	private String projectName;
	private String expId;
	private Date starttime;
	private Date endtime;
	private String jobTitle;
	private String jobDescribe;
	private String display;

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

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", expId=" + expId + ", starttime="
				+ starttime + ", endtime=" + endtime + ", jobTitle=" + jobTitle + ", jobDescribe=" + jobDescribe
				+ ", display=" + display + "]";
	}

}
