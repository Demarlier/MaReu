package johnny.demarlier.mareu.Model;
import java.util.Objects;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model object representing a meeting
 */

public class Meeting implements Parcelable {

    private String startMeeting;
    private String stopMeeting;
    private String date;
    private Room place;
    private String topic;
    private String mail;



    public boolean intersect(Meeting m){
        return place.equals(m.place);
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
    public Meeting(String startMeeting, String stopMeeting, String date, Room place, String topic, String mail) {
        this.startMeeting = startMeeting;
        this.stopMeeting = stopMeeting;
        this.date = date;
        this.place = place;
        this.topic = topic;
        this.mail = mail;

    }


    protected Meeting(Parcel in) {
        startMeeting = in.readString();
        stopMeeting = in.readString();
        date = in.readString();
        place = in.readParcelable(Room.class.getClassLoader());
        topic = in.readString();
        mail = in.readString();
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
    public String getStartMeeting() {
        return startMeeting;
    }

    public void setStartMeeting(String startMeeting) {
        this.startMeeting = startMeeting;
    }

    public String getStopMeeting(){ return stopMeeting; }

    public void setStopMeeting(String stopMeeting) { this.stopMeeting = stopMeeting; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Room getPlace() {
        return place;
    }

    public void setPlace(Room place) {
        this.place = place;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        return Objects.equals(startMeeting, meeting.startMeeting) &&
                Objects.equals(stopMeeting, meeting.stopMeeting) &&
                Objects.equals(date, meeting.date) &&
                Objects.equals(place, meeting.place) &&
                Objects.equals(topic, meeting.topic) &&
                Objects.equals(mail, meeting.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startMeeting, stopMeeting, date, place, topic, mail);
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(startMeeting);
        parcel.writeString(stopMeeting);
        parcel.writeString(date);
        parcel.writeParcelable(place, i);
        parcel.writeString(topic);
        parcel.writeString(mail);
    }
}
