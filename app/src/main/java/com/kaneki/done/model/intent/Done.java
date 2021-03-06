package com.kaneki.done.model.intent;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/4/1
 * @email yueqian@mogujie.com
 */
public class Done implements Parcelable {

    private long id;
    private String title;
    private int targetType;
    private int achievePoint;
    private int targetPoints;
    private int currentPoints;
    private int color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public int getAchievePoint() {
        return achievePoint;
    }

    public void setAchievePoint(int achievePoint) {
        this.achievePoint = achievePoint;
    }

    public int getTargetPoints() {
        return targetPoints;
    }

    public void setTargetPoints(int targetPoints) {
        this.targetPoints = targetPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.targetType);
        dest.writeInt(this.achievePoint);
        dest.writeInt(this.targetPoints);
        dest.writeInt(this.currentPoints);
        dest.writeInt(this.color);
    }

    public Done() {
    }

    protected Done(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.targetType = in.readInt();
        this.achievePoint = in.readInt();
        this.targetPoints = in.readInt();
        this.currentPoints = in.readInt();
        this.color = in.readInt();
    }

    public static final Parcelable.Creator<Done> CREATOR = new Parcelable.Creator<Done>() {
        @Override
        public Done createFromParcel(Parcel source) {
            return new Done(source);
        }

        @Override
        public Done[] newArray(int size) {
            return new Done[size];
        }
    };
}
