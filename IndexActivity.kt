package se.linerotech.module201.lecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.lecture.databinding.ActivityIndexBinding
import se.linerotech.module201.lecture.brandApp.WelcomeActivity as brandAppMainActivity
import se.linerotech.module201.lecture.moneyApp.MainActivity as MoneyAppMainActivity

class IndexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startMoneyApp()
        startBrandApp()
    }

    private fun startMoneyApp() {
        binding.buttonMoneyApp.setOnClickListener {
            startActivity(MoneyAppMainActivity.intent(this))
        }
    }

    private fun startBrandApp() {
        binding.buttonBrandApp.setOnClickListener {
            startActivity(brandAppMainActivity.intent(this))
        }
    }
}
