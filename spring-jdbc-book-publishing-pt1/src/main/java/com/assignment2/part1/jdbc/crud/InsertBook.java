package com.assignment2.part1.jdbc.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertBook extends SqlUpdate {
    private static final String SQL_INSERT_BOOK =
            "insert into book (title, isbn, price, category_id) values (:title, :isbn, :price, :category_id)";

        public InsertBook(DataSource dataSource) {
            super(dataSource, SQL_INSERT_BOOK);
            super.declareParameter(new SqlParameter("title", Types.VARCHAR));
            super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
            super.declareParameter(new SqlParameter("price", Types.VARCHAR));
            super.declareParameter(new SqlParameter("category_id", Types.DECIMAL));
            super.setGeneratedKeysColumnNames(new String[] {"id"});
            super.setReturnGeneratedKeys(true);
        }


}
