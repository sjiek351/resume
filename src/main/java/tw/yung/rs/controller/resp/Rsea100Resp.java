package tw.yung.rs.controller.resp;

import tw.yung.framework.controller.resp.GenericResp;
import tw.yung.rs.model.entity.Personal;

/**
 * <pre>
 * [Article關於我 Resp] Rsea100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-06
 * @version 2021-08-06 崔永昀
 */
public class Rsea100Resp extends GenericResp{
	private Personal personal;

	// Getter & Setter
	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}
