package com.zielona.tesla.service;

import com.zielona.tesla.model.onlinegame.Clan;
import com.zielona.tesla.model.onlinegame.Players;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnlineGameServiceImpl implements OnlineGameService {
    @Override
    public List<List<Clan>> calculate(Players players) {
        final int groupCount = players.getGroupCount();
        var sorted = players.getClans().stream()
                .sorted(
                        Comparator
                            .comparing(Clan::getPoints).reversed()
                            .thenComparing(Clan::getNumberOfPlayers)
                )
                .collect(Collectors.toCollection(LinkedList::new));

        List<List<Clan>> listOfEntries = new LinkedList<>();
        while (!sorted.isEmpty()) {
            int sum = 0;
            var listOfClans = new LinkedList<Clan>();
            var it = sorted.listIterator();
            while (it.hasNext()) {
                var el = it.next();
                if (sum + el.getNumberOfPlayers() <= groupCount) {
                    listOfClans.add(el);
                    sum += el.getNumberOfPlayers();
                    it.remove();
                    if (sum == groupCount) {
                        break;
                    }
                }
            }
            listOfEntries.add(listOfClans);
        }
        return listOfEntries;
    }
}
