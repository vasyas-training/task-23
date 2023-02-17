package su.pank.train23.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import su.pank.train23.view.OnBoardingScreen
import su.pank.train23.view.Registration
import su.pank.train23.view.SplashScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen", modifier = Modifier.fillMaxSize()){
        composable("SplashScreen"){
            SplashScreen(navController)
        }
        composable("boarding_screen"){
            OnBoardingScreen(navController)
        }
        composable("reg_screen"){
            Registration(navController = navController)
        }
    }
}