package com.zielona.tesla.api;

import com.zielona.tesla.model.onlinegame.Clan;
import com.zielona.tesla.model.onlinegame.Players;
import com.zielona.tesla.service.OnlineGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OnlineGameApiController implements OnlineGameApi {

    private final OnlineGameService onlineGameService;

    @Autowired
    public OnlineGameApiController(OnlineGameService onlineGameService) {
        this.onlineGameService = onlineGameService;
    }

    @Override
    public ResponseEntity<List<List<Clan>>> calculate(Players players) {
        return ResponseEntity.ok().body(onlineGameService.calculate(players));
    }
}
