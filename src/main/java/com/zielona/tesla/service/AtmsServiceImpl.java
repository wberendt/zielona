package com.zielona.tesla.service;

import com.zielona.tesla.model.atms.ATM;
import com.zielona.tesla.model.atms.Region;
import com.zielona.tesla.model.atms.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AtmsServiceImpl implements AtmsService {

    private static final int MAX_NUMBER_OF_REGIONS = 10000;

    @Override
    public List<ATM> calculate(List<Task> tasks) {
        var bucketsOfRegions = new ArrayList<Region>(Collections.nCopies(MAX_NUMBER_OF_REGIONS, null));
        final int counterOfAtms = insertAtmsToBuckets(tasks, bucketsOfRegions);
        return getAtms(bucketsOfRegions, counterOfAtms);
    }

    private int insertAtmsToBuckets(List<Task> tasks, List<Region> bucketsOfRegions) {
        int counterOfAtms = tasks.size();
        for (Task task: tasks) {
            var region = bucketsOfRegions.get(task.getRegion());
            if (region == null) {
                region = new Region(task.getRequestType().getPriority(), task.getAtmId());
                bucketsOfRegions.set(task.getRegion(), region);
            } else {
                if (region.addAtm(task.getRequestType().getPriority(), task.getAtmId())) {
                    counterOfAtms--;
                }
            }
        }
        return counterOfAtms;
    }

    private List<ATM> getAtms(List<Region> bucketsOfRegions, final int counterOfAtms) {
        var result = new ArrayList<ATM>(counterOfAtms);
        for (int regionId = 1; regionId < MAX_NUMBER_OF_REGIONS; regionId++) {
            var region = bucketsOfRegions.get(regionId);
            if (region != null) {
                region.fill(result, regionId);
                if (result.size() == counterOfAtms) {
                    break;
                }
            }
        }
        return result;
    }
}
