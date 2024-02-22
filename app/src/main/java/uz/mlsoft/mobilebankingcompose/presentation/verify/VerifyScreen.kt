package uz.mlsoft.mobilebankingcompose.presentation.verify

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen

class VerifyScreen :AndroidScreen() {
    @Composable
    override fun Content() {
        VerifyUserScreen()
    }
}

@Composable
fun VerifyUserScreen(

){
    var code by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = code,
            onValueChange = { value ->
                // Ensure only numbers are allowed and limit the length to 6
                if (value.length <= 6 && value.all { it.isDigit() }) {
                    code = value
                }
            },
            label = { Text("Enter Verification Code") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {

            },
            enabled = code.length == 6, // Enable the button only when 6 digits are entered
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

