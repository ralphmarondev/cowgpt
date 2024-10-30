package com.ralphmarondev.cowgpt.features.onboarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.cowgpt.R

@Composable
fun OnBoardingScreen(
    navigateToHome: () -> Unit
) {
    var count by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.Transparent,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                ElevatedCard(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Skip",
                            fontFamily = FontFamily.Monospace
                        )
                    }
                }

                ElevatedCard(
                    onClick = {
                        if (count < 2) {
                            count++
                        } else {
                            navigateToHome()
                        }
                    },
                    modifier = Modifier
                        .weight(1f),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = if (count < 2) "Next" else "Done",
                            fontFamily = FontFamily.Monospace
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                AnimatedVisibility(count == 0) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = rememberAsyncImagePainter(R.drawable.cow),
                            contentDescription = "",
                            modifier = Modifier
                                .size(38.dp),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Welcome to CowGPT",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.W500,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = "Have you mooed today?",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W300,
                            color = MaterialTheme.colorScheme.tertiary
                        )

                        Spacer(modifier = Modifier.height(30.dp))
                        Icon(
                            imageVector = Icons.Outlined.LightMode,
                            contentDescription = ""
                        )
                        Text(
                            text = "Examples",
                            fontFamily = FontFamily.Monospace
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Explain quantum computing in simple terms ->",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Got any creative ideas for a 10 year old's birthday ->",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "How do I make an HTTP request in JavaScript ->",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }
                    }
                }
            }
            item {
                AnimatedVisibility(count == 1) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = rememberAsyncImagePainter(R.drawable.cow), // You can use a different cow image if desired
                            contentDescription = "Happy Cow",
                            modifier = Modifier.size(38.dp),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Your Moo-tivation Awaits!",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.W500,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = "Get ready to unleash your creativity with CowGPT! From answering your burning questions to sparking new ideas, we're here to moo-ve your mind!",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W300,
                            color = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(30.dp))
                        Icon(
                            imageVector = Icons.Outlined.LightMode,
                            contentDescription = ""
                        )
                        Text(
                            text = "Benefits",
                            fontFamily = FontFamily.Monospace
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "🌟 Ask Anything - No question is too silly!",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "🐄 Brainstorm Ideas - Let's get creative together!",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "💡 Learning Made Fun - Ask about any topic!",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }
                    }
                }
            }

            item {

                AnimatedVisibility(count == 2) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = rememberAsyncImagePainter(R.drawable.cow), // Use an engaging cow image
                            contentDescription = "Cow Community",
                            modifier = Modifier.size(38.dp),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Join the Moo-vement!",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.W500,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = "Become part of the CowGPT community where creativity flows like milk! Share your experiences, ideas, and let’s moo together!",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W300,
                            color = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(30.dp))
                        Icon(
                            imageVector = Icons.Outlined.LightMode,
                            contentDescription = ""
                        )
                        Text(
                            text = "Get Involved",
                            fontFamily = FontFamily.Monospace
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "📢 Share Feedback - We want to hear from you!",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "🤝 Connect with Other Users - Let's chat!",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "🧑‍🎨 Share Your Creations - Show us what you've got!",
                                    fontFamily = FontFamily.Monospace,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}