package com.example.codelab_explisitintent

import android.os.Parcel
import android.os.Parcelable

data class Pegawai(
    val NIP: Int,
    val Nama: String?,
    val Dept: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(NIP)
        parcel.writeString(Nama)
        parcel.writeString(Dept)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pegawai> {
        override fun createFromParcel(parcel: Parcel): Pegawai {
            return Pegawai(parcel)
        }

        override fun newArray(size: Int): Array<Pegawai?> {
            return arrayOfNulls(size)
        }
    }
}
