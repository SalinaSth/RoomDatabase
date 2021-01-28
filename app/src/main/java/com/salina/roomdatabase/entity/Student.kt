package com.salina.roomdatabase.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
        var fullname : String? = null,
        var age: Int? = null,
        var gender: String? = null,
        var address: String? = null
): Parcelable{
    @PrimaryKey(autoGenerate = true)
    var studentId : Int = 0

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString()
    ) {
        studentId = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullname)
        parcel.writeValue(age)
        parcel.writeString(gender)
        parcel.writeString(address)
        parcel.writeInt(studentId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}
