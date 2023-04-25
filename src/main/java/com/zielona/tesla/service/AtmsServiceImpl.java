package com.zielona.tesla.service;

import com.zielona.tesla.model.atms.ATM;
import com.zielona.tesla.model.atms.Region;
import com.zielona.tesla.model.atms.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class AtmsServiceImpl implements AtmsService {

    private static final int MAX_NUMBER_OF_REGIONS = 10000;

    @Override
    public List<ATM> calculate(List<Task> tasks) {
        var bucketsOfRegions = new ArrayList<Region>(Collections.nCopies(MAX_NUMBER_OF_REGIONS, null));
        final int counterOfAtms = insertAtmsToBuckets(tasks, bucketsOfRegions);

        return getAtms(bucketsOfRegions, counterOfAtms);
    }

    private ArrayList<ATM> getAtms(ArrayList<Region> bucketsOfRegions, final int counterOfAtms) {
        var result = new ArrayList<ATM>(counterOfAtms);
        for (int i = 1; i < MAX_NUMBER_OF_REGIONS; i++) {
            var region = bucketsOfRegions.get(i);
            if (region == null) {
                continue;
            }
            for (int j = Region.FIRST_QUEUE; j < Region.LAST_QUEUE; j++) {
                var queue = region.getQueue(j);
                if (queue == null) {
                    continue;
                }
                var atmIdIt = queue.iterator();
                while (atmIdIt.hasNext()) {
                    result.add(new ATM(i, atmIdIt.next()));
                    if (counterOfAtms == result.size()) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private int insertAtmsToBuckets(List<Task> tasks, ArrayList<Region> bucketsOfRegions) {
        int counterOfAtms = tasks.size();
        for (Task task: tasks) {
            var region = bucketsOfRegions.get(task.getRegion());
            if (region == null) {
                region = new Region();
                bucketsOfRegions.set(task.getRegion(), region);
            }
            if (insertAtmToRegion(task, region)) {
                counterOfAtms--;
            }
        }
        return counterOfAtms;
    }

    private boolean insertAtmToRegion(Task task, Region region) {
        for (int i = Region.FIRST_QUEUE; i < Region.LAST_QUEUE; i++) {
            Set<Integer> queue = region.getQueue(i);
            if (queue == null) {
                continue;
            }
            if (queue.contains(task.getAtmId())) {
                if (task.getRequestType().getPriority() < i) {
                    queue.remove(task.getAtmId());
                    addAtmIdToQueue(task, region);
                }
                return true;
            }
        }
        addAtmIdToQueue(task, region);
        return false;
    }

    private void addAtmIdToQueue(Task task, Region region) {
        var queue = region.getQueue(task.getRequestType().getPriority());
        if (queue == null) {
            queue = new LinkedHashSet<>();
            queue.add(task.getAtmId());
            region.setQueue(task.getRequestType().getPriority(), queue);
        } else {
            queue.add(task.getAtmId());
        }
    }
}
