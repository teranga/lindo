package com.jalarbee.lindo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.DataLoader;
import org.cassandraunit.dataset.ClassPathDataSet;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Abdoulaye Diallo
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BaseUnitTest.TestConfig.class)
@TestExecutionListeners(listeners = {BaseUnitTest.CustomCassandraUnitTestExecutionListener.class})
@CassandraDataSet(value = {"lindo.cql"})
@EmbeddedCassandra(clusterName = "lindodb", host = "127.0.0.1", port = 9142)
@Slf4j
public abstract class BaseUnitTest {

    @Configuration
    @ComponentScan(basePackages = {"com.jalarbee.lindo"})
    @EnableCassandraRepositories(basePackages = {"com.jalarbee.lindo"})
    static class TestConfig extends AbstractCassandraConfiguration {

        @Autowired
        private Environment environment;

        @Bean
        public CassandraClusterFactoryBean cluster() {
            CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
            cluster.setContactPoints("127.0.0.1");
            cluster.setPort(9142);
            return cluster;
        }

        @Override
        protected String getKeyspaceName() {
            return "lindodb";
        }

        @Bean
        public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
            return new BasicCassandraMappingContext();
        }

        @Bean
        public CassandraConverter cassandraConverter() throws Exception {

            return new MappingCassandraConverter(cassandraMapping());
        }


        @Bean
        public CassandraSessionFactoryBean session() throws Exception {

            CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
            session.setCluster(cluster().getObject());
            session.setKeyspaceName(getKeyspaceName());
            session.setConverter(cassandraConverter());
            session.setSchemaAction(SchemaAction.NONE);

            return session;
        }
    }

    static class CustomCassandraUnitTestExecutionListener extends DependencyInjectionTestExecutionListener {

        private static boolean initialized = false;

        @Override
        public void prepareTestInstance(TestContext testContext) throws Exception {

            log.info("starting server");
            startServer(testContext);
            log.info("done starting server");
            log.info("preparing test instance");
            super.prepareTestInstance(testContext);
            log.info("done preparing test instance");
        }



        @Override
        public void beforeTestMethod(TestContext testContext) throws Exception {
            super.beforeTestMethod(testContext);
        }

        @Override
        public void afterTestMethod(TestContext testContext) throws Exception {
            super.beforeTestMethod(testContext);
            log.info("stopping server");
            cleanServer();
            log.info("done stopping server");
        }


        protected void startServer(TestContext testContext) throws Exception {
            EmbeddedCassandra embeddedCassandra = Preconditions.checkNotNull(
                    AnnotationUtils.findAnnotation(testContext.getTestClass(), EmbeddedCassandra.class),
                    "CassandraUnitTestExecutionListener must be used with @EmbeddedCassandra on " + testContext.getTestClass());
            if (!initialized) {
                EmbeddedCassandraServerHelper.startEmbeddedCassandra(Optional.fromNullable(embeddedCassandra.configuration()).get());
                initialized = true;
            }

            String clusterName = Preconditions.checkNotNull(embeddedCassandra.clusterName(), "@EmbeddedCassandra host must not be null");
            String host = Preconditions.checkNotNull(embeddedCassandra.host(), "@EmbeddedCassandra clusterName must not be null");
            int port = Preconditions.checkNotNull(embeddedCassandra.port(), "@EmbeddedCassandra port must not be null");
            Preconditions.checkArgument(port > 0, "@EmbeddedCassandra port must not be > 0");

            CassandraDataSet cassandraDataSet = AnnotationUtils.findAnnotation(testContext.getTestClass(), CassandraDataSet.class);
            if (cassandraDataSet != null) {
                List<String> dataset = null;
                ListIterator<String> datasetIterator = null;
                String keyspace = cassandraDataSet.keyspace();
                // TODO : find a way to hide them and avoid switch, need some refactoring cassandra-unit
                switch (cassandraDataSet.type()) {
                    case cql:
                        dataset = dataSetLocations(testContext, cassandraDataSet);
                        datasetIterator = dataset.listIterator();

                        Cluster cluster = new Cluster.Builder().addContactPoints(host).withPort(port).build();
                        Session session = cluster.connect();

                        CQLDataLoader cqlDataLoader = new CQLDataLoader(session);
                        while (datasetIterator.hasNext()) {
                            String next = datasetIterator.next();
                            boolean dropAndCreateKeyspace = datasetIterator.previousIndex() == 0;
                            cqlDataLoader.load(new ClassPathCQLDataSet(next, dropAndCreateKeyspace, dropAndCreateKeyspace, keyspace));
                        }
                        break;
                    default:
                        dataset = dataSetLocations(testContext, cassandraDataSet);
                        datasetIterator = dataset.listIterator();
                        DataLoader dataLoader = new DataLoader(clusterName, host + ":" + port);
                        while (datasetIterator.hasNext()) {
                            String next = datasetIterator.next();
                            boolean dropAndCreateKeyspace = datasetIterator.previousIndex() == 0;
                            dataLoader.load(new ClassPathDataSet(next), dropAndCreateKeyspace);
                        }
                }
            }

        }

        private List<String> dataSetLocations(TestContext testContext, CassandraDataSet cassandraDataSet) {
            String[] dataset = cassandraDataSet.value();
            if (dataset.length == 0) {
                String alternativePath = alternativePath(testContext.getTestClass(), true, cassandraDataSet.type().name());
                if (testContext.getApplicationContext().getResource(alternativePath).exists()) {
                    dataset = new String[]{alternativePath.replace(ResourceUtils.CLASSPATH_URL_PREFIX + "/", "")};
                } else {
                    alternativePath = alternativePath(testContext.getTestClass(), false, cassandraDataSet.type().name());
                    if (testContext.getApplicationContext().getResource(alternativePath).exists()) {
                        dataset = new String[]{alternativePath.replace(ResourceUtils.CLASSPATH_URL_PREFIX + "/", "")};
                    } else {
                        log.info("No dataset will be loaded");
                    }
                }
            }
            return Arrays.asList(dataset);
        }

        protected void cleanServer() {
            EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
        }

        protected String alternativePath(Class<?> clazz, boolean includedPackageName, String extension) {
            if (includedPackageName) {
                return ResourceUtils.CLASSPATH_URL_PREFIX + "/" + ClassUtils.convertClassNameToResourcePath(clazz.getName()) + "-dataset" + "." + extension;
            } else {
                return ResourceUtils.CLASSPATH_URL_PREFIX + "/" + clazz.getSimpleName() + "-dataset" + "." + extension;
            }
        }

    }
    @Test
    public void verify_db_init() {

        Cluster cluster = Cluster.builder()
                .addContactPoints("127.0.0.1")
                .withPort(9142)
                .build();
        Session session = cluster.connect("lindodb");
        assertThat(session).isNotNull();
    }
}


