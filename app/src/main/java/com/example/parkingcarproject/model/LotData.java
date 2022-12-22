package com.example.parkingcarproject.model;

import java.util.ArrayList;

public class LotData  {
    public static final ArrayList<Lot> lots = new ArrayList<>();
    public LotData(){
            lots.add(new Lot(1 , true));
            lots.add(new Lot(2 , false));
            lots.add(new Lot(3 , true));
            lots.add(new Lot(5 , false));
            lots.add(new Lot(6 , true));
            lots.add(new Lot(7 , false));
            lots.add(new Lot(8 , true));
            lots.add(new Lot(9 , true));
    }

    public static Lot search_lot(int lotId) {
        for(Lot lot : lots){
            if(lot.getId() == lotId)
                return lot;
        }
        return null;
    }



}
