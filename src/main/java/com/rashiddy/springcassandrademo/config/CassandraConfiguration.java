package com.rashiddy.springcassandrademo.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import software.aws.mcs.auth.SigV4AuthProvider;

import javax.net.ssl.SSLContext;
import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

@Configuration
public class CassandraConfiguration {

    @Primary
    public @Bean
    CqlSession session() throws NoSuchAlgorithmException {

        List<InetSocketAddress> contactPoints =
                Collections.singletonList(
                        InetSocketAddress.createUnresolved("cassandra.eu-west-1.amazonaws.com", 9142));

        return CqlSession.builder()
                .addContactPoints(contactPoints)
                .withLocalDatacenter("eu-west-1")
                .withAuthProvider(new SigV4AuthProvider("eu-west-1"))
                .withSslContext(SSLContext.getDefault())
                .withKeyspace("tutorialKeyspace")
                .build();
    }

    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
