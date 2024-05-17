@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.baitapbuoi5_thanghtph31577

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baitapbuoi5_thanghtph31577.ui.theme.BaiTapBuoi5_thanghtph31577Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaiTapBuoi5_thanghtph31577Theme {

                ScaffoldExample()
            }
        }
    }
}
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF262121),
                    titleContentColor = Color(0xFFffffff),
                ),
                title = {

                    Text("Thanh toán")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },


    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(innerPadding)
                .background(Color(0xFF262121)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Divider(color = Color.Black, thickness = 1.dp)

            Text(
                modifier = Modifier.padding(start =  28.dp),
                text ="Địa chỉ nhận hàng",
                color = Color.White
            )
            Row {
                Icon(
                    modifier = Modifier.padding(20.dp),
                    tint = Color.White,
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = stringResource(id = R.string.bus_content_description)
                )
                Column(
                        modifier = Modifier
                            .background(Color(0xFF262121)),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Text(
                        text ="Thăng |222222222",
                        color = Color.White
                    )
                    Text(
                        text ="1999 Ngõ 3333, tổ 8 Đa Sỹ, Kiến Hưng , Hà Đông, Hà Nội",
                        color = Color.White
                    )


            }


            }
            Text(
                modifier = Modifier.padding(start = 28 .dp),
                text ="Vui lòng chọn 1 trong các phương thức sau",
                color = Color.White
            )
            val paypal = painterResource(id = R.drawable.paypal)
            val visa = painterResource(id = R.drawable.visa)
            val momo = painterResource(id = R.drawable.momo)
            val zalo = painterResource(id = R.drawable.zalopay)
            val trucTiep = painterResource(id = R.drawable.tructiep)



            RowChoose("paypal","Option 1", paypal,Color(0xFFFA8500))
            RowChoose("visa","Option 2", visa, Color.Green)
            RowChoose("momo","Option 3", momo, Color(0xFFE71384))
            RowChoose("ZaloPay","Option 4", zalo, Color(0xFF01ADE2))
            RowChoose("Trực tiếp","Option 5", trucTiep, Color(0xFF1BD7D6))




            Button(
                onClick = { /* Your click logic */ },
                modifier = Modifier
                    .padding(start = 28.dp, end = 28.dp)
                    .background(Color(0xFFFE724C), shape = RoundedCornerShape(16.dp))
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD724C)
                )
            ) {
                Text("Tiếp theo")
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun RowChoose(text: String, option:String,painter: Painter, color: Color ){
    var selectedOption by remember { mutableStateOf("") }

    Row(modifier = Modifier
        .padding(start = 28.dp, end = 28.dp)
        .background(
            color,
            shape = RoundedCornerShape(16.dp)
        )
        .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
) {
    Image(
        painter = painter,
        modifier = Modifier.padding(10.dp),
        contentDescription = stringResource(id = R.string.paypal)
    )
    Text(
        text = text,
        color = Color(0xFFFFFFFF)
    )
    RadioButton(
        selected = selectedOption == option,
        onClick = { selectedOption = option}
    )
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaiTapBuoi5_thanghtph31577Theme {
        ScaffoldExample()
    }
}