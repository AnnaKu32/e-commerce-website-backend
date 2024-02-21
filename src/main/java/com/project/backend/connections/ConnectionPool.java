package com.project.backend.connections;

import java.sql.SQLException;

public interface ConnectionPool {

    CustomConnection getConnection() throws SQLException;

    boolean releaseConnection(CustomConnection connection);

}