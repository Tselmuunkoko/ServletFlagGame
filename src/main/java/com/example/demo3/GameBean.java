package com.example.demo3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class GameBean implements Serializable {
    private final ArrayList<String> countryNameList = new ArrayList<>();
    private final ArrayList<String> Flags = new ArrayList<>();
    public GameBean() {
        this.countryNameList.add("Algeria");
        this.countryNameList.add("Armenia");
        this.countryNameList.add("Chad");
        this.countryNameList.add("Czech Republic");
        this.countryNameList.add("Djibouti");
        this.countryNameList.add("Gabon");
        this.countryNameList.add("Indonesia");
        this.countryNameList.add("Lithuania");
        this.countryNameList.add("Malta");
        this.countryNameList.add("Ukraine");
        Random rand = new Random();
        ArrayList<String> temp = new ArrayList<>(this.countryNameList);
        String tempName;
        for (int i = 0; i < 3; i++) {
            tempName = temp.get(rand.nextInt(temp.size()));
            this.Flags.add(tempName);
            temp.remove(tempName);
        }
    }

    public ArrayList<String> getFlags() {
        return Flags;
    }

    public ArrayList<String> getCountryNameList() {
        return countryNameList;
    }
    public Integer match(ArrayList<Integer> answers) {
        ArrayList<Integer> flags = new ArrayList<>();
        flags.add(this.countryNameList.indexOf(this.Flags.get(0))+1);
        flags.add(this.countryNameList.indexOf(this.Flags.get(1))+1);
        flags.add(this.countryNameList.indexOf(this.Flags.get(2))+1);
        if(flags.equals(answers))
            return 3;
        return -1;
    }
}

