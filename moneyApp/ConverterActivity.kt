package se.linerotech.module201.lecture.moneyApp

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import se.linerotech.module201.lecture.R

class ConverterActivity : AppCompatActivity() {
    private lateinit var editTextAmount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_converter)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextAmount = findViewById(R.id.editTextAmount)

        editTextAmount.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val amount = editTextAmount.text.toString().toDoubleOrNull() ?: 0.0
                val intent = Intent(this, CurrencyConversionActivity::class.java)
                intent.putExtra("AMOUNT_SEK", amount)
                startActivity(intent)
                true
            } else {
                false
            }
        }
    }
}
