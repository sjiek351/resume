package tw.yung.rs.model.entity;

/**
 * <pre>
 * [Personal Entity] 
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-07
 * @version 2021-08-07 崔永昀
 */
public class Personal {
	private String idn;
	private String name;
	private String nameEnglish;
	private String job;
	private String location;
	private String cellphone;
	private String email;
	private String introduction;

	// Getter & Setter
	public String getIdn() {
		return idn;
	}

	public void setIdn(String idn) {
		this.idn = idn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "Personal [idn=" + idn + ", name=" + name + ", nameEnglish=" + nameEnglish + ", job=" + job
				+ ", location=" + location + ", cellphone=" + cellphone + ", email=" + email + ", introduction="
				+ introduction + "]";
	}

}
