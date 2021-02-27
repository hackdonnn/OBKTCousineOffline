package com.amrit.onebancassignment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment(), View.OnClickListener {

    private val mMainViewModel: MainViewModel by activityViewModels()
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        placeOrder.setOnClickListener(this)
        mMainViewModel.getCartLiveData().observe(viewLifecycleOwner) { dishList -> setUI(dishList) }
    }

    private fun setUI(dishList: List<Dish>) {
        if (dishList.isNotEmpty()) {
            dishesOrderedList.layoutManager = LinearLayoutManager(mContext)
            dishesOrderedList.adapter = CartAdapter(dishList)
            setMainLayoutVisibility(true)
            setAmountData(dishList)
        } else {
            setMainLayoutVisibility(false)
        }
    }

    private fun setAmountData(dishList: List<Dish>) {
        var net = 0
        for (dish in dishList) {
            net += (dish.price * dish.count)
        }
        val gst = 0.025 * net
        val grand = gst * 2 + net
        netAmount.text = net.toString()
        cGst.text = gst.toString()
        sGst.text = gst.toString()
        grandTotal.text = grand.toString()
    }

    private fun setMainLayoutVisibility(isVisible: Boolean) {
        if (isVisible) {
            mainCartLayout.visibility = View.VISIBLE
            noItem.visibility = View.GONE
        } else {
            mainCartLayout.visibility = View.GONE
            noItem.visibility = View.VISIBLE
        }
    }

    override fun onClick(v: View?) {
        Toast.makeText(mContext, R.string.txt_order_success, Toast.LENGTH_SHORT).show()
    }

}