package johnny.demarlier.mareu.Model;


import android.os.Parcel;
import android.os.Parcelable;

public class Hours implements Parcelable {
    private int mHours;
    private int mMinutes;


    public Hours(int hours, int minutes) {
        this.mHours = hours;
        this.mMinutes = minutes;

    }

    protected Hours(Parcel in) {
        mHours = in.readInt();
        mMinutes = in.readInt();
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
        return mHours + ":" + mMinutes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
    }

    public boolean isGreater(Hours h) {
        boolean resultGreater = this.mHours > h.mHours || (this.mHours == h.mHours && (this.mMinutes >= h.mMinutes));
        return resultGreater;
    }

    public boolean isLower(Hours h) {
        boolean resultLower = this.mHours < h.mHours || (this.mHours == h.mHours && (this.mMinutes <= h.mMinutes));
        return resultLower;

    }

    public boolean isBetween(Hours start, Hours end) {
        return isGreater(start) && isLower(end);
    }

    public boolean isConflictWithMeetingHours(Meeting meeting) {
        return isBetween(meeting.getStartMeeting(), meeting.getStopMeeting());
    }

}
