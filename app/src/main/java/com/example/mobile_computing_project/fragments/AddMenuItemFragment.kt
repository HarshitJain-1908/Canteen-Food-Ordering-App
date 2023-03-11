package com.example.mobile_computing_project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.DialogFragment
import com.example.mobile_computing_project.R

class AddMenuItemFragment: DialogFragment() {
    private lateinit var btnDismiss: Button
    private lateinit var btnConfirmAddItem: Button
    private lateinit var etItemName: EditText
    private lateinit var etItemPrice: EditText
    private lateinit var etItemServingSize: EditText
//    private lateinit var rbVeg: RadioButton
//    private lateinit var rbNonVeg: RadioButton
    private lateinit var tbVeg: ToggleButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_item_canteen, container, false)
        btnDismiss = view.findViewById(R.id.btn_dismiss)
        btnConfirmAddItem = view.findViewById(R.id.btn_add_item)
        etItemName = view.findViewById(R.id.et_name)
        etItemPrice = view.findViewById(R.id.et_price)
        etItemServingSize = view.findViewById(R.id.et_serving_size)
        tbVeg = view.findViewById(R.id.tb_veg_nonveg)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDismiss.setOnClickListener {
            dismiss()
        }

        btnConfirmAddItem.setOnClickListener {
            var x:String = if (tbVeg.isChecked) "Non Veg"
            else "Veg"

            // Add utility to add item by posting over here

            Toast.makeText(context, "Added new $x item to menu!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        tbVeg.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tbVeg.setBackgroundColor(resources.getColor(R.color.non_veg))
            } else {
                tbVeg.setBackgroundColor(resources.getColor(R.color.veg))
            }
        }

    }
}