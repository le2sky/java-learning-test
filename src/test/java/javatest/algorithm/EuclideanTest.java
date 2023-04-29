package javatest.algorithm;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/*
 gcd(a,b) = gcd(b, a % b)
 if a % b = 0 then gcd is b
 else gcd(b, a % b)

 lcm(a,b) = (a*b) / gcd(a,b)
 */
class EuclideanTest {

    @Test
    void gcdTest() {
        assertThat(gcd(72, 30)).isEqualTo(6);
        assertThat(gcd(12, 6)).isEqualTo(6);
        assertThat(gcd(18, 3)).isEqualTo(3);
        assertThat(gcd(532, 462)).isEqualTo(14);
        assertThat(gcd(462, 532)).isEqualTo(14);
    }

    @Test
    void lcmTest() {
        assertThat(lcm(53, 4364)).isEqualTo(231292);
        assertThat(lcm(4364, 53)).isEqualTo(231292);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
