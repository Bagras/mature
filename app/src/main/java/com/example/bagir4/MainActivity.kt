package com.example.bagir4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var categoryText = mutableListOf<Category>(
        Category(
            "Все",
            1
        ),
        Category(
            "Outdoor",
            2
        ),
        Category(
            "Tennis",
            3
        ),
        Category(
            "Running",
            4
        )


    )
    var productList = mutableListOf<Product>(
        Product(
            R.drawable.nike_zoom,
            "Best Seller",
            "Nice Air Max",
            "752.00"
        ),
        Product(
            R.drawable.nike_zoom,
            "Best Seller",
            "Nike Air Max",
            "752.00"
        )
    )
    var searchField by remember { mutableStateOf("") }
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xfff7f7f9))
            .padding(horizontal = 20.dp)
    )
    {

        Spacer(Modifier.height(48.dp))
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.padding(end = 78.dp)) {
                Icon(
                    painter = painterResource(R.drawable.hamburger),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
            Box(Modifier.padding(bottom = 10.dp)) {
                Icon(
                    painter = painterResource(R.drawable.highlight_05),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Box(Modifier.padding(start = 10.dp, top = 5.dp)) {
                    Text("Главная", fontSize = 32.sp)

                }
            }
            Card(
                modifier
                    .padding(start = 62.dp)
                    .size(44.dp),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(R.drawable.bag_2),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }

        }

        Spacer(Modifier.height(21.dp))

        Row(Modifier.height(52.dp)) {

            TextField(
                value = searchField,
                onValueChange = {
                    searchField = it
                },
                modifier.width(269.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                ),
                shape = RoundedCornerShape(14.dp),
                label = {
                    Text("Поиск", fontSize = 12.sp, color = Color(0xff6a6a6a))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.vector),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                },

                )
            Spacer(Modifier.width(23.dp))
            Card(
                modifier.size(52.dp),
                colors = CardDefaults.cardColors(Color(0xff48b2e7)),
                shape = CircleShape
            ) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(R.drawable.sliders),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                }
            }

        }

        Spacer(Modifier.height(22.dp))

        Column(Modifier.fillMaxWidth()) {
            Text("Категории", fontSize = 16.sp)
            Spacer(Modifier.height(19.dp))
            LazyRow() {
                items(
                    categoryText
                ) {
                    CategoryItem(it)
                }
            }

        }

        Spacer(Modifier.height(24.dp))

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Популярное", fontSize = 16.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text("Все", color = Color(0xff48b2e7), fontSize = 12.sp)
            }


        }

        Spacer(Modifier.height(30.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .height(182.dp)
        ) {
            ProductItem(modifier = Modifier)
            Spacer(Modifier.width(15.dp))
            ProductItem(modifier = Modifier)
        }

        Spacer(Modifier.height(29.dp))

        Row(Modifier.fillMaxWidth()) {
            Text("Акции", fontSize = 16.sp)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Text("Все", color = Color(0xff48b2e7), fontSize = 12.sp)
            }

        }

        Spacer(Modifier.height(20.dp))

        Card(
            modifier
                .fillMaxWidth()
                .height(95.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Box(Modifier.fillMaxSize()) {
                Column(
                    Modifier
                        .padding(start = 22.dp, top = 20.dp)
                        .width(138.dp)
                        .height(55.dp)
                ) {
                    Text("Summer Sale", fontSize = 12.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "15% OFF", fontSize = 32.sp, color = Color(0xff674dc5),

                        )
                }
                Box(Modifier.fillMaxSize()) {
                    Box(Modifier
                        .fillMaxSize()
                        .padding(start = 192.dp, 3.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.nike_vector),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Box(Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp, top = 60.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.vector_2),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Box(Modifier
                        .fillMaxSize()
                        .padding(start = 130.dp, top = 4.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.vector_2),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Box(Modifier
                        .fillMaxSize()
                        .padding(start = 158.dp, top = 66.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.vector_2),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Box(Modifier
                        .fillMaxSize()
                        .padding(start = 310.dp, top = 15.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.vector_2),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Box(Modifier.fillMaxSize().padding(start = 176.dp, top = 12.dp)){
                        Icon(painter = painterResource(R.drawable.misc_06), contentDescription = null, tint = Color.Unspecified)
                    }
                }

            }
        }

        Spacer(Modifier.height(21.dp))

        Box(Modifier
            .fillMaxWidth()
            .height(106.dp)) {
            Card(
                colors = CardDefaults.cardColors(Color(0xff48b2e7))
            ) {

            }
        }
    }
}

data class Category(
    val name: String,
    val number: Int
)

data class Product(
    val photo: Int,
    val subtext: String,
    val name: String,
    val price: String
)

@Composable
fun CategoryItem(category: Category) {
    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .width(124.dp)
            .height(40.dp)
            .padding(end = 16.dp)
            .clickable {

            },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(category.name, fontSize = 12.sp)
        }

    }

}

@Composable
fun ProductItem(modifier: Modifier) {

    Card(
        modifier
            .height(182.dp)
            .width(160.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp)
    )
    {
        Column(Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .padding(horizontal = 9.dp)
            ) {
                Box() {
                    Box(
                        Modifier
                            .width(142.dp)
                            .height(88.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            Modifier
                                .width(142.dp)
                                .height(70.dp)
                                .padding(top = 9.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.nike_zoom),
                                contentDescription = null,
                                modifier
                                    .width(142.dp)
                                    .height(70.dp)
                            )

                        }
                    }
                    // Кард сердечка
                    Box(
                        Modifier
                            .padding(top = 9.dp)
                    ) {

                        Card(
                            modifier.size(28.dp),
                            shape = CircleShape
                        )
                        {
                            // Бокс сердечка
                            Box(
                                Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                //Иконка сердечка
                                Icon(
                                    painter = painterResource(R.drawable.path),
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                            }

                        }
                    }

                }
                Spacer(Modifier.height(12.dp))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                ) {
                    Box(
                        Modifier.height(16.dp)
                    ) {
                        Text("BEST SELLER", fontSize = 12.sp, color = Color(0xff48b2e7))
                    }

                    Spacer(Modifier.height(8.dp))
                    Box(Modifier.height(20.dp)) {
                        Text("Nike Air Pro", fontSize = 16.sp, color = Color(0xff6a6a6a))
                    }

                }

            }
            Spacer(Modifier.height(4.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(34.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.padding(start = 9.dp)) {
                    Text("752.00")
                }
                Spacer(Modifier.width(77.dp))
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(34.dp)
                ) {
                    Card(
                        shape = RoundedCornerShape(topStart = 16.dp),
                        colors = CardDefaults.cardColors(Color(0xff48b2e7))
                    ) {
                        Box(
                            Modifier
                                .height(34.dp)
                                .width(34.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.group_107),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                    }
                }

            }
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}