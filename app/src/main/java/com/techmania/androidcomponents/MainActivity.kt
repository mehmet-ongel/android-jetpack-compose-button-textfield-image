package com.techmania.androidcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techmania.androidcomponents.ui.theme.AndroidComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Components()
                }
            }
        }
    }
}

@Composable
fun Components() {

    val myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }
    val myButtonText = remember {
        mutableStateOf("Do Your Magic")
    }
    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }
    val myText = remember {
        mutableStateOf("Hello World")
    }
    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }
    val buttonStatus = remember {
        mutableStateOf(true)
    }
    val valueOnTextField = remember {
        mutableStateOf("")
    }
    val userInput = remember {
        mutableStateOf("Result:")
    }
    val myImage = remember {
        mutableStateOf(R.drawable.first_image)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = myImage.value),
            contentDescription = "",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center)

        Spacer(modifier = Modifier.size(30.dp))

        if (buttonStatus.value) {
            Text(
                text = myText.value,
                color = myTextColor.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(10.dp)
            )
        }


        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = {

                if (buttonStatus.value) {

                    myText.value = "Hello Compose"
                    myTextColor.value = Color.White

                    myButtonBackgroundColor.value = Color.Black
                    myButtonText.value = "Compose is Fun"
                    myButtonTextColor.value = Color.Red

                    myImage.value = R.drawable.second_image

                    buttonStatus.value = false

                } else {
                    myText.value = "Hello World"
                    myTextColor.value = Color.Black

                    myButtonBackgroundColor.value = Color.Red
                    myButtonText.value = "Do your Magic"
                    myButtonTextColor.value = Color.White

                    myImage.value = R.drawable.first_image

                    buttonStatus.value = true
                }

                userInput.value = valueOnTextField.value
                valueOnTextField.value = ""


            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = myButtonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {

            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

        }

        Spacer(modifier = Modifier.size(30.dp))

        TextField(
            value = valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it
            },
            label = { Text(text = "Enter your name")},
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                backgroundColor = Color.Blue,
                focusedLabelColor = Color.Yellow,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.Red,
                focusedIndicatorColor = Color.Green
            ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            maxLines = 4,
            //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            //visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = userInput.value,
            color = myTextColor.value,
            fontSize = 24.sp,
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComponentsTheme {
        Components()
    }
}