package johnny.demarlier.mareu.Model;


import android.os.Parcel;
import android.os.Parcelable;

public class Hours implements Parcelable {
    private int hours;
    private int minutes;


    public Hours(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;

    }

    protected Hours(Parcel in) {
        hours = in.readInt();
        minutes = in.readInt();
    }

    public static final Creator<Hours> CREATOR = new Creator<Hours>() {
        @Override
        public Hours createFromParcel(Parcel in) {
            return new Hours(in);
        }

        @Override
        public Hours[] newArray(int size) {
            return new Hours[size];
        }
    };

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hours);
        dest.writeInt(minutes);
    }

    public boolean isGreater(Hours h) {
        boolean result = this.hours > h.hours || (this.hours == h.hours && (this.minutes >= h.minutes));
        return result;
    }

    public boolean isLower(Hours h) {
        boolean results = this.hours < h.hours || (this.hours == h.hours && (this.minutes <= h.minutes));
        return results;

    }

    public boolean isBetween(Hours start, Hours end) {
        return isGreater(start) && isLower(end);
    }

    public boolean isConflictWithMeetingHours(Meeting meeting) {
        return isBetween(meeting.getStartMeeting(), meeting.getStopMeeting());
    }

}
