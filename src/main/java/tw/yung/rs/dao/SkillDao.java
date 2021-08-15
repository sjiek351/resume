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
import tw.yung.rs.model.entity.Skill;

/**
 * <pre>
 * [Skill Dao]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-09
 * @version 2021-08-09 崔永昀
 */
@Repository
public class SkillDao extends GenericDao {
	private static final String SKILL = " SKILL ";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * <pre>
	 * [查詢]
	 * 若無資料回傳null
	 * </pre>
	 *
	 * @since 2021-08-09 崔永昀
	 */
	public List<Skill> select() {

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT);
		sql.append(" * ");
		sql.append(FROM).append(SKILL);
		sql.append(ORDER_BY).append(" TYPE, RANK desc, SKILL_NAME ");

		List<Skill> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Skill.class));

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
	 * @since 2021-08-09 崔永昀
	 */
	public Skill selectByPK(Skill skill) {

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" SKILL_NAME=? ", skill.getSkillName());
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT);
		sql.append(" * ");
		sql.append(FROM).append(SKILL);
		sql.append(whereSql);

		List<Skill> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Skill.class),
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
	 * @since 2021-08-09 崔永昀
	 */
	public int insert(Skill skill) {
		if (skill == null) {
			return 0;
		}

		StringBuffer sql = new StringBuffer();
		sql.append(INSERT_INTO).append(SKILL);
		sql.append(" (SKILL_NAME, TYPE, RANK) ");
		sql.append(VALUES);
		sql.append(" (?, ?, ?) ");

		Object[] values = { skill.getSkillName(), skill.getType(), skill.getRank() };

		int result = jdbcTemplate.update(sql.toString(), values);

		return result;

	}

	/**
	 * <pre>
	 * [修改] PKey
	 * 回傳影響資料的數量
	 * </pre>
	 *
	 * @since 2021-08-09 崔永昀
	 */
	public int update(Skill skill) {
		if (skill == null) {
			return 0;
		}

		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put(" TYPE=? ", skill.getType());
		updateMap.put(" RANK=? ", skill.getRank());
		Map<String, Object> updateSqlMap = updateMap2Map(updateMap);
		String updateSql = (String) updateSqlMap.get(UPDATE_SQL);
		Object[] updateValues = (Object[]) updateSqlMap.get(UPDATE_VALUES);

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" SKILL_NAME=? ", skill.getSkillName());
		Map<String, Object> whereSqlMap = whereMap2Map(whereMap);
		String whereSql = (String) whereSqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) whereSqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(UPDATE).append(SKILL);
		sql.append(SET);
		sql.append(updateSql);
		sql.append(whereSql);

		int result = jdbcTemplate.update(sql.toString(), ArrayUtils.addAll(updateValues, whereValues));

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
	public int delete(Skill skill) {
		if (skill == null) {
			return 0;
		}

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" SKILL_NAME=? ", skill.getSkillName());
		Map<String, Object> whereSqlMap = whereMap2Map(whereMap);
		String whereSql = (String) whereSqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) whereSqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(DELETE_FROM).append(SKILL);
		sql.append(whereSql);

		int result = jdbcTemplate.update(sql.toString(), whereValues);

		return result;
	}
}
