package johnny.demarlier.mareu.Model;

import java.util.List;
import java.util.Objects;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Model object representing a meeting
 */

public class Meeting implements Parcelable {

    private Hours mStartMeeting;
    private Hours mStopMeeting;
    private String mDate;
    private Room mPlace;
    private String mTopic;
    private String mMail;
    private Integer mMeetingColor;


    private boolean isConflict(Meeting other) {
        if (this.mPlace.equals(other.mPlace) && this.mDate.equals(other.mDate)) {
            if (this.mStartMeeting.isConflictWithMeetingHours(other) || this.mStopMeeting.isConflictWithMeetingHours(other)) {
                return true;
            }
        }

        return false;
    }

    public boolean isConflict(List<Meeting> others) {
        for (Meeting other : others) {
            if (this.isConflict(other))
                return true;
        }
        return false;
    }

    /**
     * Constructor
     *
     * @param startMeeting
     * @param stopMeeting
     * @param date
     * @param place
     * @param topic
     * @param mail
     */
    public Meeting(Hours startMeeting, Hours stopMeeting, String date, Room place, String topic, String mail) {
        this.mStartMeeting = startMeeting;
        this.mStopMeeting = stopMeeting;
        this.mDate = date;
        this.mPlace = place;
        this.mTopic = topic;
        this.mMail = mail;
        this.mMeetingColor = -14811907;


    }


    protected Meeting(Parcel in) {
        mStartMeeting = in.readParcelable(Hours.class.getClassLoader());
        mStopMeeting = in.readParcelable(Hours.class.getClassLoader());
        mDate = in.readString();
        mPlace = in.readParcelable(Room.class.getClassLoader());
        mTopic = in.readString();
        mMail = in.readString();
        mMeetingColor = in.readInt();
    }

    public static final Creator<Meeting> CREATOR = new Creator<Meeting>() {
        @Override
        public Meeting createFromParcel(Parcel in) {
            return new Meeting(in);
        }

        @Override
        public Meeting[] newArray(int size) {
            return new Meeting[size];
        }
    };

    //----GETTERS & SETTERS---

    public Integer getMeetingColor(){
    return mMeetingColor;}

    public void setMeetingColor(Integer meetingColor) {
        this.mMeetingColor = meetingColor;
    }

    public Hours getStartMeeting() {
        return mStartMeeting;
    }

    public void setStartMeeting(Hours startMeeting) {
        this.mStartMeeting = startMeeting;
    }

    public Hours getStopMeeting() {
        return mStopMeeting;
    }

    public void setStopMeeting(Hours stopMeeting) {
        this.mStopMeeting = stopMeeting;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public Room getPlace() {
        return mPlace;
    }

    public void setPlace(Room place) {
        this.mPlace = place;
    }

    public String getTopic() {
        return mTopic;
    }

    public void setTopic(String topic) {
        this.mTopic = topic;
    }

    public String getMail() {
        return mMail;
    }

    public void setMail(String mail) {
        this.mMail = mail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(mStartMeeting, meeting.mStartMeeting) &&
                Objects.equals(mStopMeeting, meeting.mStopMeeting) &&
                Objects.equals(mDate, meeting.mDate) &&
                Objects.equals(mPlace, meeting.mPlace) &&
                Objects.equals(mTopic, meeting.mTopic) &&
                Objects.equals(mMeetingColor, meeting.mMeetingColor)&&
                Objects.equals(mMail, meeting.mMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mStartMeeting, mStopMeeting, mDate, mPlace, mTopic, mMail);
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mStartMeeting, i);
        parcel.writeParcelable(mStopMeeting, i);
        parcel.writeString(mDate);
        parcel.writeParcelable(mPlace, i);
        parcel.writeString(mTopic);
        parcel.writeString(mMail);
        parcel.writeInt(mMeetingColor);
    }

}
