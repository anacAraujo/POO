package aula09.Ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlaneManager {
    Map<String, Plane> frota;

    public PlaneManager() {
        frota = new HashMap<>();
    }

    public void addPlane(Plane plane) {
        // if (frota.containsKey(plane.getId())) {
        // System.out.println("Já existe este id.");
        // return;
        // }
        frota.put(plane.getId(), plane);
    }

    public void removePlane(String id) {
        if (frota.containsKey(id)) {
            frota.remove(id);
        }
    }

    public Plane searchPlane(String id) {
        if (frota.containsKey(id)) {
            return frota.get(id);
        }
        return null;
    }

    public ArrayList<Plane> getCommercialPlanes() {
        ArrayList<Plane> planes = new ArrayList<>();
        for (Map.Entry<String, Plane> entry : frota.entrySet()) {
            if (entry.getValue().getPlaneType().equals("Comercial")) {
                planes.add(entry.getValue());
            }
        }
        return planes;
    }

    public ArrayList<Plane> getMilitaryPlanes() {
        ArrayList<Plane> planes = new ArrayList<>();
        for (Map.Entry<String, Plane> entry : frota.entrySet()) {
            if (entry.getValue().getPlaneType().equals("Militar")) {
                planes.add(entry.getValue());
            }
        }
        return planes;
    }

    public void printAllPlanes() {
        for (Map.Entry<String, Plane> entry : frota.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    public Plane getFastestPlane() {
        int velocidadeMax = 0;
        Plane fastPlane = null;
        for (Map.Entry<String, Plane> entry : frota.entrySet()) {
            if (entry.getValue().getMaxVelocidade() > velocidadeMax) {
                velocidadeMax = entry.getValue().getMaxVelocidade();
                fastPlane = entry.getValue();
            }
        }
        return fastPlane;
    }
}
