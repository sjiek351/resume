package tw.yung.rs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsec100Resp;
import tw.yung.rs.dao.ExperienceDao;
import tw.yung.rs.dao.ProjectDao;
import tw.yung.rs.dao.TechnologyDao;
import tw.yung.rs.model.entity.Experience;
import tw.yung.rs.model.entity.Project;
import tw.yung.rs.model.entity.Technology;
import tw.yung.rs.service.Rsec100Service;

/**
 * <pre>
 * [Article經歷 ServiceImpl] Rsec100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-14
 * @version 2021-08-14 崔永昀
 */
@Service
public class Rsec100ServiceImpl implements Rsec100Service {

	@Autowired
	private ExperienceDao experienceDao;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private TechnologyDao technologyDao;

	@Override
	public Rsec100Resp findExps() {
		Rsec100Resp resp = new Rsec100Resp();
		List<Map<String, Object>> exps = new ArrayList<Map<String, Object>>();

		List<Experience> experienceList = experienceDao.select();

		if (experienceList == null) {
			resp.setMessage(Message.E002, "資料查詢");
			return resp;
		}

		experienceList.forEach(experience -> {
			Map<String, Object> exp4Resp = new HashMap<String, Object>();
			exp4Resp.put("starttime", experience.getStarttime());
			exp4Resp.put("endtime", experience.getEndtime());
			exp4Resp.put("expName", experience.getExpName());
			exp4Resp.put("jobTitle", experience.getJobTitle());
			exp4Resp.put("jobDescribe", experience.getJobDescribe());

			String expId = experience.getExpId();

			Project project = new Project();
			project.setExpId(expId);
			List<Project> projectList = projectDao.select(project);
			
			if(projectList == null) {
				exps.add(exp4Resp);
				return;
			}

			List<Map<String, Object>> projects4Resp = new ArrayList<>();
			projectList.forEach(projectBean -> {
				Map<String, Object> project4Resp = new HashMap<String, Object>();

				String projectId = projectBean.getProjectId();

				Technology technology = new Technology();
				technology.setProjectId(projectId);

				List<Technology> technologyList = technologyDao.select(technology);
				List<String> skillNameList = new ArrayList<>();
				technologyList.forEach(technologyBean -> {
					skillNameList.add(technologyBean.getSkillName());
				});
				String[] skillNames = skillNameList.toArray(new String[skillNameList.size()]);

				// 塞值
				project4Resp.put("projectId", projectBean.getProjectId());
				project4Resp.put("starttime", projectBean.getStarttime());
				project4Resp.put("endtime", projectBean.getEndtime());
				project4Resp.put("projectName", projectBean.getProjectName());
				project4Resp.put("jobTitle", projectBean.getJobTitle());
				project4Resp.put("jobDescribe", projectBean.getJobDescribe());
				project4Resp.put("skillNames", skillNames);
				projects4Resp.add(project4Resp);
			});

			exp4Resp.put("projects", projects4Resp);
			exps.add(exp4Resp);
		});

		resp.setExps(exps);

		return resp;
	}

}
