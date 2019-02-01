package io.github.thiminhnhut.fragmentanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import io.github.thiminhnhut.fragmentanimation.view.BlankFragment

class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener {

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editText = findViewById(R.id.edittext)

        button.setOnClickListener {
            val text = editText.text.toString()
            openFragment(text)
        }
    }

    private fun openFragment(text: String) {
        val fragment = BlankFragment.newInstance(text)
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_right,
                R.anim.enter_from_right,
                R.anim.exit_to_right)
//            .setCustomAnimations(
//                R.anim.enter,
//                R.anim.exit,
//                R.anim.pop_enter,
//                R.anim.pop_exit)
            .addToBackStack("BLANK_FRAGMENT")
            .add(R.id.fragment_container, fragment, "BLANK_FRAGMENT")
            .commit()
    }

    override fun onFragmentInteraction(sendBackText: String) {
        editText.setText(sendBackText)
        onBackPressed()
    }
}
