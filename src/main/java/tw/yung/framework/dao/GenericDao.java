package tw.yung.framework.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericDao {
	protected static final String SELECT = " SELECT ";
	protected static final String FROM = " FROM ";

	protected static final String INSERT_INTO = " INSERT INTO ";
	protected static final String VALUES = " VALUES ";

	protected static final String UPDATE = " UPDATE ";
	protected static final String SET = " SET ";

	protected static final String DELETE_FROM = " DELETE FROM ";
	
	protected static final String WHERE = " WHERE ";
	protected static final String AND = " AND ";
	protected static final String ORDER_BY = " ORDER BY ";

	protected static final String WHERE_SQL = "whereSql";
	protected static final String WHERE_VALUES = "whereValues";

	protected static final String UPDATE_SQL = "updateSql";
	protected static final String UPDATE_VALUES = "updateValues";

	protected Map<String, Object> whereMap2Map(Map<String, Object> whereMap) {
		if (whereMap == null) {
			return null;
		}

		StringBuffer whereSqlBuffer = new StringBuffer();
		whereSqlBuffer.append(WHERE);
		whereSqlBuffer.append(" 1 = 1 ");

		List<Object> valueList = new ArrayList<>();

		whereMap.forEach((key, value) -> {
			if (value == null) {
				return;
			}

			whereSqlBuffer.append(AND);
			whereSqlBuffer.append(key);
			valueList.add(value);
		});

		Map<String, Object> sqlMap = new HashMap<String, Object>();
		sqlMap.put(WHERE_SQL, whereSqlBuffer.toString());
		sqlMap.put(WHERE_VALUES, valueList.toArray());

		return sqlMap;
	}

	protected Map<String, Object> updateMap2Map(Map<String, Object> updateMap) {
		if (updateMap == null) {
			return null;
		}

		StringBuffer whereSqlBuffer = new StringBuffer();
		whereSqlBuffer.append(SET);
		whereSqlBuffer.append(" 1 = 1 ");

		List<String> sqlList = new ArrayList<>();
		List<Object> valueList = new ArrayList<>();

		updateMap.forEach((key, value) -> {
			if (value == null) {
				return;
			}

			sqlList.add(key);
			valueList.add(value);
		});

		Map<String, Object> sqlMap = new HashMap<String, Object>();
		sqlMap.put(UPDATE_SQL, String.join(", ", sqlList));
		sqlMap.put(UPDATE_VALUES, valueList.toArray());

		return sqlMap;
	}
}
