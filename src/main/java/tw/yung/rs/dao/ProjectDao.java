package tw.yung.rs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tw.yung.framework.dao.GenericDao;
import tw.yung.rs.model.entity.Project;

/**
 * <pre>
 * [Project Dao]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
@Repository
public class ProjectDao extends GenericDao {
	private static final String PROJECT = " PROJECT ";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * <pre>
	 * [查詢]
	 * 若無資料回傳null
	 * </pre>
	 *
	 * @since 2021-08-14 崔永昀
	 */
	public List<Project> select() {
		return select(null);
	}

	/**
	 * <pre>
	 * [查詢]
	 * 若無資料回傳null
	 * </pre>
	 *
	 * @since 2021-08-14 崔永昀
	 */
	public List<Project> select(Project project) {

		Map<String, Object> whereMap = new HashMap<>();
		if (project != null) {
			whereMap.put(" PROJECT_ID=? ", project.getProjectId());
			whereMap.put(" PROJECT_NAME=? ", project.getProjectName());
			whereMap.put(" EXP_ID=? ", project.getExpId());
			whereMap.put(" STARTTIME=? ", project.getStarttime());
			whereMap.put(" ENDTIME=? ", project.getEndtime());
			whereMap.put(" JOB_TITLE=? ", project.getJobTitle());
			whereMap.put(" JOB_DESCRIBE=? ", project.getJobDescribe());
		}
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT);
		sql.append(" * ");
		sql.append(FROM).append(PROJECT);
		sql.append(whereSql);

		List<Project> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Project.class),
				whereValues);

		if (resultList.size() == 0) {
			return null;
		}

		return resultList;
	}

	/**
	 * <pre>
	 * [查詢] PKey
	 * 若無資料回傳null
	 * </pre>
	 *
	 * @since 2021-08-17 崔永昀
	 */
	public Project selectByPK(String projectId) {
		if (projectId == null) {
			return null;
		}

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" PROJECT_ID=? ", projectId);
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT);
		sql.append(" * ");
		sql.append(FROM).append(PROJECT);
		sql.append(whereSql);

		List<Project> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Project.class),
				whereValues);

		if (resultList.size() == 0) {
			return null;
		}

		return resultList.get(0);
	}

	/**
	 * <pre>
	 * [新增]
	 * 回傳影響資料的數量
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public int insert(Project project) {
		if (project == null) {
			return 0;
		}

		StringBuffer sql = new StringBuffer();
		sql.append(INSERT_INTO).append(PROJECT);
		sql.append(" (PROJECT_ID, PROJECT_NAME, EXP_ID, STARTTIME, ENDTIME, JOB_TITLE, JOB_DESCRIBE) ");
		sql.append(VALUES);
		sql.append(" (?, ?, ?, ?, ?, ?, ?) ");

		Object[] values = { project.getProjectId(), project.getProjectName(), project.getExpId(),
				project.getStarttime(), project.getEndtime(), project.getJobTitle(), project.getJobDescribe() };

		int resultList = jdbcTemplate.update(sql.toString(), values);

		return resultList;
	}

	/**
	 * <pre>
	 * [修改] PKey
	 * 回傳影響資料的數量
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public int update(Project project) {
		if (project == null) {
			return 0;
		}

		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put(" PROJECT_NAME=? ", project.getProjectName());
		updateMap.put(" EXP_ID=? ", project.getExpId());
		updateMap.put(" STARTTIME=? ", project.getStarttime());
		updateMap.put(" ENDTIME=? ", project.getEndtime());
		updateMap.put(" JOB_TITLE=? ", project.getJobTitle());
		updateMap.put(" JOB_DESCRIBE=? ", project.getJobDescribe());
		Map<String, Object> updateSqlMap = updateMap2Map(updateMap);
		String updateSql = (String) updateSqlMap.get(UPDATE_SQL);
		Object[] updateValues = (Object[]) updateSqlMap.get(UPDATE_VALUES);

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" PROJECT_ID=? ", project.getProjectId());
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(UPDATE).append(PROJECT);
		sql.append(SET);
		sql.append(updateSql);
		sql.append(whereSql);

		int resultList = jdbcTemplate.update(sql.toString(), ArrayUtils.addAll(updateValues, whereValues));

		return resultList;
	}

	/**
	 * <pre>
	 * [刪除] PKey
	 * 回傳影響資料的數量
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public int delete(Project project) {
		if (project == null) {
			return 0;
		}

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" PROJECT_ID=? ", project.getProjectId());
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(DELETE_FROM).append(PROJECT);
		sql.append(whereSql);

		int resultList = jdbcTemplate.update(sql.toString(), whereValues);

		return resultList;
	}
}
