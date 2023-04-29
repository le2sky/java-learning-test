package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/*
  좌표 [x1, y1]과 [x2, y2]에 대해서
  피타고라스 정리 = pow(a, 2) + pow(b, 2) = pow(c, 2)
  distance = sqrt(pow(x2 - x1) + pow(y2 - y1))
 */
class EuclideanDistanceTest {

    @Test
    void 유클리드_거리() {
        assertThat(getDistance(new int[]{1, 2}, new int[]{3, 4}))
            .isEqualTo(2.82);
    }

    private double getDistance(int[] a, int[] b) {
        double distance = Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
        return Math.floor(distance * 100) / 100.0;
    }
}
