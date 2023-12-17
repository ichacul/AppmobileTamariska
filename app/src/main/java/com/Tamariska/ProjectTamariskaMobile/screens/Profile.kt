package com.Tamariska.ProjectTamariskaMobile.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.Tamariska.ProjectTamariskaMobile.ListModal
import com.Tamariska.ProjectTamariskaMobile.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun Profile(navController: NavHostController) {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFFF7FFE5), Color(0xFFCEDEBD)),
        startY = 0f,
        endY = 1000f
    )
    //Box composable to center Items
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF262B26))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profil",
                tint = Color(0xFFF7FFE5),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
            )
            Text(
                text = "Profil",
                color = Color(0xFFF7FFE5),
                fontSize = 20.sp,
                fontFamily = FontFamily.Default
            )
        }
        //A Column composable
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            displayListView() }
    }
}

fun getJSONData(courseList: MutableList<String>, ctx: Context) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.npoint.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
    val call: Call<ArrayList<ListModal>> = retrofitAPI.getLanguages()
    call!!.enqueue(object : Callback<ArrayList<ListModal>?> {
        override fun onResponse(
            call: Call<ArrayList<ListModal>?>,
            response: Response<ArrayList<ListModal>?>
        ) {
            if (response.isSuccessful) {
                var lst: ArrayList<ListModal> = ArrayList()
                lst = response.body()!!
                for (i in 0 until lst.size) {
                    courseList.add(lst.get(i).languageName)
                }
            }
        }

        override fun onFailure(call: Call<ArrayList<ListModal>?>, t: Throwable) {
            Toast.makeText(ctx, "Fail to get the data..", Toast.LENGTH_SHORT)
                .show()
            Log.d("ERROR", t.toString());
        }
    })
}

@Composable
fun displayListView() {
    val context = LocalContext.current
    val courseList = remember { mutableStateListOf<String>() }
    getJSONData(courseList, context)
    LazyColumn {
        items(courseList) { language ->
            Text(language, modifier = Modifier.padding(15.dp))
            Divider()
        }
    }
}