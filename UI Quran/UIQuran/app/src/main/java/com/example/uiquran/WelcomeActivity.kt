package com.example.uiquran

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen(
                backgroundColor = Color.White, // Contoh penggunaan parameter warna
                textColor = Color.Black // Contoh penggunaan parameter warna teks
            ) {
                startActivity(Intent(this,WelcomeActivity::class.java)) // Perbaikan: Pindah ke MainActivity, bukan ke WelcomeActivity sendiri
                finish()
            }
        }
    }
}

@Composable
fun WelcomeScreen(
    backgroundColor: Color = Color(0xD9F6FF), // Warna latar belakang bisa diubah
    textColor: Color = Color.Black, // Warna teks bisa diubah
    onGetStarted: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MyQuran",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
            Text(
                text = "Light for the Heart,\nGuidance for Life",
                fontSize = 13.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.foto_ngaji),
                contentDescription = "Welcome Image",
                modifier = Modifier
                    .width(358.dp)
                    .height(472.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp))
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onGetStarted,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81D4FA)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Get Started", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onGetStarted = {})
}
