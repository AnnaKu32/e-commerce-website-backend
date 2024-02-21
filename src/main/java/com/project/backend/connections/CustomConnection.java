package com.project.backend.connections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionConfig.class);

    private static ConnectionConfig connectionConfig;

    static {
        try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            String url = connectionUtil.getProperty("url");
            String username = connectionUtil.getProperty("username");
            String password = connectionUtil.getProperty("password");

            connectionConfig = ConnectionConfig.create(url, username, password);
        } catch (SQLException | IOException e) {
            LOGGER.error("Exception occurred when trying to initialize connectionConfig", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return connectionConfig.getConnection();
    }
}
