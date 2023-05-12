package com.zielona.tesla.api;

import com.zielona.tesla.model.onlinegame.Clan;
import com.zielona.tesla.model.onlinegame.Players;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OnlineGameApi {

    /**
     * POST /onlinegame/calculate
     * Calculate order
     *
     * @param players  (required)
     * @return Successful operation (status code 200)
     */
    @PostMapping(value = "/onlinegame/calculate",
            produces = "application/json",
            consumes = "application/json")
    ResponseEntity<List<List<Clan>>> calculate(@RequestBody Players players);
}
