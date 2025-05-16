package task02;

import java.io.Serializable;

import com.google.common.collect.Lists;

public class TaskObject implements ITask, Serializable {
    int task;
    int result;

    @Override
    public void setExecNumber(int x) {
        this.task = x;
    }

    @Override
    public void exec() {
        var primes = Lists.newArrayList(2, 3);
        for (int n = primes.getLast() + 2; n < task; n += 2) {
            for (int p : primes) {
                if (n % p == 0) {
                    break;
                }
                if (p * p > n) {
                    primes.add(n);
                    break;
                }
            }
        }
        this.result = primes.getLast();
    }

    @Override
    public int getResult() {
        return this.result;
    }

}
