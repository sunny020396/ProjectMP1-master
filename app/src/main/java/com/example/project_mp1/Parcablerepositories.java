package com.example.project_mp1;

import android.os.Parcel;
import android.os.Parcelable;

public class Parcablerepositories implements Parcelable {

    String repname, customername, customerimage, lang, des, follower, follow, company, userrepos;

    public Parcablerepositories(String repname, String customername, String customerimage, String lang, String des, String follower, String follow, String company, String userrepos) {
        this.repname = repname;
        this.customername = customername;
        this.customerimage = customerimage;
        this.lang = lang;
        this.des = des;
        this.follower = follower;
        this.follow = follow;
        this.company = company;
        this.userrepos = userrepos;
    }

    public String getRepname() {
        return repname;
    }

    public void setRepname(String repname) {
        this.repname = repname;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerimage() {
        return customerimage;
    }

    public void setCustomerimage(String customerimage) {
        this.customerimage = customerimage;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserrepos() {
        return userrepos;
    }

    public void setUserrepos(String userrepos) {
        this.userrepos = userrepos;
    }

    public static Creator<Parcablerepositories> getCREATOR() {
        return CREATOR;
    }

    protected Parcablerepositories(Parcel in) {
        repname = in.readString();
        customername = in.readString();
        customerimage = in.readString();
        lang = in.readString();
        des = in.readString();
        follower = in.readString();
        follow = in.readString();
        company = in.readString();
        userrepos = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(repname);
        dest.writeString(customername);
        dest.writeString(customerimage);
        dest.writeString(lang);
        dest.writeString(des);
        dest.writeString(follower);
        dest.writeString(follow);
        dest.writeString(company);
        dest.writeString(userrepos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Parcablerepositories> CREATOR = new Creator<Parcablerepositories>() {
        @Override
        public Parcablerepositories createFromParcel(Parcel in) {
            return new Parcablerepositories(in);
        }

        @Override
        public Parcablerepositories[] newArray(int size) {
            return new Parcablerepositories[size];
        }
    };
}
