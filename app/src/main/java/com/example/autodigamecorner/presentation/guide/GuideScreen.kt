package com.example.autodigamecorner.presentation.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideScreen(modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val imgHeight = screenWidth * 256 / 383

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Petunjuk Penggunaan",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Box(modifier = Modifier.background(Color(0xff2563EB))) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .background(Color.Gray)
                        .fillMaxWidth()
                        .height(imgHeight.dp)
                ) {
                    //IMG HERE
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 21.dp),
                text = "Tata Cara Peminjaman Perangkat Game Corner",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff2563EB)
            )

            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .padding(horizontal = 21.dp),
                text = "DO SOMETHING",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun PrevGuideScreen(modifier: Modifier = Modifier) {
    GuideScreen()
}