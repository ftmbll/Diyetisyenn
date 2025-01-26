package com.example.diyetisyen.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class DoctorsModel implements Parcelable { //parcelable ile sınıfın nesnelerinin diğer aktiviteler arasında taşınabilir hale gelmesini sağlar
    private String Address;
    private String Biography;
    private int Id;
    private String Name;
    private String Picture;
    private String Special;
    private int Experience;
    private String Cost;
    private String Date;
    private String Time;
    private String location;
    private String Mobile;
    private String Patients;
    private double Rating;
    private String Site;

    public DoctorsModel(){
        this.Address = "";
        this.Biography = "";
        this.Id = 0;
        this.Name = "";
        this.Picture = "";
        this.Special = "";
        this.Experience = 0;
        this.Cost = "";
        this.Date = "";
        this.Time = "";
        this.location = "";
        this.Mobile = "";
        this.Patients = "";
        this.Rating = 0.0;
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
        Cost = in.readString();
        Date = in.readString();
        Time = in.readString();
        location = in.readString();
        Mobile = in.readString();
        Patients = in.readString();
        Rating = in.readDouble();
        Site = in.readString();
    }

    public static final Creator<DoctorsModel> CREATOR = new Creator<DoctorsModel>() {
        @Override
        public DoctorsModel createFromParcel(Parcel in) {
            return new DoctorsModel(in);
        } //parcel nesnesinden sınıf özelliklerini okur

        @Override
        public DoctorsModel[] newArray(int size) {
            return new DoctorsModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int flags){ //nesnenin verilerini başka bir aktiviteye göndermek için gerekli metod
        parcel.writeString(Address);
        parcel.writeString(Biography);
        parcel.writeInt(Id);
        parcel.writeString(Name);
        parcel.writeString(Picture);
        parcel.writeString(Special);
        parcel.writeInt(Experience);
        parcel.writeString(Cost);
        parcel.writeString(Date);
        parcel.writeString(Time);
        parcel.writeString(location);
        parcel.writeString(Mobile);
        parcel.writeString(Patients);
        parcel.writeDouble(Rating);
        parcel.writeString(Site);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    // Getter ve Setter metodları, sınıf içindeki verilere dışarıdan erişmek için
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

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
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

    public String getPatients() {
        return Patients;
    }

    public void setPatients(String patients) {
        Patients = patients;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String size) {
        Site = size;
    }

}
