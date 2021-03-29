package johnny.demarlier.mareu.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Room implements Parcelable {
    private String mName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return mName.equals(room.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName);
    }

    public Room(String name) {
        mName = name;

    }

    protected Room(Parcel in) {
        mName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Room> CREATOR = new Creator<Room>() {
        @Override
        public Room createFromParcel(Parcel in) {
            return new Room(in);
        }

        @Override
        public Room[] newArray(int size) {
            return new Room[size];
        }
    };
}
