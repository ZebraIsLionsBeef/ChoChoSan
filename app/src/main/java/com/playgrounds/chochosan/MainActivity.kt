package com.playgrounds.chochosan

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.playgrounds.chochosan.ui.theme.ChoChoSanTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChoChoSanTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Scaffold(content = {
                        Content(painter = painterResource(id = R.drawable.madame_butterfly)) {
                            seppuku()
                        }
                    });
                }
            }
        }
    }

    private fun seppuku() {
        Log.v("ConOnorMuore", "pm uninstall $packageName")
//        Runtime.getRuntime().exec("pm uninstall $packageName")
        val uri = Uri.fromParts("package", packageName, null)
        val intent = Intent(Intent.ACTION_DELETE, uri)
        startActivityForResult(intent, 1)
    }
}

@Composable
fun Content(painter: Painter?, onClick: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        if (painter != null) {
            Image(painter = painter, contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = onClick,
                content = { Text("Con onor muore") })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChoChoSanTheme {
        Content(painter = painterResource(id = R.drawable.madame_butterfly))
    }
}