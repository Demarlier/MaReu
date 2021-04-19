package johnny.demarlier.mareu.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Hours implements Parcelable {
    private String mModelHours;

    public String getModelHours(){return mModelHours;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hours hours = (Hours) o;
        return mModelHours.equals(hours.mModelHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mModelHours);
    }

    public Hours(String modelHours){
        mModelHours = modelHours;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mModelHours);
    }
    protected Hours(Parcel in) {
        mModelHours = in.readString();
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
}
