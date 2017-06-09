package com.awecode.stockapp.view.tools

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import com.awecode.stockapp.R
import com.awecode.stockapp.model.ShareItem
import com.awecode.stockapp.util.CalculationUtil
import com.awecode.stockapp.util.Util.Companion.parseDouble
import com.awecode.stockapp.util.Util.Companion.parseInt
import com.awecode.stockapp.view.adapter.ShareCalcListAdapter
import com.awecode.stockapp.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_share_calculator.*
import kotlinx.android.synthetic.main.layout_share_buy.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*
import kotlin.collections.ArrayList


class ShareCalculatorFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_share_calculator

    companion object {
        fun newInstance(): ShareCalculatorFragment {
            return ShareCalculatorFragment()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTypeSpinner()
        setupPriceTextWatcher()
        setupQuantityTextWatcher()
    }

    private fun calculateTotalAmount(quantity: Int, perSharePrice: Double) {

        val totalAmount = quantity * perSharePrice
        if (totalAmount == 0.0) {
            recyclerView.visibility = View.GONE
            return
        }
        recyclerView.visibility = View.VISIBLE

        val commissionAmount = CalculationUtil.brokerCommission(totalAmount)
        val sebonFee = CalculationUtil.sebonFee(totalAmount)
        val dpCharge = 25.0 //sadhai ehi huncha
        var totalPayableAmount = totalAmount + commissionAmount + sebonFee + dpCharge
        val costPricePerShare = totalPayableAmount / (shareQuantityEditText.text.toString().toInt())

        setupListAdapter(ArrayList<ShareItem>().apply {
            add(ShareItem("Total Amount", totalAmount))
            add(ShareItem("Commission", commissionAmount))
            add(ShareItem("SEBON Fee", sebonFee))
            add(ShareItem("DP Charge", dpCharge))
            add(ShareItem("Price Per Share", costPricePerShare))
            add(ShareItem("Total Payable Amount", totalPayableAmount))
        })
    }

    fun setupListAdapter(dataList: ArrayList<ShareItem>) = doAsync {
        uiThread {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            val adapter = ShareCalcListAdapter(dataList) {
            }
            recyclerView.adapter = adapter
        }

    }

    private fun checkValues() {
        try {

            var quantity = parseInt(shareQuantityEditText.text.toString())
            var price = parseDouble(sharePriceEditText.text.toString())

            if (quantity == null)
                quantity = 0
            if (price == null)
                price = 0.0

            calculateTotalAmount(quantity, price)
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * setup share quantity textwatcher
     */
    private fun setupQuantityTextWatcher() {
        var timer: Timer? = Timer()
        shareQuantityEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                timer?.cancel()
            }

            override fun afterTextChanged(s: Editable) {
                timer = Timer()
                timer!!.schedule(object : TimerTask() {
                    override fun run() {
                        activity.runOnUiThread {
                            checkValues()
                        }
                    }
                }, 1000)
            }
        })

    }

    /**
     * setup share price textwatcher
     */
    private fun setupPriceTextWatcher() {
        var timer: Timer? = Timer()
        sharePriceEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                timer?.cancel()
            }

            override fun afterTextChanged(s: Editable) {
                timer = Timer()
                timer!!.schedule(object : TimerTask() {
                    override fun run() {
                        activity.runOnUiThread {
                            checkValues()
                        }
                    }
                }, 1000)
            }
        })

    }

    /**
     * transaction type spinner - BUY and SELL
     */
    private fun setupTypeSpinner() {
        val txnTypeList = listOf("Buy", "Sell")
        val adapter = ArrayAdapter(activity, R.layout.row_spn, txnTypeList)
        adapter.setDropDownViewResource(R.layout.row_spn_dropdown)
        txnTypeSpinnner.adapter = adapter
    }

    override fun fragmentVisible() {
        super.fragmentVisible()
        (activity as ToolsChildActivity).setToolbarTitle(getString(R.string.share_calculator))
    }
}
