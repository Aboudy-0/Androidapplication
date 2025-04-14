package com.starglen.zawadimart.ui.screens.form1

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.navigation.ROUT_ABOUT
import com.navigation.ROUT_DASHBOARD
import com.navigation.ROUT_HOME
import com.starglen.zawadimart.ui.theme.newblue
import com.starglen.zawadimart.ui.theme.newgrey
import com.starglen.zawadimart.ui.theme.newlightblue
import com.starglen.zawadimart.ui.theme.neworange
import com.starglen.zawadimart.ui.theme.newwhite

@Composable
fun Form1Screen(navController: NavController){

    Column(modifier = Modifier.fillMaxSize().background(color = newblue),
        horizontalAlignment = Alignment.CenterHorizontally) {


        //Variables
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(30.dp))

        //Row
        Row (modifier = Modifier.padding(start = 20.dp)){


                    Image(
                        painter = painterResource(com.starglen.zawadimart.R.drawable.img_8),
                        contentDescription = "bag",
                        modifier = Modifier.size(30.dp)

                    )

            Text(text = "Logo App",
                fontSize = 25.sp,
                color = Color.White)

        }

        //End of Row

        Spacer(modifier = Modifier.height(30.dp))


        Image(
            painter = painterResource(com.starglen.zawadimart.R.drawable.img_7),
            contentDescription = "Shopping-cart",
            contentScale = ContentScale.FillWidth
        )

        Box{


            //Card
            Card(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top = 200.dp),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 10.dp, bottomEnd = 10.dp),
                colors = CardDefaults.cardColors(newwhite),


            ) {
                Spacer(modifier = Modifier.height(30.dp))

                Column() {
                   Text(
                       text = "The Most Worth",
                       fontSize = 30.sp,
                       color = neworange,
                       fontWeight = FontWeight.ExtraBold,
                       modifier = Modifier.padding(start = 80.dp)
                   )
                   Text(text = "Grocery App",
                       modifier = Modifier.padding(start = 100.dp),
                       fontSize = 30.sp,
                       color = neworange,
                       fontWeight = FontWeight.ExtraBold
                       )

                    Spacer(modifier = Modifier.height(30.dp))

                    //Username
                    OutlinedTextField(
                        value = username,
                        onValueChange = {username = it},
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        label = {Text(text = "Username")},
                        shape = RoundedCornerShape(30.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)



                    )
                    //End

                    Spacer(modifier = Modifier.height(15.dp))

                    //Password
                    OutlinedTextField(
                        value = password,
                        onValueChange = {password = it},
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        label = {Text(text = "Password")},
                        shape = RoundedCornerShape(30.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation()

                    )
                    //End

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            navController.navigate(ROUT_DASHBOARD)
                        },
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(neworange),
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp).size(height = 60.dp, width = 20.dp)
                    )
                    {
                        Text(text = "Sign up",
                            fontSize = 20.sp)
                    }

               }



            }
            //End of Card



        }

    }
    //End of Box



}




@Preview(showBackground = true)
@Composable
fun Form1ScreenPreview(){
    Form1Screen(rememberNavController())
}