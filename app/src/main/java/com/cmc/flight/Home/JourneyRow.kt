package com.cmc.flight.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cmc.flight.R

@Composable
fun JourneyRow() {
    val journeys = listOf(
        Journey("Shimla Best Kept Secret", R.drawable.image1),
        Journey("Charming Kasol Vibes", R.drawable.image2)
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(journeys) { journey ->
            JourneyCard(title = journey.title, imageRes = journey.imageRes)
        }
    }
}


@Composable
fun JourneyCard(title: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(206.dp)
            .height(139.dp)
    ) {
        Box(modifier = Modifier.background(Color.LightGray)) {
            Image(
                painter = painterResource(imageRes),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
    }
}

data class Journey(val title: String, val imageRes: Int)