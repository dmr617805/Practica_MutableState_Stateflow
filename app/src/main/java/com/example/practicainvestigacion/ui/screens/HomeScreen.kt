package com.example.practicainvestigacion.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practicainvestigacion.ui.navigation.Screen
import com.example.practicainvestigacion.ui.viewmodels.DemoViewModel

@Composable
fun HomeScreen(navController: NavController, demoViewModel: DemoViewModel) {


    var nombre by remember { mutableStateOf("") }
    val demoUiState by demoViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Home Screen", fontSize = 30.sp, color = Color.Blue, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        Text("MutableState", fontSize = 16.sp, color = Color.Red, fontStyle = FontStyle.Italic)

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Hola: $nombre")

        Spacer(modifier = Modifier.height(24.dp))

        Text("StateFlow", fontSize = 16.sp, color = Color.Red, fontStyle = FontStyle.Italic)

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = demoUiState.apellido,
            onValueChange = { demoViewModel.updateDemoState(it) },
            label = { Text("Apellido") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            )
        )



        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate(Screen.Detail.route) },
            modifier = Modifier.fillMaxWidth(0.85f)
        ) {
            Text("Ir a detalle")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    val demoViewModel: DemoViewModel = viewModel()
    HomeScreen(navController, demoViewModel)
}