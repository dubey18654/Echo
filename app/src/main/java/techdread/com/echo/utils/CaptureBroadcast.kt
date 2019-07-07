package techdread.com.echo.utils

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.telephony.TelephonyManager
import techdread.com.echo.R
import techdread.com.echo.activties.MainActivity
import techdread.com.echo.activties.MainActivity.Statified.notificationManager
import techdread.com.echo.fragments.SongPlayingFragment


internal class CaptureBroadcast : BroadcastReceiver() {

    object Statified {
        var incomingFlag = false

    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_NEW_OUTGOING_CALL) {


            try {
                notificationManager?.cancel(1978)
            } catch (ee: Exception) {
                ee.printStackTrace()
            }
            try {
                if (SongPlayingFragment.Statified.mediaPlayer?.isPlaying as Boolean) {
                    (SongPlayingFragment.Statified.mediaPlayer as MediaPlayer).pause()
                    SongPlayingFragment.Statified.playpauseImageButton?.setBackgroundResource(R.drawable.ic_play_button)

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {
            val tm: TelephonyManager = context.getSystemService(Service.TELEPHONY_SERVICE) as TelephonyManager

            when (tm.callState) {

                TelephonyManager.CALL_STATE_RINGING -> {

                    try {
                        notificationManager?.cancel(1978)
                    } catch (ee: Exception) {
                        ee.printStackTrace()
                    }
                    try {
                        if (SongPlayingFragment.Statified.mediaPlayer?.isPlaying as Boolean) {
                            (SongPlayingFragment.Statified.mediaPlayer as MediaPlayer).pause()
                            SongPlayingFragment.Statified.playpauseImageButton?.setBackgroundResource(R.drawable.ic_play_button)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                TelephonyManager.CALL_STATE_IDLE -> {
                    CaptureBroadcast.Statified.incomingFlag = false
                    try {
                        notificationManager?.cancel(1978)
                    } catch (ee: Exception) {
                        ee.printStackTrace()
                    }

                    try {
                        if ((SongPlayingFragment.Statified.mediaPlayer?.isPlaying != true) as Boolean) {
                            (SongPlayingFragment.Statified.mediaPlayer as MediaPlayer).start()
                            SongPlayingFragment.Statified.playpauseImageButton?.setBackgroundResource(R.drawable.ic_pause_button)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                else -> {
                }
            }

        }

    }


}