package com.ggroup.greecle

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.roundToInt


/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_register, container, false)
        val noAccountText: TextView = view.findViewById(R.id.signIn)

        val text = "Have an Account? Sign In"
        var ss = SpannableStringBuilder(text)

        val clickableSpanSignup: ClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                val signupFragment = LoginFragment()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragmentContainerView, signupFragment)?.commit()

                val rootLayout = activity?.findViewById<ConstraintLayout>(R.id.rootMain)
                val paddingHorizontal = (24 * resources.displayMetrics.density).roundToInt()
                val paddingVertical = (64 * resources.displayMetrics.density).roundToInt()
                rootLayout?.setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        ss.setSpan(clickableSpanSignup, 17, 24, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(StyleSpan(Typeface.BOLD), 17, 24, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(ForegroundColorSpan(Color.parseColor("#3C9C3D")), 17, 24, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        noAccountText.text = ss
        noAccountText.movementMethod = LinkMovementMethod.getInstance()

        return view
    }
}