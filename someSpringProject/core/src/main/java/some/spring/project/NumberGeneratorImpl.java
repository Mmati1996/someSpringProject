package some.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{

    private final Random rand = new Random();
    @Autowired
    @MaxNumber
    private int maxNumber;

    @Override
    public int
    next() {
        return rand.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
