package su.pank.train23.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import su.pank.train23.R
import su.pank.train23.viewmodel.RegViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(navController: NavHostController) {
    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.reg_image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(text = "Create Account", style = MaterialTheme.typography.titleLarge)
        Text(
            "Hi, kindly fill in the form to proceed combat",
            textAlign = TextAlign.Center,
            softWrap = true
        )
        val viewModel = viewModel(modelClass = RegViewModel::class.java)

        TextField(
            value = viewModel.fullName,
            onValueChange = { text -> viewModel.fullName = text },
            placeholder = {
                Text(
                    text = "Full name"
                )
            },
        )
        TextField(
            value = viewModel.userName,
            onValueChange = { text -> viewModel.userName = text },
            placeholder = {
                Text(
                    text = "User name"
                )
            },
            )

        TextField(
            value = viewModel.phone,
            onValueChange = { text -> viewModel.phone = text },
            placeholder = {
                Text(
                    text = "Your phone"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        TextField(
            value = viewModel.email,
            onValueChange = { text -> viewModel.email = text },
            placeholder = {
                Text(
                    text = "Email"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        TextField(
            value = viewModel.password,
            onValueChange = { text -> viewModel.password = text },
            placeholder = {
                Text(
                    text = "Password"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = !viewModel.isPaswordCorrect,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        TextField(
            value = viewModel.confirmPassword,
            onValueChange = { text -> viewModel.confirmPassword = text },
            placeholder = {
                Text(
                    text = "Confirm Password"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = !viewModel.isPaswordCorrect,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Create Account")
        }
        Text(text = "Connect With", textAlign = TextAlign.Center)
        Row(horizontalArrangement = Arrangement.Center) {
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "google plus"
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook_ic),
                    contentDescription = "facebook"
                )
            }
        }
    }
}