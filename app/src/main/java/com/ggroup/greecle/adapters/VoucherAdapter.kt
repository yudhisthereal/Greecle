package com.ggroup.greecle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ggroup.greecle.R
import com.ggroup.greecle.models.Voucher

class VoucherAdapter(private val voucherList:ArrayList<Voucher>):
    RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>() {

    class VoucherViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView12)
        val textView: TextView = itemView.findViewById(R.id.textView23)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.voucher_item,parent, false)
        return VoucherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return voucherList.size
    }

    override fun onBindViewHolder(holder: VoucherViewHolder, position: Int) {
        val voucher = voucherList[position]
        holder.imageView.setImageResource(voucher.imageVoucher)
        holder.textView.text = voucher.pointsVoucher.toString()
    }
}