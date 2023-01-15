package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * 경계조건에 따라 테스트 코드를 작성해야 함
 **/

public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest1() {
        // 해당 메소드가 호출되면 어떠한 예외처리도 발생하지 않는지 확인하기
        assertThatCode(() -> PasswordValidator.validate("serverWizard"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과화는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest // 경계값 테스트를 위한 ValueSource 추가
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String password) {
        // 해당 메소드가 호출되면 Exception이 발생하는데 Exception의 타입이 IllegalArgumentException 이고
        // 해당 오류 메세지가 나오는지
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
