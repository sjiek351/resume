package tw.yung.rs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsfc100Resp;
import tw.yung.rs.dao.ExperienceDao;
import tw.yung.rs.dao.ProjectDao;
import tw.yung.rs.dao.TechnologyDao;
import tw.yung.rs.model.entity.Experience;
import tw.yung.rs.model.entity.Project;
import tw.yung.rs.model.entity.Technology;
import tw.yung.rs.service.Rsfc100Service;
import tw.yung.rs.service.bo.Rsfc100Bo;

/**
 * <pre>
 * [Article修改技能 ServiceImpl] Rsfc100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
@Service
public class Rsfc100ServiceImpl implements Rsfc100Service {

	@Autowired
	private ExperienceDao experienceDao;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private TechnologyDao technologyDao;

	@Override
	public Rsfc100Resp modifyExperience(Rsfc100Bo rsfc100Bo) {
		Rsfc100Resp resp = new Rsfc100Resp();

		String expId = rsfc100Bo.getExpId();
		String expName = rsfc100Bo.getExpName();
		Date starttime = rsfc100Bo.getStarttime();
		Date endtime = rsfc100Bo.getEndtime();
		String jobTitle = rsfc100Bo.getJobTitle();
		String jobDescribe = rsfc100Bo.getJobDescribe();

		// 檢核
		if (StringUtils.isBlank(expId) || StringUtils.isBlank(expName) || starttime == null || endtime == null) {
			resp.setMessage(Message.W001);
			return resp;
		}

		Experience experience = new Experience();
		experience.setExpId(expId);
		experience.setExpName(expName);
		experience.setStarttime(starttime);
		experience.setEndtime(endtime);
		experience.setJobTitle(jobTitle);
		experience.setJobDescribe(jobDescribe);

		int result = 0;
		if (experienceDao.selectByPK(expId) == null) {
			result = experienceDao.insert(experience);
		} else {
			result = experienceDao.update(experience);
		}

		if (result == 0) {
			resp.setMessage(Message.E002, "資料變更");
		} else {
			resp.setMessage(Message.C001, "資料變更");
		}

		return resp;
	}

	@Override
	public Rsfc100Resp deleteExperience(Rsfc100Bo rsfc100Bo) {
		Rsfc100Resp resp = new Rsfc100Resp();

		String expId = rsfc100Bo.getExpId();

		// 檢核
		if (StringUtils.isBlank(expId)) {
			resp.setMessage(Message.W001);
			return resp;
		}

		Experience experience = new Experience();
		experience.setExpId(expId);

		int result = experienceDao.delete(experience);

		if (result == 0) {
			resp.setMessage(Message.E002, "資料刪除");
		} else {
			resp.setMessage(Message.C001, "資料刪除");
		}

		return resp;
	}

	@Override
	public Rsfc100Resp modifyProject(Rsfc100Bo rsfc100Bo) {
		Rsfc100Resp resp = new Rsfc100Resp();

		String expId = rsfc100Bo.getExpId();
		String projectId = rsfc100Bo.getProjectId();
		String projectName = rsfc100Bo.getProjectName();
		Date starttime = rsfc100Bo.getStarttime();
		Date endtime = rsfc100Bo.getEndtime();
		String jobTitle = rsfc100Bo.getJobTitle();
		String jobDescribe = rsfc100Bo.getJobDescribe();
		String[] skillNames = rsfc100Bo.getSkillNames();

		// 檢核
		if (StringUtils.isBlank(expId) || StringUtils.isBlank(projectId) || StringUtils.isBlank(projectName)
				|| starttime == null || endtime == null) {
			resp.setMessage(Message.W001);
			return resp;
		}

		// 變更Project
		Project project = new Project();
		project.setProjectId(projectId);
		project.setProjectName(projectName);
		project.setExpId(expId);
		project.setStarttime(starttime);
		project.setEndtime(endtime);
		project.setJobTitle(jobTitle);
		project.setJobDescribe(jobDescribe);

		int projectResult = 0;
		if (projectDao.selectByPK(projectId) == null) {
			projectResult = projectDao.insert(project);
		} else {
			projectResult = projectDao.update(project);
		}

		// 變更Technology
		if (skillNames != null && skillNames.length > 0) {
			// 先清空再批次新增
			Technology technology = new Technology();
			technology.setProjectId(projectId);
			technologyDao.delete(technology);

			List<Technology> technologyList = new ArrayList<Technology>();
			for (String skillName : skillNames) {
				Technology bean = new Technology();
				bean.setProjectId(projectId);
				bean.setSkillName(skillName);
				technologyList.add(bean);
			}
			technologyDao.batchInsert(technologyList);
		}

		if (projectResult == 0) {
			resp.setMessage(Message.E002, "資料變更");
		} else {
			resp.setMessage(Message.C001, "資料變更");
		}

		return resp;
	}

	@Override
	public Rsfc100Resp deleteProject(Rsfc100Bo rsfc100Bo) {
		Rsfc100Resp resp = new Rsfc100Resp();

		String projectId = rsfc100Bo.getProjectId();

		// 檢核
		if (StringUtils.isBlank(projectId)) {
			resp.setMessage(Message.W001);
			return resp;
		}

		// 刪除Project
		Project project = new Project();
		project.setProjectId(projectId);

		int projectResult = projectDao.delete(project);

		// 刪除Technology
		Technology technology = new Technology();
		technology.setProjectId(projectId);

		technologyDao.delete(technology);

		if (projectResult == 0) {
			resp.setMessage(Message.E002, "資料刪除");
		} else {
			resp.setMessage(Message.C001, "資料刪除");
		}

		return resp;
	}

}
