package com.zielona.tesla.model.atms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Region {

    public static final int FIRST_QUEUE = 0;
    public static final int QUEUE_OF_FAILURE_RESTART = FIRST_QUEUE;
    public static final int QUEUE_OF_PRIORITY = QUEUE_OF_FAILURE_RESTART + 1;
    public static final int QUEUE_OF_SIGNAL_LOW = QUEUE_OF_PRIORITY + 1;
    public static final int QUEUE_OF_STANDARD = QUEUE_OF_SIGNAL_LOW + 1;
    public static final int LAST_QUEUE = QUEUE_OF_STANDARD + 1;

    private final List<Set<Integer>> queue = new ArrayList<>(Collections.nCopies(LAST_QUEUE, null));

    public Set<Integer> getQueue(int q) {
        return queue.get(q);
    }

    public void setQueue(int index, Set<Integer> aSet) {
        this.queue.set(index, aSet);
    }
}
