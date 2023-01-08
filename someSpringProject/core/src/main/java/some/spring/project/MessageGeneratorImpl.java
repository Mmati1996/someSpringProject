package some.spring.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct
    public void init(){
        logger.info("game = {}", game);
    }
    @Override
    public String getMainMessage() {
        return "Number is Between " + game.getSmallest() + " and "+ game.getBiggest();
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()){
            return "you guessed it, that's "+game.getNumber();
        } else if (game.isGameLost()) {
            return "you lost";
        } else if (!game.isValidNumberRange()) {
            return "invalid number";
        } else if (game.getRemainingGuesses()==guessCount) {
            return "what is your 1st guess?";
        }
        else {
            String direction = "lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "higher";
            }
            return direction+" you have "+game.getRemainingGuesses()+ " guesses";
        }
    }
}
