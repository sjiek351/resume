package tw.yung.rs.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsfb100Resp;
import tw.yung.rs.dao.SkillDao;
import tw.yung.rs.model.entity.Skill;
import tw.yung.rs.service.Rsfb100Service;
import tw.yung.rs.service.bo.Rsfb100Bo;

/**
 * <pre>
 * [Article修改技能 ServiceImpl] Rsfb100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-08
 * @version 2021-08-08 崔永昀
 */
@Service
public class Rsfb100ServiceImpl implements Rsfb100Service {

	@Autowired
	private SkillDao skillDao;

	@Override
	@Transactional
	public Rsfb100Resp modifySkill(Rsfb100Bo rsfb100Bo) {
		Rsfb100Resp resp = new Rsfb100Resp();

		String skillName = rsfb100Bo.getSkillName();
		int type = rsfb100Bo.getType();
		int rank = rsfb100Bo.getRank();

		// 檢核
		if (StringUtils.isBlank(skillName) || type == 0 || rank == 0) {
			resp.setMessage(Message.W001);
			return resp;
		}
		
		Skill skill = new Skill();
		skill.setSkillName(skillName);
		skill.setType(type);
		skill.setRank(rank);

		int result = 0;
		if (skillDao.selectByPK(skillName) == null) {
			result = skillDao.insert(skill);
		} else {
			result = skillDao.update(skill);
		}

		if (result == 0) {
			resp.setMessage(Message.E002, "資料變更");
		} else {
			resp.setMessage(Message.C001, "資料變更");
		}

		return resp;
	}

	@Override
	@Transactional
	public Rsfb100Resp deleteSkill(Rsfb100Bo rsfb100Bo) {
		Rsfb100Resp resp = new Rsfb100Resp();

		String skillName = rsfb100Bo.getSkillName();

		// 檢核
		if (StringUtils.isBlank(skillName)) {
			resp.setMessage(Message.W001);
			return resp;
		}

		Skill skill = new Skill();
		skill.setSkillName(skillName);

		int result = skillDao.delete(skill);

		if (result == 0) {
			resp.setMessage(Message.E002, "資料刪除");
		} else {
			resp.setMessage(Message.C001, "資料刪除");
		}

		return resp;
	}

}
