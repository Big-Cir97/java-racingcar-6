package racingcar.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;
    @BeforeEach
    void setInputValidator() {
        inputValidator = new InputValidator();
    }
    @Test
    @DisplayName("시도할 횟수를 정하는 입력은 숫자만 입력할 수 있다.")
    void testTryCountOnlyNumber() {
        String tryCount = "notNumber";
        String exceptionMessage = "시도할 횟수는 숫자만 입력 가능합니다.";

        assertThatThrownBy(() -> inputValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exceptionMessage);
    }
}