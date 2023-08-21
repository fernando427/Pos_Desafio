package com.compass.scholarshipprogram.recordExemplo;

import java.util.ArrayList;
import java.util.List;

public class CarreiraCompassCRUD {
    private List<CarreiraCompass> carreiraDatabase = new ArrayList<>();

    public void createCarreiraPerson(String namePerson, String carreira) {
        CarreiraCompass carreiraCompass = new CarreiraCompass(namePerson, carreira);
        carreiraDatabase.add(carreiraCompass);
    }

    public CarreiraCompass readCarreiraPerson(int index) {
        return carreiraDatabase.get(index);
    }

    public void updateCarreiraPerson(int index, String namePerson, String carreira) {
        if (index >= 0 && index < carreiraDatabase.size()) {
            carreiraDatabase.set(index, new CarreiraCompass(namePerson, carreira));
        }
    }

    public void deleteCarreiraPerson(int index) {
        if (index >= 0 && index < carreiraDatabase.size()) {
            carreiraDatabase.remove(index);
        }
    }
}
