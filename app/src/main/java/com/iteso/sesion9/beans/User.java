package com.iteso.sesion9.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String username, password;
    private boolean isLogged;

    public User(){

    }

    public User(String username, String password, boolean isLogged) {
        this.username = username;
        this.password = password;
        this.isLogged = isLogged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeByte(this.isLogged ? (byte) 1 : (byte) 0);
    }

    protected User(Parcel in){
        this.username = in.readString();
        this.password = in.readString();
        this.isLogged = in.readByte() != 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
