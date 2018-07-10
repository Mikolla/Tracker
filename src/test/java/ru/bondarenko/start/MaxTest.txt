package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Bondarenko Nikolay
* @version 012
* @since 02.06.2018
*/
public class MaxTest {
/**
* Test max.
*/
@Test
public void maxTester() {
	int first = 5;
	int second = 4;
	Max maxi = new Max();
	int result = maxi.max(first, second);
	assertThat(result, is(first));
}
}