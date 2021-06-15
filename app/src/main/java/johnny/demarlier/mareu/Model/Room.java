package johnny.demarlier.mareu.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Room implements Parcelable {
    private String mModelRoom;

    public String getModelRoom() {
        return mModelRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return mModelRoom.equals(room.mModelRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mModelRoom);
    }

    public Room(String modelRoom) {
        mModelRoom = modelRoom;

    }

    protected Room(Parcel in) {
        mModelRoom = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mModelRoom);
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
