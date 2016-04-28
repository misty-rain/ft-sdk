package com.friendtime.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wutao on 2016/2/25.
 */
public class User implements Parcelable {
    private String name;
    private int sex;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.sex);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.sex = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
