package com.example.ammgolamyeazdani.calculator;

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ammgolamyeazdani.calculator.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList as Lis
import javax.script.ScriptEngineManager
import javax.script.ScriptEngine
import android.util.Log
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var result: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        with(binding) {
            val buttonList = arrayListOf<TextView>(
                one, two, three, four, five, six, seven, eight, nine, dot, div,
                multi, sub, plus, clear,equals
            )
            for (index in 0 until buttonList.size) {
                buttonList[index].setOnClickListener(this@MainActivity)

            }
            backDelete.setOnClickListener(this@MainActivity)

        }


        val equalsButton = binding.equals
//        equalsButton.setOnLongClickListener { view ->
//            // Code to handle long-press event for the "equals" button
//            // For example, display a toast message
//            Toast.makeText(this@MainActivity, binding.display.text, Toast.LENGTH_SHORT).show()
//
//            // Return true to indicate that you've handled the long-press
//            true
//        }

        equalsButton.setOnLongClickListener { view ->
            // Code to handle long-press event for the "equals" button
            val displayText = binding.display.text.toString()
            showNotification(displayText)
            true
        }

    }


    private fun showNotification(content: String) {
        val channelId = "calculator_channel"
        val notificationId = 1

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create a notification channel if running on Android Oreo or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                    channelId,
                    "Calculator Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Create an intent to launch the app when the notification is clicked
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_notification_icon) // Replace with your notification icon
                .setContentTitle("Calculator Result")
                .setContentText("Result: $content")
                .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.one -> {
                if (binding.display.text != "") {
                    binding.display.append("1")
                } else {
                    binding.display.text = "1"
                }
            }
            R.id.two -> {
                if (binding.display.text != "") {
                    binding.display.append("2")
                } else {
                    binding.display.text = "2"
                }
            }
            R.id.three -> {
                if (binding.display.text != "") {
                    binding.display.append("3")
                } else {
                    binding.display.text = "3"
                }
            }
            R.id.four -> {
                if (binding.display.text != "") {
                    binding.display.append("4")
                } else {
                    binding.display.text = "4"
                }
            }
            R.id.five -> {
                if (binding.display.text != "") {
                    binding.display.append("5")
                } else {
                    binding.display.text = "5"
                }
            }
            R.id.six -> {
                if (binding.display.text != "") {
                    binding.display.append("6")
                } else {
                    binding.display.text = "6"
                }
            }
            R.id.seven -> {
                if (binding.display.text != "") {
                    binding.display.append("7")
                } else {
                    binding.display.text = "7"
                }
            }
            R.id.eight -> {
                if (binding.display.text != "") {
                    binding.display.append("8")
                } else {
                    binding.display.text = "8"
                }
            }
            R.id.nine -> {
                if (binding.display.text != "") {
                    binding.display.append("9")
                } else {
                    binding.display.text = "9"
                }
            }
            R.id.zero -> {
                if (binding.display.text != "") {
                    binding.display.append(".")
                } else {
                    binding.display.text = "."
                }
            }

            R.id.plus -> {
                if (binding.display.text != "") {
                    binding.display.append("+")
                } else {
                    binding.display.text = "+"
                }
            }
            R.id.div -> {
                if (binding.display.text != "") {
                    binding.display.append("/")
                } else {
                    binding.display.text = "/"
                }
            }
            R.id.multi -> {
                if (binding.display.text != "") {
                    binding.display.append("*")
                } else {
                    binding.display.text = "*"
                }
            }
            R.id.sub -> {
                if (binding.display.text != "") {
                    binding.display.append("-")
                } else {
                    binding.display.text = "-"
                }
            }
            R.id.clear -> {
                binding.display.text = null
            }
            R.id.equals -> {
                if (binding.display.text != "") {
                    calculate(binding.display.text.toString())
                } else {
                    Toast.makeText(this, "Nothing to Calculate", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.dot -> {
                if (binding.display.text != "") {
                    binding.display.append("0")
                } else {
                    binding.display.text = "0"
                }
            }
            R.id.backDelete -> {
                if (binding.display.text != "") {
                    val s: String = binding.display.text.toString()
                    if (s.length > 0) {
                        binding.display.setText(s.substring(0, s.length - 1))
                    } else {
                        Toast.makeText(this, "Nothing to remove", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "nothing to remove", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun calculate(display: String) {
        try {
            // Evaluate the expression using the JavaScript script engine
            val engine = ScriptEngineManager().getEngineByName("js")
            val result = engine.eval(display) as Double
            val formattedResult = String.format("%.2f", result) // Format the result as needed
            binding.display.text = formattedResult
        } catch (e: Exception) {
            binding.display.text = "Error"
            Log.e("Calculator", "Error evaluating expression", e)
        }
    }

}
