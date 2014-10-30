/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Dillon
 */
public class Ship implements Serializable {
    private int count = 0;
    private int limit, fuel, hull, price;
    //private int fuel;
    private String shipType;
    protected int nwater, nfur, nfood, nore, ngame, nfire, nmed, nmach, nnarc, nrob;
    protected String[] cargo = new String[limit];
    
    public Ship(String shipType) {
        this.fuel = 100;
        this.shipType = shipType;
        setShipAttributes(shipType);
    }
    public String getShipName() {
        return shipType;
    }
    @Override
    public String toString() {
        return shipType;
                
    }
    public void setShipAttributes(String shipType) {
        switch (shipType) {
            case "Flea":
                limit = 10;
                fuel = 20;
                hull = 25;
                price = 2000;
            case "Gnat":
                limit = 15;
                fuel = 13;
                hull = 100;
                price = 10000;
            case "Firefly":
                limit = 20;
                fuel = 17;
                hull = 100;
                price = 25000;
            case "Mosquito":
                limit = 15;
                fuel = 13;
                hull = 100;
                price = 30000;
            case "Bumblebee":
                limit = 25;
                fuel = 16;
                hull = 100;
                price = 60000;
        }
    }
    public int getCount() {
        return count;
    }
    
    public String getCargo(int i) {
        return cargo[i];
    }
    public int getPrice() {
        return price;
    }
    public void addCargo(int amount, String good) {
        int total = nwater + nfur + nfood + nore + ngame + nfire + nmed + nmach + nnarc + nrob;
        if (total <= limit) {
            if (good.equals("Water")) {
                nwater += amount;
                count++;
            }
            if (good.equals("Fur")) {
                nfur += amount;
                count++;
            }
            if (good.equals("Food")) {
                nfood += amount;
                count++;
            }
            if (good.equals("Ore")) {
                count++;
                nore += amount;
            }
            if (good.equals("Game")) {
                count++;
                ngame += amount;
            }
            if (good.equals("Firearm")) {
                count++;
                nfire += amount;
            }
            if (good.equals("Medicine")) {
                count++;
                nmed += amount;
            }
            if (good.equals("Machine")) {
                count++;
                nmach += amount;
            }
            if (good.equals("Narcotic")) {
                count++;
                nnarc += amount;
            }
            if (good.equals("Robot")) {
                count++;
                nrob += amount;
            }
        }
        
    }
    
    public void sellCargo(int amount, String good) {
        int total = nwater + nfur + nfood + nore + ngame + nfire + nmed + nmach + nnarc + nrob;
        if (total > 0) {
            if (good.equals("Water")) {
                count--;
                nwater -= amount;
            }
            if (good.equals("Fur")) {
                count--;
                nfur -= amount;
            }
            if (good.equals("Food")) {
                count--;
                nfood -= amount;
            }
            if (good.equals("Ore")) {
                count--;
                nore -= amount;
            }
            if (good.equals("Game")) {
                count--;
                ngame -= amount;
            }
            if (good.equals("Firearm")) {
                count--;
                nfire -= amount;
            }
            if (good.equals("Medicine")) {
                count--;
                nmed -= amount;
            }
            if (good.equals("Machine")) {
                count--;
                nmach -= amount;
            }
            if (good.equals("Narcotic")) {
                count--;
                nnarc -= amount;
            }
            if (good.equals("Robot")) {
                count--;
                nrob -= amount;
            }
        }
    }
    
    public int getFuel() {
        return fuel;
    }
    
    public int fuelToMiles(int shipType, int fuel) {
        return fuel * shipType;
    }
    
    public int milesToFuel(int shipType, int miles) {
        return miles / shipType;
    }
    /**
     * If able to travel, sets the new location and updates the ships fuel.
     * @param dest the destination solar system
     */
    public boolean travel(SolarSystem dest) {
        int miles = fuelToMiles(1, fuel);
        Universe universe = GameData.getUniverse();
        double distance = universe.distance(universe.getCurrentSolarSystem(), dest);
        if (miles < distance) {
            System.out.println("Ship unable to travel that distance");
            return false;
        } else {
            universe.setCurrentSolarSystem(dest);
            miles = Math.abs((int)distance - miles);
            fuel = milesToFuel(1, miles);
            return true;
        }
    }
    
    public int getLimit() {
        return limit;
    }
}
