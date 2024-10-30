package com.ralphmarondev.cowgpt.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.cowgpt.R

@Composable
fun BotMessageCard(
    text: String,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
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
                text = text,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W500
            )
        }
    }
}