package tw.yung.rs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsza100Resp;
import tw.yung.rs.dao.PersonalDao;
import tw.yung.rs.model.entity.Personal;
import tw.yung.rs.service.Rsza100Service;

/**
 * <pre>
 * [Footer ServiceImpl] Rsza100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-11
 * @version 2021-08-11 崔永昀
 */
@Service
public class Rsza100ServiceImpl implements Rsza100Service {

	@Autowired
	private PersonalDao personalDao;

	@Override
	public Rsza100Resp findPersonal() {
		Rsza100Resp resp = new Rsza100Resp();

		Personal result = personalDao.select();

		if (result == null) {
			resp.setMessage(Message.E002, "資料查詢");
		} else {
			resp.setMessage(Message.C001, "資料查詢");
		}
		resp.setPersonal(result);

		return resp;
	}

}
