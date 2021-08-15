package tw.yung.rs.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsda100Resp;
import tw.yung.rs.dao.PersonalDao;
import tw.yung.rs.model.entity.Personal;
import tw.yung.rs.service.Rsda100Service;
import tw.yung.rs.service.bo.Rsda100Bo;

/**
 * <pre>
 * [Article關於我 ServiceImpl] Rsea100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-08
 * @version 2021-08-08 崔永昀
 */
@Service
public class Rsda100ServiceImpl implements Rsda100Service {

	@Autowired
	private PersonalDao personalDao;

	@Override
	public Rsda100Resp findPersonal(Rsda100Bo rsda100Bo) {
		Rsda100Resp resp = new Rsda100Resp();

		String idn = rsda100Bo.getIdn();

		// 檢核
		if (StringUtils.isBlank(idn)) {
			resp.setMessage(Message.W001);
			return resp;
		}

		Personal personal = new Personal();
		personal.setIdn(idn);
		List<Personal> resultList = personalDao.select(personal);
		
		if (resultList == null) {
			resp.setMessage(Message.E002, "資料查詢");
		} else {
			resp.setPersonal(resultList.get(0));
			resp.setMessage(Message.C001, "資料查詢");
		}

		return resp;
	}

}
