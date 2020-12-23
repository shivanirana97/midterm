package com.example.listviewmidterm;

import android.os.Parcel;
import android.os.Parcelable;

public class Name implements Parcelable {

    private  String name;
    private  String login;
    private  String hooksurl;
    private  String teamsurl;

    public Name(String name, String login, String hooksurl, String teamsurl) {
        this.name = name;
        this.login = login;
        this.hooksurl = hooksurl;
        this.teamsurl = teamsurl;
    }


    protected Name(Parcel in) {
        name = in.readString();
        login = in.readString();
        hooksurl = in.readString();
        teamsurl = in.readString();
    }

    public static final Creator<Name> CREATOR = new Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHooksurl() {
        return hooksurl;
    }

    public void setHooksurl(String hooksurl) {
        this.hooksurl = hooksurl;
    }

    public String getTeamsurl() {
        return teamsurl;
    }

    public void setTeamsurl(String teamsurl) {
        this.teamsurl = teamsurl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(login);
        dest.writeString(hooksurl);
        dest.writeString(teamsurl);
    }
}
