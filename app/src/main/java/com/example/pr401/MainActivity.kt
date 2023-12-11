package com.example.pr401

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pr401.ui.theme.Brown80
import com.example.pr401.ui.theme.Cream80
import com.example.pr401.ui.theme.LightBrown80
import com.example.pr401.ui.theme.PR401Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PR401Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    main()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun main(modifier: Modifier = Modifier) {
    // Caja que contiene toda la pantalla
    Box(
        modifier = modifier
            .background(color = Cream80)
            .fillMaxSize(),
    ) {
        Column {
            // Primer apartado
            Box(
                modifier = modifier
                    .background(color = Brown80)
                    .fillMaxWidth()
                    .height(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Imagen del logo
                    Image(
                        painter = painterResource(id = R.drawable.pmdm),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(100.dp)
                            .padding(5.dp)
                    )
                    // Texto con el código del proyecto
                    Text(
                        text = "PR401 - Cuaderno Profesor",
                        fontSize = 22.sp,
                        style = MaterialTheme.typography.titleLarge.copy(
                            shadow = Shadow(
                                offset = Offset(10f, 10f),
                                blurRadius = 10f,
                                color = Color.Black.copy(alpha = 0.3f)
                            )
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            } // Termina primer apartado

            // Segundo apartado
            Box(
                modifier = Modifier
                    .padding(top = 9.dp, bottom = 9.dp, start = 9.dp, end = 9.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = LightBrown80)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ) {

                }
        }

        }
    }
}
