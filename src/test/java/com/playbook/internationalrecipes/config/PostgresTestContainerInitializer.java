package com.playbook.internationalrecipes.config;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class PostgresTestContainerInitializer extends PostgreSQLContainer<PostgresTestContainerInitializer> {

    private static final String IMAGE_VERSION = "postgres:latest";
    private static final String DATABASE_NAME = "test";
    private static PostgresTestContainerInitializer container;

    // Change the access modifier to protected
    protected PostgresTestContainerInitializer() {
        super(IMAGE_VERSION);
    }

    static PostgresTestContainerInitializer getInstance() {
        if (container == null) {
            container = new PostgresTestContainerInitializer().withDatabaseName(DATABASE_NAME);
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
    }

    @Container
    static PostgresTestContainerInitializer postgresTestContainerInitializer = getInstance();
}