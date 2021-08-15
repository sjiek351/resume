package tw.yung.rs.model.entity;

import java.util.Date;

/**
 * <pre>
 * [Experience Entity]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
public class Experience {
	private String expId;
	private String expName;
	private Date starttime;
	private Date endtime;
	private String jobTitle;
	private String jobDescribe;

	// Getter & Setter
	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
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

	@Override
	public String toString() {
		return "Experience [expId=" + expId + ", expName=" + expName + ", starttime=" + starttime + ", endtime="
				+ endtime + ", jobTitle=" + jobTitle + ", jobDescribe=" + jobDescribe + "]";
	}

}
