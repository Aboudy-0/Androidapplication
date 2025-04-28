package com.starglen.zawadimart.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.navigation.ROUT_LOGIN
import com.starglen.zawadimart.R
import com.starglen.zawadimart.ui.theme.neworange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {
    // Animation states
    val scale = remember { Animatable(0.8f) }
    val alpha = remember { Animatable(0f) }

    // Launch animations when composable is first composed
    LaunchedEffect(Unit) {
        // Start animations in parallel
        launch {
            scale.animateTo(
                targetValue = 1.1f,
                animationSpec = tween(durationMillis = 800)
            )
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 300)
            )
        }
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000)
        )

        // Wait for 2 seconds total (animations take ~1.1s)
        delay(2000)
        navController.navigate(ROUT_LOGIN) {
            // Clear back stack so user can't go back to splash screen
            popUpTo(0)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = neworange),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.img_1),
            contentDescription = "App Logo",
            modifier = Modifier
                .scale(scale.value)
                .alpha(alpha.value)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}