package com.dand0129.stressenmethod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val stressenMethod2x2 = StressenMethod2x2()
        setContent {
            Home(StressenMethod2x2())
        }
    }
}

@Preview
@Composable
fun Home(
    stressenMethod2x2: StressenMethod2x2 = StressenMethod2x2()
) {

    val a11 = remember { mutableStateOf("") }
    val a12 = remember { mutableStateOf("") }
    val a21 = remember { mutableStateOf("") }
    val a22 = remember { mutableStateOf("") }
    val b11 = remember { mutableStateOf("") }
    val b12 = remember { mutableStateOf("") }
    val b21 = remember { mutableStateOf("") }
    val b22 = remember { mutableStateOf("") }
    val listOfCoefficients = remember { mutableStateOf(emptyList<Double>()) }
    val textResult = remember { mutableStateOf("") }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(39, 33, 53))
    ) {
        Text(
            text = "Stressen's Method \n Matrix Calculator",
            color = Color.White,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(top = 60.dp)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Row(
                modifier = Modifier
                    .width(300.dp)
                    .height(220.dp)
            ) {
                Column(
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Matrix A",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(213, 233, 233),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .height(130.dp)
                            .width(130.dp)
                    ) {
                        Spacer(modifier = Modifier.width(200.dp))
                        Box(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .height(105.dp)
                                .width(105.dp)
                        ) {
                            Matrix2X2(a11, a12, a21, a22)
                        }
                    }
                }
                Spacer(modifier = Modifier.width(40.dp))
                Column {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Matrix B",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(247, 244, 186),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .height(130.dp)
                            .width(130.dp)
                    ) {
                        Spacer(modifier = Modifier.width(200.dp))
                        Box(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .height(105.dp)
                                .width(105.dp)
                        ) {
                            Matrix2X2(b11, b12, b21, b22)
                        }
                    }
                }
            }
            Box(
                modifier = Modifier.padding(horizontal = 65.dp)
            ) {
                Text(
                    text = textResult.value
                )
            }
            Row(
                modifier = Modifier.width(300.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(modifier = Modifier.align(Alignment.Center)) {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(234,234,234),
                                contentColor = Color.Black
                            ),
                            onClick = {
                            listOfCoefficients.value = listOf<Double>(
                                a11.value.toDouble(),
                                a12.value.toDouble(),
                                a21.value.toDouble(),
                                a22.value.toDouble(),
                                b11.value.toDouble(),
                                b12.value.toDouble(),
                                b21.value.toDouble(),
                                b22.value.toDouble()
                            )
                            val result =
                                stressenMethod2x2.stressenMethod2x2(listOfCoefficients.value)
                            val stringBuilder = StringBuilder()
                            stringBuilder.append("El resultado es:\n")
                            for (i in result.indices) {
                                for (j in result[i].indices) {
                                    stringBuilder.append("${result[i][j]} ")
                                }
                                stringBuilder.append("\n")
                            }
                            textResult.value = stringBuilder.toString()
                        }) {
                            Text(text = "Calculate")
                        }
                    }
                }
            }
        }
    }
}




@Composable
fun Matrix2X2(
    t11: MutableState<String>,
    t12: MutableState<String>,
    t21: MutableState<String>,
    t22: MutableState<String>,
) {

        Box(
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)

        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Coefficient(title = "a11", initialValue = t11)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Coefficient(title = "a12", initialValue = t12)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Coefficient(title = "a21", initialValue = t21)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Coefficient(title = "a22", initialValue = t22)
            }
        }

}


@Composable
fun Coefficient(
    title: String = "title",
    initialValue: MutableState<String>
) {
    val coefficientValue = remember { mutableStateOf(initialValue.value.toString()) }
    TextField(
        modifier = Modifier
            .height(50.dp)
            .width(50.dp),
        value = coefficientValue.value,
        onValueChange = {
            coefficientValue.value = it
            initialValue.value = it
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}

