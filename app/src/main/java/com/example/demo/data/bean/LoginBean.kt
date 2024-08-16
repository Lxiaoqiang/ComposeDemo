package com.example.demo.data.bean

import android.os.Parcel
import android.os.Parcelable


data class LoginBean(
    val userName: String? = null,
    val userPassword: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeString(userPassword)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginBean> {
        override fun createFromParcel(parcel: Parcel): LoginBean {
            return LoginBean(parcel)
        }

        override fun newArray(size: Int): Array<LoginBean?> {
            return arrayOfNulls(size)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is LoginBean) {
            return false
        }
        if (userName.isNullOrEmpty() || userPassword.isNullOrEmpty()) {
            return false
        }

        return other.userPassword == userPassword && other.userName == userName
    }
}
