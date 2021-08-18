package tw.yung.rs.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsfa100Resp;
import tw.yung.rs.dao.PersonalDao;
import tw.yung.rs.model.entity.Personal;
import tw.yung.rs.service.Rsfa100Service;
import tw.yung.rs.service.bo.Rsfa100Bo;

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
public class Rsfa100ServiceImpl implements Rsfa100Service {

	@Autowired
	private PersonalDao personalDao;

	@Override
	@Transactional
	public Rsfa100Resp findPersonal(Rsfa100Bo rsfa100Bo) {
		Rsfa100Resp resp = new Rsfa100Resp();

		String idn = rsfa100Bo.getIdn();

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

	@Override
	@Transactional
	public Rsfa100Resp modifyPersonal(Rsfa100Bo rsfa100Bo) {
		Rsfa100Resp resp = new Rsfa100Resp();

		String idn = rsfa100Bo.getIdn();
		String name = rsfa100Bo.getName();
		String nameEnglish = rsfa100Bo.getNameEnglish();
		String job = rsfa100Bo.getJob();
		String location = rsfa100Bo.getLocation();
		String cellphone = rsfa100Bo.getCellphone();
		String email = rsfa100Bo.getEmail();
		String introduction = rsfa100Bo.getIntroduction();

		// 檢核
		if (StringUtils.isBlank(idn) || StringUtils.isBlank(name) || StringUtils.isBlank(cellphone)
				|| StringUtils.isBlank(email)) {
			resp.setMessage(Message.W001);
			return resp;
		}

		Personal personal = new Personal();
		personal.setIdn(idn);
		personal.setName(name);
		personal.setNameEnglish(nameEnglish);
		personal.setJob(job);
		personal.setLocation(location);
		personal.setCellphone(cellphone);
		personal.setEmail(email);
		personal.setIntroduction(introduction);

		int result = 0;
		if (personalDao.selectByPK(idn) == null) {
			result = personalDao.insert(personal);
		} else {
			result = personalDao.update(personal);
		}

		if (result == 0) {
			resp.setMessage(Message.E002, "資料變更");
		} else {
			resp = findPersonal(rsfa100Bo);
		}

		return resp;
	}

}
