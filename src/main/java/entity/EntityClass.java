package entity;

import java.util.Date;

public class EntityClass {
    private String name;
    private String email;
    private Date dateFrom;
    private Date dateTill;
    private Date dateRegistration;
    private boolean clearing;
    private boolean breakfast;

    public EntityClass(){}

    public EntityClass(String name, String email, Date dateFrom, Date dateTill, Date dateRegistration, boolean clearing, boolean breakfast) {
        this.name = name;
        this.email = email;
        this.dateFrom = dateFrom;
        this.dateTill = dateTill;
        this.dateRegistration = dateRegistration;
        this.clearing = clearing;
        this.breakfast = breakfast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTill() {
        return dateTill;
    }

    public void setDateTill(Date dateTill) {
        this.dateTill = dateTill;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public boolean isClearing() {
        return clearing;
    }

    public void setClearing(boolean clearing) {
        this.clearing = clearing;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }
}
