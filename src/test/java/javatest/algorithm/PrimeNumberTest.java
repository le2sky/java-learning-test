package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PrimeNumberTest {

    @Test
    void 소수_판별() {
        assertThat(isPrime(7)).isTrue();
        assertThat(isPrime(67)).isTrue();
        assertThat(isPrime(3)).isTrue();
        assertThat(isPrime(61)).isTrue();
        assertThat(isPrime(99)).isFalse();
        assertThat(isPrime(1)).isFalse();
        assertThat(isPrime(0)).isFalse();
    }

    private boolean isPrime(int num) {
        if(num < 2)
            return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
