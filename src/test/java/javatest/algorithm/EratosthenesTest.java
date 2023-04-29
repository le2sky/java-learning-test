package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EratosthenesTest {

    @Test
    void eratosthenes_0부터_100까지_소수_구하기() {
        int n = 100;
        boolean[] primes = eratosthenes(n);

        assertThat(primes[78]).isFalse();
        assertThat(primes[66]).isFalse();
        assertThat(primes[61]).isTrue();
        assertThat(primes[67]).isTrue();
        assertThat(primes[97]).isTrue();
    }

    private boolean[] eratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}
