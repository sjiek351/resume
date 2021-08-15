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
import tw.yung.rs.model.entity.Experience;

/**
 * <pre>
 * [Experience Dao]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
@Repository
public class ExperienceDao extends GenericDao {
	private static final String EXPERIENCE = " EXPERIENCE ";

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
	public List<Experience> select() {
		return select(null);
	}

	/**
	 * <pre>
	 * [查詢]
	 * 若無資料回傳null
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public List<Experience> select(Experience experience) {

		Map<String, Object> whereMap = new HashMap<>();
		if (experience != null) {
			whereMap.put(" EXP_ID=? ", experience.getExpId());
			whereMap.put(" EXP_NAME=? ", experience.getExpName());
			whereMap.put(" STARTTIME=? ", experience.getStarttime());
			whereMap.put(" ENDTIME=? ", experience.getEndtime());
			whereMap.put(" JOB_TITLE=? ", experience.getJobTitle());
			whereMap.put(" JOB_DESCRIBE=? ", experience.getJobDescribe());
		}
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT);
		sql.append(" * ");
		sql.append(FROM).append(EXPERIENCE);
		sql.append(whereSql);
		sql.append(ORDER_BY).append(" STARTTIME desc ");

		List<Experience> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Experience.class),
				whereValues);

		if (resultList.size() == 0) {
			return null;
		}

		return resultList;
	}

	/**
	 * <pre>
	 * [新增]
	 * 回傳影響資料的數量
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public int insert(Experience experience) {
		if (experience == null) {
			return 0;
		}

		StringBuffer sql = new StringBuffer();
		sql.append(INSERT_INTO).append(EXPERIENCE);
		sql.append(" (EXP_ID, EXP_NAME, STARTTIME, ENDTIME, JOB_TITLE, JOB_DESCRIBE) ");
		sql.append(VALUES);
		sql.append(" (?, ?, ?, ?, ?, ?) ");

		Object[] values = { experience.getExpId(), experience.getExpName(), experience.getStarttime(),
				experience.getEndtime(), experience.getJobTitle(), experience.getJobDescribe() };

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
	public int update(Experience experience) {
		if (experience == null) {
			return 0;
		}

		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put(" EXP_NAME=? ", experience.getExpName());
		updateMap.put(" STARTTIME=? ", experience.getStarttime());
		updateMap.put(" ENDTIME=? ", experience.getEndtime());
		updateMap.put(" JOB_TITLE=? ", experience.getJobTitle());
		updateMap.put(" JOB_DESCRIBE=? ", experience.getJobDescribe());
		Map<String, Object> updateSqlMap = updateMap2Map(updateMap);
		String updateSql = (String) updateSqlMap.get(UPDATE_SQL);
		Object[] updateValues = (Object[]) updateSqlMap.get(UPDATE_VALUES);

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" EXP_ID=? ", experience.getExpId());
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(UPDATE).append(EXPERIENCE);
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
	public int delete(Experience experience) {
		if (experience == null) {
			return 0;
		}

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" EXP_ID=? ", experience.getExpId());
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(DELETE_FROM).append(EXPERIENCE);
		sql.append(whereSql);

		int resultList = jdbcTemplate.update(sql.toString(), whereValues);

		return resultList;
	}

}
