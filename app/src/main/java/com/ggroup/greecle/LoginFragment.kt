package com.ggroup.greecle

import android.content.Intent
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
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.roundToInt
import kotlin.math.sign


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)
        val noAccountText: TextView = view.findViewById(R.id.signUp)

        val text = "No Account? Sign Up"
        var ss = SpannableStringBuilder(text)

        val clickableSpanSignup: ClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                val signupFragment = RegisterFragment()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragmentContainerView, signupFragment)?.commit()

                val rootLayout = activity?.findViewById<ConstraintLayout>(R.id.rootMain)
                val paddingValue: Int = (24 * resources.displayMetrics.density).roundToInt()
                rootLayout?.setPadding(paddingValue, paddingValue/2, paddingValue, paddingValue/2)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        ss.setSpan(clickableSpanSignup, 12, 19, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(StyleSpan(Typeface.BOLD), 12, 19, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(ForegroundColorSpan(Color.parseColor("#3C9C3D")), 12, 19, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        noAccountText.text = ss
        noAccountText.movementMethod = LinkMovementMethod.getInstance()

        val forgotPass: TextView = view.findViewById(R.id.forgotPassword)
        forgotPass.setOnClickListener{
            val intent = Intent(activity, ForgotPasswordActivity::class.java)
            activity?.startActivity(intent)
        }

        return view
    }
}