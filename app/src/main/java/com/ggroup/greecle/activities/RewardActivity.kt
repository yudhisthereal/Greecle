package com.ggroup.greecle.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ggroup.greecle.R
import com.ggroup.greecle.models.Voucher
import com.ggroup.greecle.adapters.VoucherAdapter

class RewardActivity : AppCompatActivity() {

    private lateinit var points: ConstraintLayout

    private lateinit var dana:ConstraintLayout
    private lateinit var ovo:ConstraintLayout
    private lateinit var gopay:ConstraintLayout
    private lateinit var linkaja:ConstraintLayout
    private lateinit var shoopepay:ConstraintLayout

    private lateinit var recyclerView: RecyclerView
    private lateinit var voucherList: ArrayList<Voucher>
    private lateinit var voucherAdapter: VoucherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        dana = findViewById(R.id.constraintLayout2)
        ovo = findViewById(R.id.constraintLayout3)
        gopay = findViewById(R.id.constraintLayout4)
        linkaja = findViewById(R.id.constraintLayout5)
        shoopepay = findViewById(R.id.constraintLayout6)

        dana.setOnClickListener {
            navigateToHomeActivity()
        }
        ovo.setOnClickListener {
            navigateToHomeActivity()
        }
        gopay.setOnClickListener {
            navigateToHomeActivity()
        }
        linkaja.setOnClickListener {
            navigateToHomeActivity()
        }
        shoopepay.setOnClickListener {
            navigateToHomeActivity()
        }

        points = findViewById(R.id.constraintLayout11)
        points.setOnClickListener {
            val intent = Intent(this, DetailRewardActivity::class.java)
            startActivity(intent)
        }
        init()
    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        voucherList = ArrayList()
        addDataToList()

        voucherAdapter = VoucherAdapter(voucherList)
        recyclerView.adapter = voucherAdapter
    }

    private fun addDataToList(){
        voucherList.add(Voucher(R.drawable.background_voucher,40))
//        voucherList.add(Voucher(R.drawable.voucher2,40))
//        voucherList.add(Voucher(R.drawable.voucher3,40))
        voucherList.add(Voucher(R.drawable.background_voucher,40))
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}