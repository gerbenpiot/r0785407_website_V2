package domain.DB;

import domain.model.Bier;

import java.util.ArrayList;

public class BierDB {
    private ArrayList<Bier> bieren;


    public BierDB(){
        bieren= new ArrayList<Bier>();
    }
    public void addBier(Bier bier){
        bieren.add(bier);

    }
    public void create(String name){
        Bier bier= new Bier(name);
        bieren.add(bier);
    }
    public void create(String name,String beschrijving,double percentage){
        Bier bier = new Bier(name,beschrijving, percentage);
        bieren.add(bier);
    }
    public void create(String name,double percentage){
        Bier bier = new Bier(name, percentage);
        bieren.add(bier);
    }

    public ArrayList<Bier> getBieren() {
        return bieren;
    }
    public Bier getBierMetHoogstePercentage(){
        double percentage =-1;
        Bier bierMetHoogstePercentage =null;
        ArrayList<Bier> bierenlijst=getBieren();
        for(int i = 0; i < bierenlijst.size(); i++){
            if(bierenlijst.get(i).getPercentage() > percentage){
                bierMetHoogstePercentage = bierenlijst.get(i);
                percentage = bierMetHoogstePercentage.getPercentage();
            }
        }
        return bierMetHoogstePercentage;
    }
    public double getHoogstePercentage(){
        double percentage =-1;
        Bier bierMetHoogstePercentage =null;
        ArrayList<Bier> bierenlijst=getBieren();
        for(int i = 0; i < bierenlijst.size(); i++){
            if(bierenlijst.get(i).getPercentage() > percentage){
                bierMetHoogstePercentage = bierenlijst.get(i);
                percentage = bierMetHoogstePercentage.getPercentage();
            }
        }
        return percentage;
    }
}
