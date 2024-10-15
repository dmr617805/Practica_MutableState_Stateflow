package com.example.practicainvestigacion.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practicainvestigacion.ui.viewmodels.DemoViewModel

@Composable
fun DetailScreen(navController: NavController, demoViewModel: DemoViewModel) {

    val demoUiState by demoViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Detail Screen", fontSize = 30.sp, color = Color.Blue, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = buildAnnotatedString {
            append("Estimado sr.")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append(demoUiState.apellido)
            }
            append(" por favor lea los siguientes terminos y condiciones:")
        })

        Spacer(modifier = Modifier.height(24.dp))

        Text(text= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eget felis condimentum ligula accumsan porttitor at a massa.")
        Spacer(modifier = Modifier.height(24.dp))

        Text(text= "Actualice su apellido si no es el correcto")
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

        Spacer(modifier = Modifier.height(32.dp))



        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(0.85f)
        ) {
            Text("Regresar")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    val demoViewModel: DemoViewModel = viewModel()
    DetailScreen(navController, demoViewModel)
}