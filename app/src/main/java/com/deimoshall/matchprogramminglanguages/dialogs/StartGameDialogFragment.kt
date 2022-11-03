package com.deimoshall.matchprogramminglanguages.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.deimoshall.matchprogramminglanguages.MainActivity
import com.deimoshall.matchprogramminglanguages.R

class StartGameDialogFragment() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.start_game_dialog, null))
                .setPositiveButton("Start",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // Start the game
                })
                .setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // Cancel the start of the game
                    dialog?.cancel()
                })
            // Create the dialog object and returned it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}