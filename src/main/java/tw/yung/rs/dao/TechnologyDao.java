package tw.yung.rs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tw.yung.framework.dao.GenericDao;
import tw.yung.rs.model.entity.Technology;

/**
 * <pre>
 * [Technology Dao]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
@Repository
public class TechnologyDao extends GenericDao {
	private static final String TECHNOLOGY = " TECHNOLOGY ";

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
	public List<Technology> select() {
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
	public List<Technology> select(Technology technology) {

		Map<String, Object> whereMap = new HashMap<>();
		if (technology != null) {
			whereMap.put(" PROJECT_ID=? ", technology.getProjectId());
			whereMap.put(" SKILL_NAME=? ", technology.getSkillName());
		}
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT);
		sql.append(" * ");
		sql.append(FROM).append(TECHNOLOGY);
		sql.append(whereSql);

		List<Technology> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Technology.class),
				whereValues);

		if (resultList.size() == 0) {
			return null;
		}

		return resultList;
	}

	/**
	 * <pre>
	 * [查詢] ProjectId
	 * 若無資料回傳null
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
//	public List<Technology> selectByProjectId(Technology technology) {
//
//		Map<String, Object> whereMap = new HashMap<>();
//		whereMap.put(" PROJECT_ID=? ", technology.getProjectId());
//		Map<String, Object> sqlMap = whereMap2Map(whereMap);
//		String whereSql = (String) sqlMap.get(WHERE_SQL);
//		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);
//
//		StringBuffer sql = new StringBuffer();
//		sql.append(SELECT);
//		sql.append(" * ");
//		sql.append(FROM).append(TECHNOLOGY);
//		sql.append(whereSql);
//
//		List<Technology> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Technology.class),
//				whereValues);
//
//		if (resultList.size() == 0) {
//			return null;
//		}
//
//		return resultList;
//	}

	/**
	 * <pre>
	 * [批次新增]
	 * 回傳影響資料的數量Array
	 * </pre>
	 *
	 * @since 2021-08-13 崔永昀
	 */
	public int[] batchInsert(List<Technology> technologyList) {
		if (technologyList == null) {
			return null;
		}

		StringBuffer sql = new StringBuffer();
		sql.append(INSERT_INTO).append(TECHNOLOGY);
		sql.append(" (SKILL_NAME, PROJECT_ID) ");
		sql.append(VALUES);
		sql.append(" (?, ?) ");

		List<Object[]> valuesList = new ArrayList<Object[]>();
		technologyList.forEach(technology -> {
			Object[] values = { technology.getSkillName(), technology.getProjectId() };
			valuesList.add(values);
		});

		int[] result = jdbcTemplate.batchUpdate(sql.toString(), valuesList);

		return result;
	}

	/**
	 * <pre>
	 * [刪除] PKey
	 * 回傳影響資料的數量
	 * </pre>
	 *
	 * @since 2021-08-12 崔永昀
	 */
	public int delete(Technology technology) {
		if (technology == null) {
			return 0;
		}

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" PROJECT_ID=? ", technology.getProjectId());
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(DELETE_FROM).append(TECHNOLOGY);
		sql.append(whereSql);

		int result = jdbcTemplate.update(sql.toString(), whereValues);

		return result;
	}
}
