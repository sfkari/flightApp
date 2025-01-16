package com.cmc.flight.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.tooling.preview.Preview
import com.cmc.flight.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@Composable
fun TopBar() {
    val insets = WindowInsets.systemBars.asPaddingValues()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .padding(insets),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_menu_24),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )

        Image(
            painter = painterResource(R.drawable.notification),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    val insets = WindowInsets.systemBars.asPaddingValues()
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 30.dp, end = 20.dp)
            .padding(insets),
        contentAlignment = Alignment.TopStart
    ) {
        Column(modifier = Modifier
            .padding(vertical = 30.dp)
            .verticalScroll(scrollState)) {
            Text(text = "Good Morning, Shreya....")
            Text(
                text = "Make plan for weekend",
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )

            Spacer(modifier = Modifier.height(16.dp))

            SearchPlaces()

            Spacer(modifier = Modifier.height(16.dp))

            TransportOptionsScreen()

            Spacer(modifier = Modifier.height(16.dp))

            FlightBooking()

            Spacer(modifier = Modifier.height(16.dp))

            TravelApp()

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf(
        Pair("Home", R.drawable.li_home),
        Pair("Gifts", R.drawable.li_briefcase),
        Pair("Bookmarks", R.drawable.li_bookmark),
        Pair("Profile", R.drawable.li_user)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, item ->
            Column(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        if (index == selectedItem) Color(0xFF7C4DFF) else Color.Transparent,
                        shape = AbsoluteRoundedCornerShape(15.dp)
                    )
                    .clickable { selectedItem = index },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = item.second),
                    contentDescription = null,
                    tint = if (index == selectedItem) Color.White else Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Screen() {
    Scaffold(
        topBar = { TopBar() },
        content = {
            Content(modifier = Modifier.padding(16.dp))
        },
        bottomBar = { BottomNavigationBar() }
    )
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Screen()
}
