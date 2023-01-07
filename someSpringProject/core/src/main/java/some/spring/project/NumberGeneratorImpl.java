package some.spring.project;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{

    private final Random rand = new Random();
    private int maxNumber = 100;

    @Override
    public int next() {
        return rand.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
