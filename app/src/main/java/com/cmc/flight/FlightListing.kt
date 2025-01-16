import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmc.flight.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview(showBackground = true)
@Composable
fun FlightListing() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                HeaderSection()
                FlightList()
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF6200EE))
            .padding(16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(top = 20.dp)) {
            IconButton(onClick = { }, modifier = Modifier.size(45.dp).fillMaxWidth()) {
                Icon(
                    Icons.Default.KeyboardArrowLeft, contentDescription = "back",
                    modifier = Modifier.padding(2.dp).size(35.dp),
                    tint = Color.White
                )
            }

            IconButton(onClick = { }, modifier = Modifier.size(45.dp)) {
                Icon(
                    painter = painterResource(R.drawable.li_edit),
                    contentDescription = "back",
                    modifier = Modifier.padding(2.dp).size(25.dp),
                    tint = Color.White
                )
            }
        }
        Text(
            text = "20 December 2022",
            color = Color.White,
            fontWeight = Bold,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("DEL", color = Color.White, fontWeight = Bold, fontSize = 28.sp, modifier = Modifier.align(Alignment.Start))
                Text("Delhi International Airport", color = Color.White, fontSize = 10.sp)
            }
            Image(
                painter = painterResource(R.drawable.flight),
                contentDescription = null,
                modifier = Modifier.size(130.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("BLR", color = Color.White, fontWeight = Bold, fontSize = 28.sp, modifier = Modifier.align(Alignment.End))
                Text("Bengaluru Airport", color = Color.White, fontSize = 10.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "04h 30m",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = Bold
            )
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.user),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "Filter Icon",
                        tint = Color.White
                    )
                }
                Text(
                    text = "01 Adult",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    Filter()
}

@Composable
fun Filter() {
    val buttonColor = Color(0xFF5E5CE6)
    val iconBackgroundColor = Color(0xFF7C4DFF)
    val buttonHeight = 50.dp
    val buttonShape = RoundedCornerShape(12.dp)
    val iconSize = 30.dp

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .weight(1f)
                .height(buttonHeight),
            border = BorderStroke(2.dp, buttonColor),
            shape = buttonShape
        ) {
            Text(text = "Low to High", fontSize = 10.sp, color = buttonColor)
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .weight(1f)
                .height(buttonHeight),
            border = BorderStroke(2.dp, buttonColor),
            shape = buttonShape
        ) {
            Text(text = "High to Low", color = buttonColor)
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .weight(1f)
                .height(buttonHeight),
            border = BorderStroke(2.dp, buttonColor),
            shape = buttonShape
        ) {
            Text(text = "Airlines Type", color = buttonColor)
        }
        IconButton(
            onClick = { },
            modifier = Modifier
                .size(iconSize)
                .align(Alignment.CenterVertically)
                .background(iconBackgroundColor, AbsoluteRoundedCornerShape(15.dp))
        ) {
            Icon(
                painter = painterResource(R.drawable.filter),
                modifier = Modifier.size(20.dp),
                contentDescription = "Filter Icon",
                tint = Color.White
            )
        }
    }
}

@Composable
fun FlightList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(6) { index ->
            FlightItem()
        }
    }
}

@Composable
fun FlightItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text("DEL", fontSize = 18.sp, fontWeight = Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("06:30", fontSize = 16.sp, fontWeight = Bold)
                }
                Text("02h 25m", color = Color(0xFF5E5CE6), fontSize = 18.sp, fontWeight = Bold)
                Column(horizontalAlignment = Alignment.End) {
                    Text("BLR", fontSize = 18.sp, fontWeight = Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("10:45", fontSize = 16.sp, fontWeight = Bold)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.tag),
                            contentDescription = "tag",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Text("7,319", fontWeight = Bold, fontSize = 18.sp)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Free Meal", color = Color.LightGray, fontSize = 14.sp)
            Text("Use Code : Flyaway60 and get 60% instant cashback", color = Color.Green, fontSize = 11.sp, modifier = Modifier.align(Alignment.End))
        }
    }
}
