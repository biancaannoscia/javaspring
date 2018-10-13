package com.assignment2.part1.jdbc.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class DeleteBook extends SqlUpdate {
    private static final String SQL_DELETE_BOOK =
            "delete from book where id = :id";

        public DeleteBook(DataSource dataSource) {
            super(dataSource, SQL_DELETE_BOOK);
            super.declareParameter(new SqlParameter("id", Types.INTEGER));
        }

}
