package nirmalkar.dalejan.expensemanager;

/**
 * Created by DALEJAN1 on 3/30/2017.
 */

public class DatabaseExpense {
     String itemname;
     String itempric;
     String itemdate;
     String itempay;
     String itemdescrip;
     int day;
     int month;
    public DatabaseExpense(){

    }

    public DatabaseExpense(String s, String s1, String s2, String s3, String s4,int day,int month) {
        this.itemname=s;
        this.itempric=s1;
        this.itemdate=s2;
        this.itempay=s3;
        this.itemdescrip=s4;
        this.day=day;
        this.month=month;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItempric() {
        return itempric;
    }

    public void setItempric(String itempric) {
        this.itempric = itempric;
    }

    public String getItemdate() {
        return itemdate;
    }

    public void setItemdate(String itemdate) {
        this.itemdate = itemdate;
    }

    public String getItempay() {
        return itempay;
    }

    public void setItempay(String itempay) {
        this.itempay = itempay;
    }

    public String getItemdescrip() {
        return itemdescrip;
    }

    public void setItemdescrip(String itemdescrip) {
        this.itemdescrip = itemdescrip;
    }
}

