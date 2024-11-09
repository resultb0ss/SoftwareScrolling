package com.example.softwarescrolling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwarescrolling.ui.theme.SoftwareScrollingTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()

            val groups = EmployersDataBase.employees.groupBy { it.employee }
            LazyColumn (state = listState, modifier = Modifier.padding(top = 75.dp)) {
                item {
                    Text(text = "В конец списка",
                        Modifier
                            .padding(8.dp)
                            .background(Color.DarkGray)
                            .padding(6.dp)
                            .clickable {

                                coroutineScope.launch {
                                    listState.animateScrollToItem(35)
                                }
                            }, fontSize = 28.sp, color = Color.White
                    )

                }

                groups.forEach{ (employee, name)  ->
                    stickyHeader {
                        Text(text = employee.employee,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier
                                .background(Color.Magenta)
                                .padding(6.dp)
                                .fillParentMaxWidth()
                        )
                    }
                    items(name) {
                        person -> 
                        Text(text = person.name + " " + person.lastName,
                            Modifier.padding(6.dp), fontSize = 32.sp)
                    }
                }



                item {
                    Text(text = "В начало списка",
                        Modifier
                            .padding(8.dp)
                            .background(Color.DarkGray)
                            .padding(6.dp)
                            .clickable {

                                coroutineScope.launch {
                                    listState.animateScrollToItem(0)
                                }
                            }, fontSize = 28.sp, color = Color.White
                    )
                }
            }
        }
    }
}


