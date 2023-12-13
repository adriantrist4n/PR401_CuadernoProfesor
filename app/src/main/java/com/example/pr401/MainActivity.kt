package com.example.pr401

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pr401.ui.theme.Brown80
import com.example.pr401.ui.theme.Cream80
import com.example.pr401.ui.theme.LightBrown80
import com.example.pr401.ui.theme.PR401Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PR401Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(modifier: Modifier = Modifier) {
    // Caja que contiene toda la pantalla
    Box(
        modifier = modifier
            .background(color = Cream80)
            .fillMaxSize(),
    ) {
        Column {
            // Primer apartado
            Box(
                modifier = modifier
                    .background(color = Brown80)
                    .fillMaxWidth()
                    .height(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Imagen del logo
                    Image(
                        painter = painterResource(id = R.drawable.pmdm),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(100.dp)
                            .padding(5.dp)
                    )
                    // Texto con el código del proyecto
                    Text(
                        text = "PR401 - Cuaderno Profesor",
                        fontSize = 22.sp,
                        style = MaterialTheme.typography.titleLarge.copy(
                            shadow = Shadow(
                                offset = Offset(10f, 10f),
                                blurRadius = 10f,
                                color = Color.Black.copy(alpha = 0.3f)
                            )
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            } // Termina primer apartado

            // Segundo apartado
            Box(
                modifier = Modifier.padding(top = 9.dp, bottom = 9.dp, start = 9.dp, end = 9.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = LightBrown80)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ) {
                    Row {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()
                        ) {
                            var numeroTexto by remember { mutableStateOf(TextFieldValue("")) }
                            var numeroArray: Int by remember { mutableStateOf(0) }
                            var alumnosArray by remember { mutableStateOf<IntArray?>(null) }
                            var notasTexto by remember { mutableStateOf(TextFieldValue("")) }
                            var mostrarDialogo by remember { mutableStateOf(false) }
                            var mensajeDialogo by remember { mutableStateOf("") }
                            var botonPresionado by remember { mutableStateOf(false) }
                            var arrayLleno by remember { mutableStateOf(false) }
                            var numeroAlto: Int by remember { mutableStateOf(0) }
                            var numeroMedia: Double by remember { mutableStateOf(0.0) }




                            // OutlinedTextField para ingresar el número de alumnos
                            if (!botonPresionado) {
                                OutlinedTextField(
                                    value = numeroTexto,
                                    onValueChange = {
                                        val nuevoNumero = it.text.toIntOrNull()

                                        if (nuevoNumero != null && nuevoNumero >= 0) {
                                            numeroTexto = it
                                            numeroArray = nuevoNumero
                                        } else {
                                            numeroTexto = TextFieldValue("")
                                            numeroArray = 0
                                            mostrarDialogo = true
                                            mensajeDialogo = if (it.text.isNotEmpty()) {
                                                "Por favor, ingrese un número entero positivo"
                                            } else {
                                                "Por favor, ingrese un número"
                                            }
                                        }
                                    },
                                    label = { Text(text = "Ingresa el numero de alumnos del curso:") },
                                    keyboardOptions = KeyboardOptions.Default.copy(
                                        keyboardType = KeyboardType.Number
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 16.dp)
                                )
                            }

                            if (!botonPresionado) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Button(onClick = {
                                        alumnosArray = IntArray(numeroArray)
                                        botonPresionado = true
                                    }) {
                                        Icon(Icons.Default.Send, contentDescription = null)
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Enviar")
                                    }
                                }
                            }

                            if (botonPresionado && alumnosArray != null) {
                                OutlinedTextField(
                                    value = notasTexto,
                                    onValueChange = {
                                        notasTexto = it
                                    },
                                    label = { Text(text = "Ingresa las notas de los alumnos:") },
                                    keyboardOptions = KeyboardOptions.Default.copy(
                                        keyboardType = KeyboardType.Number
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp)
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Button(
                                        onClick = {
                                            if (notasTexto.text.isNotBlank()) {
                                                val indice = alumnosArray!!.indexOfFirst { it == 0 }
                                                if (indice != -1) {
                                                    alumnosArray!![indice] = notasTexto.text.toInt()
                                                    notasTexto = TextFieldValue("")
                                                } else {
                                                    mostrarDialogo = true
                                                    mensajeDialogo =
                                                        "Ya has ingresado todas las notas"
                                                }
                                            }
                                        }, modifier = Modifier.padding(top = 8.dp)
                                    ) {
                                        Text("Insertar Nota")
                                    }

                                    Spacer(modifier = Modifier.width(8.dp))

                                    Button(
                                        onClick = {
                                            mostrarDialogo = true
                                            mensajeDialogo =
                                                "Notas: ${alumnosArray?.contentToString()}"

                                        }, modifier = Modifier.padding(top = 8.dp)
                                    ) {
                                        Text("Ver notas")
                                    }
                                }

                                if (arrayLleno) {
                                    Spacer(modifier = Modifier.height(50.dp))
                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                    ) {
                                        Button(
                                            onClick = {
                                               numeroAlto = encontrarValorMasAlto(alumnosArray!!)
                                                mostrarDialogo = true
                                                mensajeDialogo = "La nota mas alta de la clase es: $numeroAlto"
                                            }, modifier = Modifier.padding(top = 8.dp)
                                        ) {
                                            Text("Sacar la nota mas alta")
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(8.dp)) // Espacio adicional entre las filas de botones

                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                    ) {
                                        // Segundo nuevo botón después de que el array está lleno
                                        Button(
                                            onClick = {
                                                numeroMedia = calcularMediaSinExtremos(alumnosArray!!)
                                                mostrarDialogo = true
                                                mensajeDialogo = "La media de la clase quitando la nota más alta y más baja es: $numeroMedia"
                                            }, modifier = Modifier.padding(top = 8.dp)
                                        ) {
                                            Text("Calcular la media de la notas")
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(8.dp)) // Espacio adicional entre las filas de botones

                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                    ) {
                                        // Segundo nuevo botón después de que el array está lleno
                                        Button(
                                            onClick = {
                                                // Lógica para el segundo nuevo botón después de que el array está lleno
                                                // ...
                                            }, modifier = Modifier.padding(top = 8.dp)
                                        ) {
                                            Text("Borrar una nota concreta")
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(8.dp)) // Espacio adicional entre las filas de botones

                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                    ) {
                                        // Segundo nuevo botón después de que el array está lleno
                                        Button(
                                            onClick = {
                                                // Lógica para el segundo nuevo botón después de que el array está lleno
                                                // ...
                                            }, modifier = Modifier.padding(top = 8.dp)
                                        ) {
                                            Text("Borrar todas las notas")
                                        }
                                    }

                                }

                                if (alumnosArray!!.all { it != 0 }) {
                                    arrayLleno = true
                                }

                            }

                            if (mostrarDialogo) {
                                MostrarResultadoDialog(mensajeDialogo) {
                                    mostrarDialogo = false
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun MostrarResultadoDialog(mensaje: String, onClose: () -> Unit) {
    AlertDialog(onDismissRequest = { onClose() },
        title = { Text("Resultado") },
        text = { Text(mensaje) },
        confirmButton = {
            Button(onClick = { onClose() }) {
                Text("Aceptar")
            }
        })
}

fun encontrarValorMasAlto(array: IntArray): Int {
    if (array.isEmpty()) {
        throw IllegalArgumentException("El array no puede estar vacío")
    }

    var valorMasAlto = array[0]

    for (valor in array) {
        if (valor > valorMasAlto) {
            valorMasAlto = valor
        }
    }

    return valorMasAlto
}
fun encontrarValorMasBajo(array: IntArray): Int {
    if (array.isEmpty()) {
        throw IllegalArgumentException("El array no puede estar vacío")
    }

    var valorMasBajo = array[0]

    for (valor in array) {
        if (valor < valorMasBajo) {
            valorMasBajo = valor
        }
    }

    return valorMasBajo
}
fun calcularMediaSinExtremos(array: IntArray): Double {
    if (array.size < 3) {
        throw IllegalArgumentException("El array debe tener al menos tres elementos")
    }

    // Encuentra el valor más alto y el valor más bajo
    val valorMasAlto = encontrarValorMasAlto(array)
    val valorMasBajo = encontrarValorMasBajo(array)

    // Suma todos los valores excluyendo los extremos
    val suma = array.filter { it != valorMasAlto && it != valorMasBajo }.sum()

    // Calcula la media
    val cantidadValores = array.size - 2 // Excluye los dos extremos
    return suma.toDouble() / cantidadValores
}


