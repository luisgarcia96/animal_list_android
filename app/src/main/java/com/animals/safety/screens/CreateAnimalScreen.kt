package com.animals.safety.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.animals.safety.R
import com.animals.safety.data.Animal
import com.animals.safety.data.AnimalData
import com.animals.safety.data.Breed
import com.animals.safety.ui.theme.AimantsDanimauxTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAnimalScreen(
  modifier: Modifier = Modifier,
  onBackClick: () -> Unit,
  onSaveClick: () -> Unit
) {
  val scope = rememberCoroutineScope()
  val context = LocalContext.current
  val snackbarHostState = remember { SnackbarHostState() }

  val name = rememberSaveable { mutableStateOf("") }
  val breed = rememberSaveable { mutableStateOf(Breed.entries[0]) }
  val age = rememberSaveable { mutableStateOf("") }
  val weight = rememberSaveable { mutableStateOf("") }
  val height = rememberSaveable { mutableStateOf("") }

  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = {
          Text(stringResource(id = R.string.create_fragment_label))
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
    snackbarHost = {
      SnackbarHost(hostState = snackbarHostState)
    },
    floatingActionButtonPosition = FabPosition.Center,
    floatingActionButton = {
      ExtendedFloatingActionButton(
        onClick = {
          if (verifyAndCreateAnimal(
              name.value,
              breed.value,
              age.value,
              weight.value,
              height.value,
              snackbarHostState,
              scope,
              context
            )
          ) {
            onSaveClick()
          }
        }
      ) {
        Text(
          text = stringResource(id = R.string.action_save)
        )
      }
    }
  ) { contentPadding ->
    CreateAnimal(
      modifier = Modifier.padding(contentPadding),
      name = name.value,
      onNameChanged = { name.value = it },
      breed = breed.value,
      onBreedChanged = { breed.value = it },
      age = age.value,
      onAgeChanged = { age.value = it },
      weight = weight.value,
      onWeightChanged = { weight.value = it },
      height = height.value,
      onHeightChanged = { height.value = it }
    )
  }
}

fun verifyAndCreateAnimal(
  name: String,
  breed: Breed,
  age: String,
  weight: String,
  height: String,
  snackbarHostState: SnackbarHostState,
  scope: CoroutineScope,
  context: Context
): Boolean {
  if (name.isBlank()) {
    scope.launch {
      snackbarHostState.showSnackbar(context.getString(R.string.issue_name_empty))
    }

    return false;
  }

  val animalAge: Int;
  try {
    animalAge = age.toInt()
  } catch (e: NumberFormatException) {
    scope.launch {
      snackbarHostState.showSnackbar(context.getString(R.string.issue_invalid_age))
    }

    return false;
  }

  val animalWeight: Float;
  try {
    animalWeight = weight.toFloat()
  } catch (e: NumberFormatException) {
    scope.launch {
      snackbarHostState.showSnackbar(context.getString(R.string.issue_invalid_weight))
    }

    return false;
  }

  val animalHeight: Float;
  try {
    animalHeight = height.toFloat()
  } catch (e: NumberFormatException) {
    scope.launch {
      snackbarHostState.showSnackbar(context.getString(R.string.issue_invalid_height))
    }

    return false;
  }

  AnimalData.animals.add(
    Animal(
      UUID.randomUUID(),
      name,
      breed,
      animalAge,
      animalWeight,
      animalHeight,
      breed.cover
    )
  )

  return true
}

@Composable
private fun CreateAnimal(
  modifier: Modifier = Modifier,
  name: String,
  onNameChanged: (String) -> Unit,
  age: String,
  onAgeChanged: (String) -> Unit,
  weight: String,
  onWeightChanged: (String) -> Unit,
  height: String,
  onHeightChanged: (String) -> Unit,
  breed: Breed,
  onBreedChanged: (Breed) -> Unit
) {
  val scrollState = rememberScrollState()
  var expanded by remember { mutableStateOf(false) }

  Column(
    modifier = modifier
      .padding(bottom = 88.dp, top = 16.dp, start = 16.dp, end = 16.dp)
      .fillMaxSize()
      .verticalScroll(scrollState)
  ) {
    Column {
      //Name text field
      OutlinedTextField(
        value = name,
        onValueChange = onNameChanged,
        label = {
          Text(stringResource(id = R.string.hint_name))
        },
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
      )

      //Breed dropdown
      Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
          value = stringResource(id = breed.translatedName),
          onValueChange = { },
          readOnly = true,
          label = { Text(stringResource(id = R.string.hint_breed)) },
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
          trailingIcon = {
            // Step 3: Use IconButton and conditionally set the icon based on the `expanded` state
            IconButton(
              onClick = { expanded = !expanded } // Toggle expanded state when clicked
            ) {
              // Display ExpandLess icon if expanded, else ExpandMore
              Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expanded) "Collapse" else "Expand"
              )
            }
          }
        )

        DropdownMenu(
          expanded = expanded,
          onDismissRequest = { expanded = false } // Set expanded to false when menu is dismissed
        ) {
          // Display each breed option as a dropdown item
          Breed.entries.forEach { breedOption ->
            DropdownMenuItem(
              text = { Text(stringResource(id = breedOption.translatedName)) },
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
              onClick = {
                onBreedChanged(breedOption) // Update selected breed
                expanded = false // Close dropdown after selecting an option
              }
            )
          }
        }
      }


      //Age text field
      OutlinedTextField(
        value = age,
        onValueChange = onAgeChanged,
        label = {
          Text(stringResource(id = R.string.hint_age))
        },
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
      )

      //Weight text field
      OutlinedTextField(
        value = weight,
        onValueChange = onWeightChanged,
        label = {
          Text(stringResource(id = R.string.hint_weight))
        },
        suffix = { Text("kg") },
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
      )

      //Height text field
      OutlinedTextField(
        value = height,
        onValueChange = onHeightChanged,
        label = {
          Text(stringResource(id = R.string.hint_height))
        },
        suffix = { Text("cm") },
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun CreateAnimalPreview() {
  AimantsDanimauxTheme(dynamicColor = false) {
    CreateAnimal(
      name = "Milou",
      onNameChanged = { },
      age = "6",
      onAgeChanged = { },
      weight = "473.6",
      onWeightChanged = { },
      height = "14.7",
      onHeightChanged = { },
      breed = Breed.entries[0],
      onBreedChanged = { }
    )
  }
}