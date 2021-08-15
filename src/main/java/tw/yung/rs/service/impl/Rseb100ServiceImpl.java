package tw.yung.rs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rseb100Resp;
import tw.yung.rs.dao.SkillDao;
import tw.yung.rs.model.entity.Skill;
import tw.yung.rs.service.Rseb100Service;

/**
 * <pre>
 * [Article技能 ServiceImpl] Rseb100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-07
 * @version 2021-08-07 崔永昀
 */
@Service
public class Rseb100ServiceImpl implements Rseb100Service {

	@Autowired
	private SkillDao skillDao;

	@Override
	public Rseb100Resp findSkills() {
		Rseb100Resp resp = new Rseb100Resp();

		List<Skill> result = skillDao.select();

		if (result == null) {
			resp.setMessage(Message.E002, "資料查詢");
		} else {
			resp.setMessage(Message.C001, "資料查詢");
		}
		resp.setSkills(result);

		return resp;
	}

}
