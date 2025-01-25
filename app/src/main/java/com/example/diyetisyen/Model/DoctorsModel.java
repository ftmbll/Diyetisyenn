package com.example.diyetisyen.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class DoctorsModel implements Parcelable {
    private String Address;
    private String Biography;
    private int Id;
    private String Name;
    private String Picture;
    private String Special;
    private int Experience;
    private String Cast;
    private String Date;
    private String Time;
    private String location;
    private String Mobile;
    private String Patiens;
    private double Raiting;
    private String Site;

    public DoctorsModel(){
        this.Address = "";
        this.Biography = "";
        this.Id = 0;
        this.Name = "";
        this.Picture = "";
        this.Special = "";
        this.Experience = 0;
        this.Cast = "";
        this.Date = "";
        this.Time = "";
        this.location = "";
        this.Mobile = "";
        this.Patiens = "";
        this.Raiting = 0.0;
        this.Site = "";
    }

    protected DoctorsModel(Parcel in){
        Address = in.readString();
        Biography = in.readString();
        Id = in.readInt();
        Name = in.readString();
        Picture = in.readString();
        Special = in.readString();
        Experience = in.readInt();
        Cast = in.readString();
        Date = in.readString();
        Time = in.readString();
        location = in.readString();
        Mobile = in.readString();
        Patiens = in.readString();
        Raiting = in.readDouble();
        Site = in.readString();
    }

    public static final Creator<DoctorsModel> CREATOR = new Creator<DoctorsModel>() {
        @Override
        public DoctorsModel createFromParcel(Parcel in) {
            return new DoctorsModel(in);
        }

        @Override
        public DoctorsModel[] newArray(int size) {
            return new DoctorsModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeString(Address);
        parcel.writeString(Biography);
        parcel.writeInt(Id);
        parcel.writeString(Name);
        parcel.writeString(Picture);
        parcel.writeString(Special);
        parcel.writeInt(Experience);
        parcel.writeString(Cast);
        parcel.writeString(Date);
        parcel.writeString(Time);
        parcel.writeString(location);
        parcel.writeString(Mobile);
        parcel.writeString(Patiens);
        parcel.writeDouble(Raiting);
        parcel.writeString(Site);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    // Getter ve Setter metodları
    public String getAddress(){
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getSpecial() {
        return Special;
    }

    public void setSpecial(String special) {
        Special = special;
    }

    public int getExprience() {
        return Experience;
    }

    public void setExprience(int exprience) {
        Experience = exprience;
    }

    public String getCost() {
        return Cast;
    }

    public void setCost(String cast) {
        Cast = cast;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String Location) {
        location = Location;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPatiens() {
        return Patiens;
    }

    public void setPatiens(String patiens) {
        Patiens = patiens;
    }

    public double getRating() {
        return Raiting;
    }

    public void setRating(double rating) {
        Raiting = rating;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String size) {
        Site = size;
    }

}
