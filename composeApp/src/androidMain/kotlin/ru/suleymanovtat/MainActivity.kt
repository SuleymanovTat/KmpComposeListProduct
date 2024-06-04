package ru.suleymanovtat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import database.DriverFactory
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import presentation.App

class MainActivity : ComponentActivity() {


    private val modules = module {
        single { DriverFactory(applicationContext) }
    }

    init {
        loadKoinModules(modules)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}