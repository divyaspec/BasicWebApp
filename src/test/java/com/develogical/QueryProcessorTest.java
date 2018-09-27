package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void isAskingMyNameThenReturnName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("awesome"));
    }

    @Test
    public void isLargest() throws Exception {
        assertThat(queryProcessor.process("72064aa0: which of the following numbers is the largest: 79, 0, 98, 908"), is("908"));
    }

    @Test
    public void isPlus() throws Exception {
        assertThat(queryProcessor.process("5737ebd0: what is 11 plus 7"), is("18"));
    }

    @Test
    public void isMultiplied() throws Exception {
        assertThat(queryProcessor.process("5737ebd0: what is 11 multiplied 7"), is("77"));
    }

    //which city is the Eiffel tower in
    @Test
    public void isEiffel() throws Exception {
        assertThat(queryProcessor.process("5737ebd0: which city is the Eiffel tower in"), is("Paris"));
    }

    @Test
    public void isMinus() throws Exception {
        assertThat(queryProcessor.process("0df512f0: what is 2 minus 16"), is("-14"));
    }

    @Test
    public void isBothSquareAndCube() throws Exception {
        assertThat(queryProcessor.process("3a046b0: which of the following numbers is both a square and a cube: 720, 169"), is("169"));
    }
}
