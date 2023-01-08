package some.spring.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import some.spring.project.GuessCount;
import some.spring.project.MaxNumber;

@Configuration
public class GameConfig {

    private int maxNumber = 100;
    private int guessCount = 10;

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return  guessCount;
    }
}
