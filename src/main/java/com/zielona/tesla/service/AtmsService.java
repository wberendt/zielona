package com.zielona.tesla.service;

import com.zielona.tesla.model.atms.ATM;
import com.zielona.tesla.model.atms.Task;

import java.util.List;

public interface AtmsService {
    List<ATM> calculate(List<Task> task);
}
