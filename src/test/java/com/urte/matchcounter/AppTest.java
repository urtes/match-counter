package com.urte.matchcounter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class AppTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void exitsIfArgsLengthIncorrect() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> assertEquals("Please enter two numbers\n",
                systemOutRule.getLogWithNormalizedLineSeparator()));
        App.main(new String[]{"1"});
    }

    @Test
    public void exitsIfCannotParseNumbers() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> assertEquals("Please enter two numbers\n",
                systemOutRule.getLogWithNormalizedLineSeparator()));
        App.main(new String[]{"A", "B"});
    }
}
