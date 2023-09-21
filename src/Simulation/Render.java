package Simulation;

import entity.Entity;

import java.util.HashSet;
import java.util.Set;

public class Render {
    Map map;

    Set<Coordinates> allCoordinates = new HashSet<>();
    public Render(Map map) {
        this.map = map;
    }

    public String renderMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.getHSize(); i++) {
            for (int j = 0; j < map.getWSize(); j++) {
                Coordinates coordinates = new Coordinates(j, i);
//                if (map.getMap().entrySet().contains(coordinates)) {
//                    sb.append(map.getMap().get(coordinates));
//                }

                    if (map.containsKey(coordinates)) {
                        sb.append(map.getMap().get(coordinates).icon);
                    } else {
                        sb.append("_");
                    }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
