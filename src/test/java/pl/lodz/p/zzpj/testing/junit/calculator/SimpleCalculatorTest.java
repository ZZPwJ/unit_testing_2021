package pl.lodz.p.zzpj.testing.junit.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class SimpleCalculatorTest {

    SimpleCalculator sut;


    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void setUp() {
        sut = new SimpleCalculator();
    }


    @Test
    public void shouldAddTwoNumbers() {
        assertEquals( 5.8, sut.add(3.5, 2.3), 0.00001);
    }

    @Test
    public void shouldSubtractTwoNumbers() {
        assertEquals( 1.0, sut.subtract(6.0, 5), 0.00001);
    }

    @Test
    public void shouldDivideTwoNumbers() throws CannotDivideByZeroException {
        assertEquals(4, sut.divide(8, 2), 0.00001);
    }

    @Test
    public void shouldCalculateSquareRoot() throws CannotCalculateSquareRootOfNegativeNumber {
        assertEquals(8, sut.calculateSquareRoot(64), 0.00001);
    }

    @Test
    @Parameters({"3", "7", "73"})
    public void shouldCheckIfNumberIsPrime(int prime) {
        assertTrue(sut.isPrime(prime));
    }

    @Test
    @Parameters(method = "getTestSet")
    public void shouldCheckIfNumberIsPrimeOrNot(int prime, boolean resultFlag) {
        assertEquals(resultFlag, sut.isPrime(prime));
    }

    public Object[] getTestSet() {
        return $(
                $(3, true),
                $(5, true),
                $(21, false)
        );
    }

    @Test(expected = CannotDivideByZeroException.class)
    public void shouldThrowAnExceptionDivideByZero() throws CannotDivideByZeroException {
        sut.divide(12,0);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowAnExceptionNegativeNumberInSquareRoot() throws CannotCalculateSquareRootOfNegativeNumber {
        exceptionRule.expect(CannotCalculateSquareRootOfNegativeNumber.class);
        sut.calculateSquareRoot(-12);
    }

    @Test
    public void shouldThrownExceptionAssertj() {
        assertThatExceptionOfType(CannotDivideByZeroException.class)
                .isThrownBy(() -> {
                    sut.divide(2,0);
                }).withMessage("Can't by zero!");

        assertThatThrownBy(() -> {
            sut.calculateSquareRoot(-1);
        }).isInstanceOf(CannotCalculateSquareRootOfNegativeNumber.class);
    }
}