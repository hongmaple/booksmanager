package com.common.util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class TxQueryRunner extends QueryRunner {

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        //获取数据库连接
        Connection con = DbUtil.getCon();
        int[] result = super.batch(con, sql, params);
//        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        Connection con = DbUtil.getCon();
        T result = super.query(con, sql, rsh,params);
//        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
         Connection con = DbUtil.getCon();
        T result = super.query(con, sql, rsh);
//        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
//        Connection con = JdbcUtils.getConnection();
        Connection con = DbUtil.getCon();
        int result = super.update(con, sql, params);

//        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = DbUtil.getCon();
        int result = super.update(con, sql, param);
//        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = DbUtil.getCon();
        int result = super.update(con, sql);
//        JdbcUtils.releaseConnection(con);
        return result;
    }



}