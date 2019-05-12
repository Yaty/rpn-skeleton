package rpn;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.evaluate;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_division() {
        assertThat(evaluate("15 3 /")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_division_with_negative_number() {
        assertThat(evaluate("-15 3 /")).isEqualTo(-5);
    }

    @Test
    public void should_evaluate_multiplication() {
        assertThat(evaluate("20 4 *")).isEqualTo(80);
    }

    @Test
    public void should_evaluate_multiplication_with_negative_number() {
        assertThat(evaluate("-20 4 *")).isEqualTo(-80);
    }

    @Test
    public void should_evaluate_substraction() {
        assertThat(evaluate("8 4 -")).isEqualTo(4);
    }

    @Test
    public void should_evaluate_substraction_with_negative_number() {
        assertThat(evaluate("-8 4 -")).isEqualTo(-12);
    }

    @Test
    public void should_evaluate_substraction_on_a_negative_number() {
        assertThat(evaluate("8 -4 -")).isEqualTo(12);
    }

    @Test
    public void should_evaluate_a_complex_expression() {
        assertThat(evaluate("7 3 12 2 / + * 4 -")).isEqualTo(59);
    }

    @Test
    public void should_evaluate_floating_point_number() {
        assertThat(evaluate("15.651 4.40 +")).isCloseTo(20.051, Offset.offset(0.0001));
    }
}