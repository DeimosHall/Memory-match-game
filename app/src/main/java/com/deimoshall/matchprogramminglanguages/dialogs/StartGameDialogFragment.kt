package com.deimoshall.matchprogramminglanguages.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.deimoshall.matchprogramminglanguages.MainActivity
import com.deimoshall.matchprogramminglanguages.R
import com.deimoshall.matchprogramminglanguages.databinding.StartGameDialogBinding

class StartGameDialogFragment(
    private val onSubmitClickListener: (String) -> Unit
) : DialogFragment() {
    private lateinit var binding: StartGameDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = StartGameDialogBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnCancel.setOnClickListener { dismiss() }

        binding.btnStart.setOnClickListener {
            onSubmitClickListener.invoke(binding.etAttemptsNumber.text.toString())
            dismiss()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}