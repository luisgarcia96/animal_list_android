package com.animals.safety.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.animals.safety.R
import com.animals.safety.data.Animal
import com.animals.safety.data.Breed
import com.animals.safety.ui.theme.AimantsDanimauxTheme
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalDetailsScreen(
  modifier: Modifier = Modifier,
  animal: Animal,
  onBackClick: () -> Unit,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = {
          Text(stringResource(id = R.string.details_fragment_label))
        },
        navigationIcon = {
          IconButton(onClick = {
            onBackClick()
          }) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = stringResource(id = R.string.contentDescription_go_back)
            )
          }
        }
      )
    },
  ) { contentPadding ->
    AnimalDetails(
      modifier = modifier.padding(contentPadding),
      animal = animal,
    )
  }
}

@Composable
fun AnimalAttribute(
  iconResId: Int,
  label: String,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Icon(
      painter = painterResource(id = iconResId),
      contentDescription = null,
      modifier = Modifier.size(56.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
      text = label,
      style = MaterialTheme.typography.bodyMedium
    )
  }
}



@Composable
private fun AnimalDetails(
  modifier: Modifier = Modifier,
  animal: Animal,
) {
  Column(modifier = modifier) {
    Box {
      //Image
      Image(
        painter = painterResource(id = animal.imageResId),
        contentDescription = "${animal.name} avatar",
        modifier = Modifier
          .height(410.dp)    // Set height for image
          .fillMaxWidth()    // Make image fill width if needed
      )

      //Name
      Text(
        text = animal.name,
        color = Color.White,
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier
          .align(Alignment.BottomStart)
          .padding(8.dp)
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    //Animal Info
    Row {
      //Age
      AnimalAttribute(
        iconResId = R.drawable.ic_age,
        label = stringResource(id = R.string.value_age, animal.age),
        modifier = Modifier.weight(1f)
      )

      //Weight
      AnimalAttribute(
        iconResId = R.drawable.ic_weight,
        label = stringResource(id = R.string.value_weight, animal.weight),
        modifier = Modifier.weight(1f)
      )
    }
    Row {
      //Height
      AnimalAttribute(
        iconResId = R.drawable.ic_height,
        label = stringResource(id = R.string.value_height, animal.height),
        modifier = Modifier.weight(1f)
      )

    }
  }
}

@Preview(showBackground = true)
@Composable
private fun AnimalDetailsPreview() {
  AimantsDanimauxTheme(dynamicColor = false) {
    AnimalDetails(
      animal = Animal(UUID.randomUUID(), "Milou", Breed.DOG, 6, 23.2f, 42.4f, R.drawable.img_dog),
    )
  }
}