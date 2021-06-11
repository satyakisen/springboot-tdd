package com.ssen.springboottdd.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraTemplateFactoryBean;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.lang.NonNull;

@Configuration
@PropertySource("classpath:application.properties")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${cassandra.keyspace}")
    private String keyspace;

    @Value("${cassandra.contactpoints}")
    private String contactPoints;

    @Value("${cassandra.port}")
    private int port;

    @Override
    @NonNull
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    @NonNull
    protected String getContactPoints(){
        return contactPoints;
    }

    @Override
    @NonNull
    protected int getPort(){
        return port;
    }
}
