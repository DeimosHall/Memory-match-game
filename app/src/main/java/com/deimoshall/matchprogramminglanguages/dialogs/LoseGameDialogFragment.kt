package com.deimoshall.matchprogramminglanguages.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.deimoshall.matchprogramminglanguages.databinding.LoseGameDialogBinding

class LoseGameDialogFragment(
    private val onSubmitClickListener: () -> Unit
) : DialogFragment() {
    private lateinit var binding: LoseGameDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = LoseGameDialogBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnClose.setOnClickListener { dismiss() }

        binding.btnPlayAgain.setOnClickListener {
            onSubmitClickListener.invoke()
            dismiss()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}