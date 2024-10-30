package com.ralphmarondev.cowgpt.features.home.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.cowgpt.R
import com.ralphmarondev.cowgpt.features.home.presentation.components.BotMessageCard
import com.ralphmarondev.cowgpt.features.home.presentation.components.UserMessageCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val messagesList by viewModel.messagesList.collectAsState()
    val message by viewModel.message.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.cow),
                        contentDescription = "",
                        modifier = Modifier
                            .size(38.dp),
                        contentScale = ContentScale.Crop
                    )
                },
                actions = {
                    TextButton(onClick = {}) {
                        Text(
                            text = "New chat",
                            fontFamily = FontFamily.Monospace,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Outlined.AddBox,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            data class BottomBars(
                val icon: ImageVector,
                val label: String
            )

            val listOfIcons = listOf(
                BottomBars(
                    icon = Icons.Outlined.Home,
                    label = "Home"
                ),
                BottomBars(
                    icon = Icons.Outlined.History,
                    label = "History"
                ),
                BottomBars(
                    icon = Icons.Outlined.AccountCircle,
                    label = "Profile"
                )
            )

            Column {
                OutlinedTextField(
                    value = message,
                    onValueChange = { viewModel.onMessageValueChanged(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    maxLines = 3,
                    placeholder = {
                        Text(
                            text = "Send a message",
                            fontFamily = FontFamily.Monospace,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                if (message.isNotBlank()) {
                                    viewModel.sendMessage("User")
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Outlined.Send,
                                contentDescription = ""
                            )
                        }
                    },
                    textStyle = TextStyle(
                        fontFamily = FontFamily.Monospace
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                NavigationBar {
                    listOfIcons.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = index == 0,
                            onClick = {},
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label
                                )
                            },
                            label = {
                                Text(
                                    text = item.label,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom
        ) {
            item {
                AnimatedVisibility(messagesList.isEmpty()) {
                    ElevatedCard(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(R.drawable.cow),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Moo! No messages yet.",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }

            items(messagesList.size) {
                if (messagesList[it].sender == "User") {
                    UserMessageCard(
                        text = messagesList[it].content,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    )
                } else {
                    BotMessageCard(
                        text = messagesList[it].content,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}