package com.febatis.flappyexemplo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.febatis.flappyexemplo.activity.MainActivity;

public class GameBroadcast extends BroadcastReceiver {

    MainActivity mainActivity;

    public GameBroadcast(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mainActivity.iniciarGame();
    }
}
