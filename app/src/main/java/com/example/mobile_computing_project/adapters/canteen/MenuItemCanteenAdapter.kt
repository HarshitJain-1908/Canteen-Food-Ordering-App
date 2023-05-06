package com.example.mobile_computing_project.adapters.canteen

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobile_computing_project.R
import com.example.mobile_computing_project.databinding.ItemMenuCanteenBinding
import com.example.mobile_computing_project.models.MenuItem

class MenuItemCanteenAdapter(private val context: Context, private val menuItems: List<MenuItem>):
    RecyclerView.Adapter<MenuItemCanteenAdapter.ViewHolder>() {

    interface OnBtnClickListener {
        fun onBtnClick(item: MenuItem)
    }
    private var listener: OnBtnClickListener? = null

    fun setOnBtnClickListener(listener: OnBtnClickListener) {
        this.listener = listener
    }

//    private lateinit var tvName: TextView
//    private lateinit var tvPrice: TextView
//    private lateinit var ivVeg: ImageView
//    private lateinit var tvQty: TextView
//    private lateinit var ivImgSrc: ImageView

    inner class ViewHolder(private val binding: ItemMenuCanteenBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(menuItem: MenuItem, listener: OnBtnClickListener?){
            binding.tvName.text = menuItem.name.capitalize()
            binding.tvPrice.text = "Rs "+ menuItem.price.toString()
            binding.tvQty.text = "5 pcs"
            if (menuItem.isVeg){
                val color = Color.parseColor("#049D4E")
                binding.ivVegNonvegSymbol.setColorFilter(color)
            }
            Glide.with(context).load(menuItem.imgSrc).into(binding.ivImgSrc)
            binding.btnRemove.setOnClickListener {
                listener?.onBtnClick((menuItem))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_canteen, parent, false)
//        tvName = view.findViewById(R.id.tv_name)
//        tvPrice = view.findViewById(R.id.tv_price)
//        ivVeg = view.findViewById(R.id.iv_veg_nonveg_symbol)
//        tvQty = view.findViewById(R.id.tv_qty)
//        ivImgSrc = view.findViewById(R.id.iv_img_src)
        val binding = ItemMenuCanteenBinding.inflate(LayoutInflater.from((parent.context)), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = menuItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuItems[position], listener)
    }
}