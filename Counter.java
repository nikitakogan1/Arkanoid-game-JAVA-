/**
 * Counter.
 */
public class Counter {
    private int counter;

    /**
     * constructor.
     *
     * @param n n.
     */
    public Counter(int n) {
        this.counter = n;
    }

    /**
     * increase.
     *
     * @param number number.
     */
    void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * dicrease.
     *
     * @param number number.
     */
    // subtract number from current count.
    void decrease(int number) {
        this.counter = this.counter - number;
    }

    /**
     * get value.
     *
     * @return this.counter.
     */
    // get current count.
    int getValue() {
        return this.counter;
    }
}