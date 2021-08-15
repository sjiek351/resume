package tw.yung.rs.controller.resp;

import tw.yung.framework.controller.resp.GenericResp;
import tw.yung.rs.model.entity.Personal;

/**
 * <pre>
 * [Footer Controller] Rsza100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-11
 * @version 2021-08-11 崔永昀
 */
public class Rsza100Resp extends GenericResp {
	private Personal personal;

	// Getter & Setter
	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}
