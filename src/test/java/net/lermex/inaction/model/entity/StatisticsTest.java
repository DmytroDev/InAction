package net.lermex.inaction.model.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import javax.inject.Inject;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // будет создавать спринговский контекст заново для каждого тест метода
@ContextConfiguration(loader =AnnotationConfigContextLoader.class)
public class StatisticsTest {

    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(StatisticsTest.class);

    @Configuration
    static class ContextConfiguration {
        // this bean will be injected
        @Bean
        public Statistics getStatistic() {
            Statistics statistics = new Statistics();
            statistics.generateStatistic();
            return statistics;
        }
    }

    @Inject
    private Statistics statistics;

    @Test
    public void generateStatistic() throws Exception {
        LOG.info("JUnit test starting ...");
        assertNotNull("array with statistic is NULL", statistics.getStatisticsList());
    }

}