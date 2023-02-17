package su.pank.train23.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import su.pank.train23.R
import su.pank.train23.models.Page
import su.pank.train23.ui.theme.poppins

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState()
        val pages = listOf(
            Page(
                R.drawable.first_page,
                "Get Paid! Playing Video Game",
                "Earn points and real cash when you win a battle with no delay in cashing out"
            ),
            Page(
                R.drawable.second_page,
                "Schedule Games With Friends",
                "Easily create an upcoming event and get ready for battle. Yeah! real combat fella."
            ),
            Page(
                R.drawable.third_page,
                "Text, Audio and Video Chat",
                "Intuitive real life experience on mobile. Chat with fellow gamers before and after combat for free!"
            )
        )
        Column(Modifier.fillMaxSize()) {
            HorizontalPager(count = pages.size, state = pagerState) { page ->
                val currentPage = pages[page]
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = currentPage.resourceId),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp, 50.dp, 0.dp, 0.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = currentPage.title,
                        fontFamily = poppins,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.width(230.dp),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W700
                    )
                    Text(
                        text = currentPage.description, fontFamily = poppins,
                        modifier = Modifier.width(230.dp),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                    )
                    val isLastPage = remember {
                        derivedStateOf { page == pages.size - 1 }
                    }
                    val scope = rememberCoroutineScope()
                    Column(
                        modifier = Modifier
                            .padding(0.dp, 0.dp, 0.dp, 32.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        if (!isLastPage.value) {
                            TextButton(onClick = {
                                scope.launch {

                                    pagerState.animateScrollToPage(pages.size - 1)


                                }
                            }) {
                                Text(
                                    text = "Skip",
                                    textDecoration = TextDecoration.Underline,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        } else {
                            Button(onClick = { navController.navigate("reg_screen") }) {
                                Text(text = "Let's Combat!")
                            }
                        }
                    }

                }
            }

        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(0.dp, 24.dp),
            activeColor = MaterialTheme.colorScheme.primary,

            )
    }
}