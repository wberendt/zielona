package com.zielona.tesla.model.atms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Region {

    private static final int FIRST_QUEUE = 0;
    private static final int QUEUE_OF_FAILURE_RESTART = FIRST_QUEUE;
    private static final int QUEUE_OF_PRIORITY = QUEUE_OF_FAILURE_RESTART + 1;
    private static final int QUEUE_OF_SIGNAL_LOW = QUEUE_OF_PRIORITY + 1;
    private static final int QUEUE_OF_STANDARD = QUEUE_OF_SIGNAL_LOW + 1;
    private static final int LAST_QUEUE = QUEUE_OF_STANDARD + 1;

    private final List<Set<Integer>> queue;

    public Region(int priority, int atmId) {
        this.queue = new ArrayList<>(Collections.nCopies(LAST_QUEUE, null));
        createSetOfAtmsAndAddFirst(priority, atmId);
    }

    public boolean addAtm(int priority, int atmId) {
        for (int q = Region.FIRST_QUEUE; q < Region.LAST_QUEUE; q++) {
            var setOfAtms = queue.get(q);
            if (setOfAtms != null && setOfAtms.contains(atmId)) {
                if (priority < q) {
                    setOfAtms.remove(atmId);
                    addAtmIdToQueue(priority, atmId);
                }
                return true;
            }
        }
        addAtmIdToQueue(priority, atmId);
        return false;
    }

    public void fill(List<ATM> atms, final int regionNum) {
        for (int q = Region.FIRST_QUEUE; q < Region.LAST_QUEUE; q++) {
            var setOfAtms = queue.get(q);
            if (setOfAtms != null) {
                atms.addAll(setOfAtms.stream()
                        .map(e -> new ATM(regionNum, e))
                        .toList());
            }
        }
    }

    private void addAtmIdToQueue(int priority, int atmId) {
        var setOfAtms = queue.get(priority);
        if (setOfAtms == null) {
            createSetOfAtmsAndAddFirst(priority, atmId);
        } else {
            setOfAtms.add(atmId);
        }
    }

    private void createSetOfAtmsAndAddFirst(int priority, int atmId) {
        var setOfAtms = new LinkedHashSet<Integer>();
        setOfAtms.add(atmId);
        queue.set(priority, setOfAtms);
    }
}
