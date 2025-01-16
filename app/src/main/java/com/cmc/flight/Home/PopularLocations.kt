package com.cmc.flight.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmc.flight.R

@Composable
fun PopularLocations() {
    val locations = listOf(
        Location("Eiffel Tower", "Paris Eyfel Kulesi", "2450 KMS", R.drawable.image3),
        Location("Beautiful China", "Shanghai, China", "2450 KMS", R.drawable.image4)
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(locations) { location ->
            LocationCard(
                title = location.title,
                subtitle = location.subtitle,
                distance = location.distance,
                imageRes = location.imageRes
            )
        }
    }
}

@Composable
fun LocationCard(title: String, subtitle: String, distance: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(210.dp)
            .height(290.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(186.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { /* Handle click */ },
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.li_bookmark_plus),
                            contentDescription = "Bookmark Icon",
                            tint = Color.Blue,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.li_map_pin),
                            contentDescription = "Bookmark Icon",
                            tint = Color.Blue,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = subtitle,
                        color = Color.DarkGray,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = distance,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )
                }
            }
        }
    }
}

data class Location(
    val title: String,
    val subtitle: String,
    val distance: String,
    val imageRes: Int
)
