package Simulation;

import entity.Entity;
import entity.terrains.Ground;

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
                if (map.containsKey(coordinates)) {
                    if ((map.getEntityFromMap(coordinates) instanceof Ground)) {
                        sb.append((map.getEntityFromMap(coordinates).getCurrentCoordinates().width)).append((map.getEntityFromMap(coordinates).getCurrentCoordinates().height)).append(" ");
                    } else {
                        sb.append(map.getMap().get(coordinates).icon).append(" ");
                    }

                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
