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
import tw.yung.rs.model.entity.Personal;

/**
 * <pre>
 * [Personal Dao]
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-09
 * @version 2021-08-09 崔永昀
 */
@Repository
public class PersonalDao extends GenericDao {
	private static final String PERSONAL = " PERSONAL ";

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
	public Personal select() {

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT);
		sql.append(" NAME, NAME_ENGLISH, JOB, LOCATION, CELLPHONE, EMAIL, INTRODUCTION ");
		sql.append(FROM).append(PERSONAL);

		List<Personal> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Personal.class));

		if (resultList.size() == 0) {
			return null;
		}

		return resultList.get(0);

	}

	/**
	 * <pre>
	 * [查詢] PKey
	 * 若無資料回傳null
	 * </pre>
	 *
	 * @since 2021-08-09 崔永昀
	 */
	public Personal selectByPK(Personal personal) {
		if (personal == null) {
			return null;
		}

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" IDN=? ", personal.getIdn());
		Map<String, Object> sqlMap = whereMap2Map(whereMap);
		String whereSql = (String) sqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) sqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(SELECT).append(" * ").append(FROM).append(PERSONAL);
		sql.append(whereSql);

		List<Personal> resultList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Personal.class),
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
	public int insert(Personal personal) {
		if (personal == null) {
			return 0;
		}

		StringBuffer sql = new StringBuffer();
		sql.append(INSERT_INTO).append(PERSONAL);
		sql.append(" (IDN, NAME, NAME_ENGLISH, JOB, LOCATION, CELLPHONE, EMAIL, INTRODUCTION) ");
		sql.append(VALUES);
		sql.append(" (?, ?, ?, ?, ?, ?, ?, ?) ");

		Object[] values = { personal.getIdn(), personal.getName(), personal.getNameEnglish(), personal.getJob(),
				personal.getLocation(), personal.getCellphone(), personal.getEmail(), personal.getIntroduction() };

		int resultList = jdbcTemplate.update(sql.toString(), values);

		return resultList;

	}

	/**
	 * <pre>
	 * [修改] PKey
	 * 回傳影響資料的數量
	 * </pre>
	 *
	 * @since 2021-08-09 崔永昀
	 */
	public int update(Personal personal) {
		if (personal == null) {
			return 0;
		}

		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put(" NAME=? ", personal.getName());
		updateMap.put(" NAME_ENGLISH=? ", personal.getNameEnglish());
		updateMap.put(" JOB=? ", personal.getJob());
		updateMap.put(" LOCATION=? ", personal.getLocation());
		updateMap.put(" CELLPHONE=? ", personal.getCellphone());
		updateMap.put(" EMAIL=? ", personal.getEmail());
		updateMap.put(" INTRODUCTION=? ", personal.getIntroduction());
		Map<String, Object> updateSqlMap = updateMap2Map(updateMap);
		String updateSql = (String) updateSqlMap.get(UPDATE_SQL);
		Object[] updateValues = (Object[]) updateSqlMap.get(UPDATE_VALUES);

		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put(" IDN=? ", personal.getIdn());
		Map<String, Object> whereSqlMap = whereMap2Map(whereMap);
		String whereSql = (String) whereSqlMap.get(WHERE_SQL);
		Object[] whereValues = (Object[]) whereSqlMap.get(WHERE_VALUES);

		StringBuffer sql = new StringBuffer();
		sql.append(UPDATE).append(PERSONAL);
		sql.append(SET);
		sql.append(updateSql);
		sql.append(whereSql);

		int resultList = jdbcTemplate.update(sql.toString(), ArrayUtils.addAll(updateValues, whereValues));

		return resultList;
	}
}
