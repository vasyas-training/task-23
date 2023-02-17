package su.pank.train23.viewmodel

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegViewModel: ViewModel() {
    var fullName by mutableStateOf("")
    var userName by mutableStateOf("")
    var phone by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    val isPaswordCorrect by derivedStateOf { password == confirmPassword }

    fun reg(){

    }
}