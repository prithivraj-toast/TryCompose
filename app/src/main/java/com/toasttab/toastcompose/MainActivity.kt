package com.toasttab.toastcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Counter(CounterStatePresenter(0))
            }
        }
    }
}

@Composable
fun Counter(statePresenter: CounterStatePresenter) {
    Button(
        text = "I've been clicked ${statePresenter.getCount1()} times",
        onClick = {
            statePresenter.addOne()
        }

    )
    Text(text = statePresenter.getCount1().toString())
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Counter(CounterStatePresenter(0))
    }
}


@Model
class CounterStatePresenter(private var count: Int = 0){
    fun addOne() {
        count++
    }
    fun getCount1():Int{
        return count
    }
}