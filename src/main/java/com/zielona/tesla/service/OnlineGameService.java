package com.zielona.tesla.service;

import com.zielona.tesla.model.onlinegame.Clan;
import com.zielona.tesla.model.onlinegame.Players;

import java.util.List;

public interface OnlineGameService {
    List<List<Clan>> calculate(Players players);
}
