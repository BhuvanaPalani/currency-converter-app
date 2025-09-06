package se.linerotech.module201.lecture.moneyApp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.lecture.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonContinue = findViewById<Button>(R.id.buttonContinue)

        buttonContinue.setOnClickListener {
            val intent = Intent(this, CashActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
