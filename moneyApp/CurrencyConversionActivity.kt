package se.linerotech.module201.lecture.moneyApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import se.linerotech.module201.lecture.R
import java.util.Locale

class CurrencyConversionActivity : AppCompatActivity() {

    companion object {
        private const val EURO_RATE = 0.08775
        private const val USD_RATE = 0.0952
    }

    private lateinit var textViewSek: TextView
    private lateinit var textViewEuro: TextView
    private lateinit var textViewDollar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_currency_conversion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textViewSek = findViewById(R.id.textViewSek)
        textViewEuro = findViewById(R.id.textViewEuro)
        textViewDollar = findViewById(R.id.textViewDollar)

        val amountSek = intent.getDoubleExtra("AMOUNT_SEK", 0.0)

        val euroValue = amountSek * EURO_RATE
        val usdValue = amountSek * USD_RATE

        textViewSek.text = String.format(Locale.US, "%.2f SEK", amountSek)
        textViewEuro.text = String.format(Locale.US, "%.2f", euroValue)
        textViewDollar.text = String.format(Locale.US, "%.2f", usdValue)
    }
}
