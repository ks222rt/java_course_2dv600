package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Passenger {
    private int feeAmount;
    private String ssid;
    private String regNr;

    public Passenger(int a, String id){
        this.feeAmount = a;
        this.ssid = id;
        this.regNr = null;
    }

    public Passenger(int a, String id, String regNr){
        this.feeAmount = a;
        this.ssid = id;
        this.regNr = regNr;
    }

    public int getAmount(){
        return this.feeAmount;
    }

    public String getSsid(){
        return this.ssid;
    }
}
