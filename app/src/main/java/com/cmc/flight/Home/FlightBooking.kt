package com.cmc.flight.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmc.flight.R

@Composable
fun FlightBooking() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Book your Flight",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        TabRow()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "From",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = remember { mutableStateOf(TextFieldValue("")) }.value,
            onValueChange = {},
            label = { Text("Choose Departure from") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        IconButton(
            onClick = {},
            modifier = Modifier
                .size(56.dp)
                .background(Color(0xFF7C4DFF), AbsoluteRoundedCornerShape(50.dp))
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(R.drawable.up_down_arrow),
                modifier = Modifier.size(30.dp),
                contentDescription = "Filter Icon",
                tint = Color.White,
            )
        }

        Text(
            text = "To",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = remember { mutableStateOf(TextFieldValue("")) }.value,
            onValueChange = {},
            label = { Text("Choose Arrival at") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Depature Date",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = remember { mutableStateOf(TextFieldValue("")) }.value,
                onValueChange = {},
                label = { Text("Choose your Date") },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(56.dp)
                    .background(Color(0xFF7C4DFF), AbsoluteRoundedCornerShape(15.dp))
            ) {
                Icon(
                    painter = painterResource(R.drawable.primary),
                    modifier = Modifier.size(30.dp),
                    contentDescription = "Filter Icon",
                    tint = Color.White,
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Counter(label = "Adult (12+)")
            Counter(label = "Childs (2-12)")
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(2.dp, Color(0xFF5E5CE6)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Search Flight", color = Color(0xFF5E5CE6))
        }
    }
}

@Composable
fun TabRow() {
    val selectedTabIndex = remember { mutableStateOf(0) }

    Surface(
        shape = RoundedCornerShape(50.dp),
        color = Color(0xFFF3F4F6),
        modifier = Modifier.fillMaxWidth()
    ) {
        androidx.compose.material3.TabRow(
            selectedTabIndex = selectedTabIndex.value,
            containerColor = Color.Transparent,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
                    color = Color(0xFF5E5CE6)
                )
            }
        ) {
            val tabs = listOf("One Way", "Round Trip", "Multicity")
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    onClick = { selectedTabIndex.value = index },
                    text = {
                        Text(
                            text = title,
                            color = if (selectedTabIndex.value == index) Color.White else Color.Gray,
                            fontWeight = if (selectedTabIndex.value == index) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    modifier = Modifier
                        .background(
                            if (selectedTabIndex.value == index) Color(0xFF5E5CE6) else Color.Transparent
                        )
                )
            }
        }
    }
}

@Composable
fun Counter(label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 16.dp)) {
        Text(text = label, fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { }, modifier = Modifier
                .size(25.dp)
                .background(Color(0xFFE9EAEC),
                    AbsoluteRoundedCornerShape(15.dp)) )
            {
                Icon(Icons.Default.Add, contentDescription = "Add",
                    tint = Color.Black)
            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .border(BorderStroke(1.dp, Color(0xFFE9EAEC)),
                        shape = (RoundedCornerShape(8.dp)))
            ) {
                Text(
                    text = "00",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            IconButton(onClick = { }, modifier = Modifier.padding(2.dp)
                .size(35.dp)
                .background(Color(0xFF7C4DFF),
                    AbsoluteRoundedCornerShape(15.dp)) )
            {
                Icon(Icons.Default.Add, contentDescription = "Add",
                    modifier = Modifier.padding(2.dp)
                        .size(25.dp),
                    tint = Color.White)
            }
        }
    }
}
