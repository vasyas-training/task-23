package su.pank.train23.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import su.pank.train23.R

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(null) {
        delay(3000)
        navController.navigate("boarding_screen") {
            popUpTo("SplashScreen") {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(Color(255, 100, 128), Color(242, 46, 99))))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(100.dp, 100.dp)
            )
            Text(
                text = "GAAMETIIME",

                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(text = "CONNECT WITH YOUR REALITY", color = Color.White)
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.graphics),
                contentDescription = null,
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}