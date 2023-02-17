package su.pank.train23.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class RegDTO(
    var fullName: String = "",
    var userName: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
): Parcelable {
    fun checkPassword(): Boolean {
        return password == confirmPassword
    }


}
