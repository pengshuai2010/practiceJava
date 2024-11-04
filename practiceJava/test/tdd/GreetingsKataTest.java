package tdd;

import org.junit.Assert;
import org.junit.Test;

public class GreetingsKataTest {
    @Test
    public void testGreetings() {
        GreetingsKata greetingsKata = new GreetingsKata();
        String name = "Bob";
        Assert.assertEquals(String.format("Hello, %s.", name), greetingsKata.greet(name));
    }
}
