package some.spring.project.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import some.spring.project.config.AppConfig;
import some.spring.project.MessageGenerator;
import some.spring.project.NumberGenerator;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();
        logger.info("number = {}", number);
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        logger.info("{}",messageGenerator.getMainMessage());
        logger.info("{}",messageGenerator.getResultMessage());

        context.close();
    }
}
