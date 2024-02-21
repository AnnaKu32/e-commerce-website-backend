package com.project.backend.connections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionConfig implements ConnectionPool{

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionConfig.class);

    private String url;
    private String user;
    private String password;
    private List<CustomConnection> connectionPool;
    private List<CustomConnection> usedConnection = new ArrayList<>();
    public static final int INITIALIZE_POOL_SIZE = 10;
    private final int MAX_POOL_SIZE = 20;

    public ConnectionConfig(String url, String user, String password, List<CustomConnection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    public static ConnectionConfig create(String url, String user, String password) throws SQLException {
        List<CustomConnection> pool = new ArrayList<>(INITIALIZE_POOL_SIZE);
        for (int i = 0; i < INITIALIZE_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionConfig(url, user, password, pool);
    }

    @Override
    public CustomConnection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if(usedConnection.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection(url, user, password));
            } else {
                throw new RuntimeException("Maximum pool size reached");
            }
        }
        CustomConnection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnection.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(CustomConnection connection) {
        synchronized (this) {
            connectionPool.add(connection);
            return usedConnection.remove(connection);
        }
    }

    private static CustomConnection createConnection(String url, String user, String password) throws SQLException{
        CustomConnection connection = DriverManager.getConnection(url, user, password);
        if(connection != null){
            LOGGER.info("Successfully connected");
        } else {
            LOGGER.error("Failed to connect");
            throw new SQLException("Failed to connect");
        }
        return connection;
    }
}
