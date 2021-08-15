package tw.yung.rs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsea100Resp;
import tw.yung.rs.dao.PersonalDao;
import tw.yung.rs.model.entity.Personal;
import tw.yung.rs.service.Rsea100Service;

/**
 * <pre>
 * [Article關於我 ServiceImpl] Rsea100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-06
 * @version 2021-08-06 崔永昀
 */
@Service
public class Rsea100ServiceImpl implements Rsea100Service {


	@Autowired
	private PersonalDao personalDao;
	
	@Override
	public Rsea100Resp findPersonal() {
		Rsea100Resp resp = new Rsea100Resp();
		
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
