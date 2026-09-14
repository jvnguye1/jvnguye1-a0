package com.example.cmput_301_assignment_0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.benchmark.traceprocessor.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cmput_301_assignment_0.ui.theme.CMPUT301Assignment0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerApp()
        }
    }
}


@Preview
@Composable
fun DiceRollerApp() {
    CMPUT301Assignment0Theme{
        Buttons()
    }
}

@Composable
fun Buttons(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    var result by remember{ mutableStateOf(false) }
    var clicks by remember {mutableStateOf(0) }
    var going by remember { mutableStateOf("Should we go?")}
    Column(modifier = modifier,
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)) {
        Text(
            text = going,
            fontSize = 24.sp,
            fontWeight = Bold
        )

        Row(
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Button(onClick = {result = CalculateGoing(2)
            if(result){
                going = "Yes"
            }else{
                going = "No"
            }
            clicks++}){
                Text(
                    text = "1/2",
                    )
            }

            Button(onClick = {result = CalculateGoing(4)
            if(result){
                going = "Yes"
            }else{
                going = "No"
            }
            clicks++}){
                Text(text = "1/4")
            }

            Button(onClick = {result = CalculateGoing(10)
            if(result){
                going = "Yes"
            }else{
                going = "No"
            }
            clicks++}){
                Text(text = "1/10")
            }
        }
        Text(
            text = "Clicks: " + clicks,
            fontSize = 20.sp
        )
        Text(
            text = "Student Number: 1855235, CCID: jvnguye1",
            fontSize = 20.sp
        )
    }
}

fun CalculateGoing(maxNum: Int): Boolean{
    val randomNum = (1..maxNum).random()

    return randomNum == 1
}