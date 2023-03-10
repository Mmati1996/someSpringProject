package some.spring.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GameImpl implements Game{
    private static final Logger logger = LoggerFactory.getLogger(GameImpl.class);
    @Autowired
    private NumberGenerator numberGenerator;
    @Autowired
    @GuessCount
    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean isNumberRangeValid = true;

    @PostConstruct
    @Override
    public void reset() {
        smallest=0;
        guess=0;
        remainingGuesses=guessCount;
        biggest=numberGenerator.getMaxNumber();
        number=numberGenerator.next();
        logger.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("pre destroy is being called");
    }
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getGuessCount(){
        return this.guessCount;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (isNumberRangeValid){
            if (guess>number){
                biggest = guess - 1;
            }
            if (guess<number){
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return isNumberRangeValid;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses<=0 ;
    }

    private void checkValidNumberRange() {
        isNumberRangeValid = (guess>=smallest) && (guess <= biggest);
    }
}
