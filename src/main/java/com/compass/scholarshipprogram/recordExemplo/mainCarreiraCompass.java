package com.compass.scholarshipprogram.recordExemplo;

public class mainCarreiraCompass {
    public static void main(String[] args) {
        CarreiraCompassCRUD crud = new CarreiraCompassCRUD();

        crud.createCarreiraPerson("João", "Data Analytics");
        crud.createCarreiraPerson("Rebeca", "Backend");

        System.out.println(crud.readCarreiraPerson(0));

        crud.updateCarreiraPerson(1, "Maria", "Frontend");
        System.out.println(crud.readCarreiraPerson(1));

        crud.deleteCarreiraPerson(0);
        System.out.println(crud.readCarreiraPerson(0));
    }
}
