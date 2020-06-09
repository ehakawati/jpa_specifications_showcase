package com.boutiqaat.jpa.repo.betterpaging;

import java.util.regex.Pattern;

import org.hibernate.EmptyInterceptor;

public class PagableQueriesInterceptor extends EmptyInterceptor {

	private static final Pattern PATTERN = Pattern.compile(".*?\\?, \\?$");
	private static final long serialVersionUID = 1L;

	@Override
	public String onPrepareStatement(String sql) {

		if (PATTERN.matcher(sql).find()) {
			sql = sql.replaceFirst("select", "select SQL_CALC_FOUND_ROWS ");
		}

		return sql;
	}
}
